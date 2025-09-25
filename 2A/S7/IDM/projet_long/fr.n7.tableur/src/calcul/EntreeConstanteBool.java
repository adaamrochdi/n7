/**
 */
package calcul;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entree Constante Bool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.EntreeConstanteBool#isValeur <em>Valeur</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getEntreeConstanteBool()
 * @model
 * @generated
 */
public interface EntreeConstanteBool extends EntreeConstante {
	/**
	 * Returns the value of the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valeur</em>' attribute.
	 * @see #setValeur(boolean)
	 * @see calcul.CalculPackage#getEntreeConstanteBool_Valeur()
	 * @model required="true"
	 * @generated
	 */
	boolean isValeur();

	/**
	 * Sets the value of the '{@link calcul.EntreeConstanteBool#isValeur <em>Valeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valeur</em>' attribute.
	 * @see #isValeur()
	 * @generated
	 */
	void setValeur(boolean value);

} // EntreeConstanteBool
