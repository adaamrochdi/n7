/**
 */
package calcul;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calcul</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.Calcul#getOperateur <em>Operateur</em>}</li>
 *   <li>{@link calcul.Calcul#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getCalcul()
 * @model
 * @generated
 */
public interface Calcul extends EObject {
	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' containment reference list.
	 * The list contents are of type {@link calcul.Operateur}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' containment reference list.
	 * @see calcul.CalculPackage#getCalcul_Operateur()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Operateur> getOperateur();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see calcul.CalculPackage#getCalcul_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link calcul.Calcul#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Calcul
