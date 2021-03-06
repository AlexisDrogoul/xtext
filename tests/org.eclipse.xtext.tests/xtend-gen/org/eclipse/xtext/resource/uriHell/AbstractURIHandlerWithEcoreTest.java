/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.resource.uriHell.AbstractURIHandlerTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractURIHandlerWithEcoreTest extends AbstractURIHandlerTest {
  @Override
  public void setUp() {
    super.setUp();
    final EcoreFactory factory = EcoreFactory.eINSTANCE;
    final EClass baseClass = factory.createEClass();
    baseClass.setName("Base");
    EList<EObject> _contents = this.primaryResource.getContents();
    _contents.add(baseClass);
    final EClass superClass = factory.createEClass();
    superClass.setName("SuperClass");
    EList<EObject> _contents_1 = this.referencedResource.getContents();
    _contents_1.add(superClass);
    EList<EClass> _eSuperTypes = baseClass.getESuperTypes();
    _eSuperTypes.add(superClass);
  }
}
