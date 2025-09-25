/**
 */
package calcul;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see calcul.CalculPackage
 * @generated
 */
public interface CalculFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CalculFactory eINSTANCE = calcul.impl.CalculFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Calcul</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calcul</em>'.
	 * @generated
	 */
	Calcul createCalcul();

	/**
	 * Returns a new object of class '<em>Sortie Operateur</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sortie Operateur</em>'.
	 * @generated
	 */
	SortieOperateur createSortieOperateur();

	/**
	 * Returns a new object of class '<em>Port Sortie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Sortie</em>'.
	 * @generated
	 */
	PortSortie createPortSortie();

	/**
	 * Returns a new object of class '<em>Port Entree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Entree</em>'.
	 * @generated
	 */
	PortEntree createPortEntree();

	/**
	 * Returns a new object of class '<em>Entree Operateur</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entree Operateur</em>'.
	 * @generated
	 */
	EntreeOperateur createEntreeOperateur();

	/**
	 * Returns a new object of class '<em>Operateur Binaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operateur Binaire</em>'.
	 * @generated
	 */
	OperateurBinaire createOperateurBinaire();

	/**
	 * Returns a new object of class '<em>Operateur Unaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operateur Unaire</em>'.
	 * @generated
	 */
	OperateurUnaire createOperateurUnaire();

	/**
	 * Returns a new object of class '<em>Entree Constante Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entree Constante Int</em>'.
	 * @generated
	 */
	EntreeConstanteInt createEntreeConstanteInt();

	/**
	 * Returns a new object of class '<em>Entree Constante String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entree Constante String</em>'.
	 * @generated
	 */
	EntreeConstanteString createEntreeConstanteString();

	/**
	 * Returns a new object of class '<em>Entree Constante Bool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entree Constante Bool</em>'.
	 * @generated
	 */
	EntreeConstanteBool createEntreeConstanteBool();

	/**
	 * Returns a new object of class '<em>Entree Constante Float</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entree Constante Float</em>'.
	 * @generated
	 */
	EntreeConstanteFloat createEntreeConstanteFloat();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CalculPackage getCalculPackage();

} //CalculFactory
