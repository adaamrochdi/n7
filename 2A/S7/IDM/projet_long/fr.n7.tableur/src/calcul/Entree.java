/**
 */
package calcul;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.Entree#getOrdre <em>Ordre</em>}</li>
 *   <li>{@link calcul.Entree#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getEntree()
 * @model abstract="true"
 * @generated
 */
public interface Entree extends EObject {
	/**
	 * Returns the value of the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordre</em>' attribute.
	 * @see #setOrdre(int)
	 * @see calcul.CalculPackage#getEntree_Ordre()
	 * @model required="true"
	 * @generated
	 */
	int getOrdre();

	/**
	 * Sets the value of the '{@link calcul.Entree#getOrdre <em>Ordre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordre</em>' attribute.
	 * @see #getOrdre()
	 * @generated
	 */
	void setOrdre(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link calcul.TypeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #setType(TypeElement)
	 * @see calcul.CalculPackage#getEntree_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeElement getType();

	/**
	 * Sets the value of the '{@link calcul.Entree#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeElement value);

} // Entree
