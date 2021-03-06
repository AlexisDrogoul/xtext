/**
 */
package org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLangPackage
 * @generated
 */
public interface ContentAssistFragmentTestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistFragmentTestLangFactory eINSTANCE = org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Content Assist Fragment Test Language Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Content Assist Fragment Test Language Root</em>'.
   * @generated
   */
  ContentAssistFragmentTestLanguageRoot createContentAssistFragmentTestLanguageRoot();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ContentAssistFragmentTestLangPackage getContentAssistFragmentTestLangPackage();

} //ContentAssistFragmentTestLangFactory
