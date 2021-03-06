package org.eclipse.xtext.java.resource

import java.util.ArrayList
import java.util.Map
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader
import org.eclipse.jdt.internal.compiler.env.INameEnvironment
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions

@FinalFieldsConstructor class IndexAwareNameEnvironment implements INameEnvironment {

	val ClassLoader classLoader
	val IResourceDescriptions resourceDescriptions
	val EObjectDescriptionBasedStubGenerator stubGenerator

	Map<QualifiedName, NameEnvironmentAnswer> cache = newHashMap()
	
	override cleanup() {
		cache.clear
	}

	override findType(char[][] compoundTypeName) {
		val className = QualifiedName.create(compoundTypeName.map[String.valueOf(it)])
		return findType(className)
	}
	
	def findType(QualifiedName className) {
		if (cache.containsKey(className)) {
			return cache.get(className)
		}
		val candidate = resourceDescriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, className, false).head
		var NameEnvironmentAnswer result = null 
		if (candidate != null) {
			val resourceDescription = resourceDescriptions.getResourceDescription(candidate.EObjectURI.trimFragment)
			val source = stubGenerator.getJavaStubSource(candidate, resourceDescription)
			result = new NameEnvironmentAnswer(new CompilationUnit(source.toCharArray, className.toString('/')+'.java', null), null)
		} else {
			val fileName = className.toString('/') + ".class"
			val url = classLoader.getResource(fileName)
			if (url == null) {
				cache.put(className, null)
				return null;
			}
			val reader = ClassFileReader.read(url.openStream, fileName)
			result = new NameEnvironmentAnswer(reader, null)
		}
		cache.put(className, result)
		return result
	}

	override findType(char[] typeName, char[][] packageName) {
		val list = new ArrayList(packageName.map[String.valueOf(it)])
		list += String.valueOf(typeName)
		val className = QualifiedName.create(list)
		return findType(className)
	}

	override isPackage(char[][] parentPackageName, char[] packageName) {
		// Working hack
		return Character.isLowerCase(packageName.head)
	}
}	
