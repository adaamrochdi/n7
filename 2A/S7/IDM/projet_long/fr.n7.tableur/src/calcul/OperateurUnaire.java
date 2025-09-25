/**
 */
package calcul;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur Unaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.OperateurUnaire#getType <em>Type</em>}</li>
 *   <li>{@link calcul.OperateurUnaire#getOperandetype <em>Operandetype</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getOperateurUnaire()
 * @model
 * @generated
 */
public interface OperateurUnaire extends Operateur {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link calcul.OperationUType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see calcul.OperationUType
	 * @see #setType(OperationUType)
	 * @see calcul.CalculPackage#getOperateurUnaire_Type()
	 * @model required="true"
	 * @generated
	 */
	OperationUType getType();

	/**
	 * Sets the value of the '{@link calcul.OperateurUnaire#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see calcul.OperationUType
	 * @see #getType()
	 * @generated
	 */
	void setType(OperationUType value);

	/**
	 * Returns the value of the '<em><b>Operandetype</b></em>' attribute.
	 * The literals are from the enumeration {@link calcul.TypeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operandetype</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #setOperandetype(TypeElement)
	 * @see calcul.CalculPackage#getOperateurUnaire_Operandetype()
	 * @model required="true"
	 * @generated
	 */
	TypeElement getOperandetype();

	/**
	 * Sets the value of the '{@link calcul.OperateurUnaire#getOperandetype <em>Operandetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operandetype</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #getOperandetype()
	 * @generated
	 */
	void setOperandetype(TypeElement value);

} // OperateurUnaire
