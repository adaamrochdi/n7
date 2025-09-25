/**
 */
package calcul;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operateur Binaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.OperateurBinaire#getType <em>Type</em>}</li>
 *   <li>{@link calcul.OperateurBinaire#getOperandetype <em>Operandetype</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getOperateurBinaire()
 * @model
 * @generated
 */
public interface OperateurBinaire extends Operateur {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link calcul.OperationBType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see calcul.OperationBType
	 * @see #setType(OperationBType)
	 * @see calcul.CalculPackage#getOperateurBinaire_Type()
	 * @model required="true"
	 * @generated
	 */
	OperationBType getType();

	/**
	 * Sets the value of the '{@link calcul.OperateurBinaire#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see calcul.OperationBType
	 * @see #getType()
	 * @generated
	 */
	void setType(OperationBType value);

	/**
	 * Returns the value of the '<em><b>Operandetype</b></em>' attribute.
	 * The literals are from the enumeration {@link calcul.TypeElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operandetype</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #setOperandetype(TypeElement)
	 * @see calcul.CalculPackage#getOperateurBinaire_Operandetype()
	 * @model required="true"
	 * @generated
	 */
	TypeElement getOperandetype();

	/**
	 * Sets the value of the '{@link calcul.OperateurBinaire#getOperandetype <em>Operandetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operandetype</em>' attribute.
	 * @see calcul.TypeElement
	 * @see #getOperandetype()
	 * @generated
	 */
	void setOperandetype(TypeElement value);

} // OperateurBinaire
