/**
 */
package calcul;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.Operateur#getSortie <em>Sortie</em>}</li>
 *   <li>{@link calcul.Operateur#getEntreePrincipale <em>Entree Principale</em>}</li>
 *   <li>{@link calcul.Operateur#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getOperateur()
 * @model abstract="true"
 * @generated
 */
public interface Operateur extends EObject {
	/**
	 * Returns the value of the '<em><b>Sortie</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sortie</em>' containment reference.
	 * @see #setSortie(Sortie)
	 * @see calcul.CalculPackage#getOperateur_Sortie()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Sortie getSortie();

	/**
	 * Sets the value of the '{@link calcul.Operateur#getSortie <em>Sortie</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sortie</em>' containment reference.
	 * @see #getSortie()
	 * @generated
	 */
	void setSortie(Sortie value);

	/**
	 * Returns the value of the '<em><b>Entree Principale</b></em>' containment reference list.
	 * The list contents are of type {@link calcul.Entree}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entree Principale</em>' containment reference list.
	 * @see calcul.CalculPackage#getOperateur_EntreePrincipale()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Entree> getEntreePrincipale();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see calcul.CalculPackage#getOperateur_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link calcul.Operateur#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Operateur
