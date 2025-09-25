/**
 */
package table;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contrainte Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.ContrainteOperation#getType <em>Type</em>}</li>
 *   <li>{@link table.ContrainteOperation#getVComparee <em>VComparee</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getContrainteOperation()
 * @model
 * @generated
 */
public interface ContrainteOperation extends Contrainte {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link table.OpContrainte}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see table.OpContrainte
	 * @see #setType(OpContrainte)
	 * @see table.TablePackage#getContrainteOperation_Type()
	 * @model
	 * @generated
	 */
	OpContrainte getType();

	/**
	 * Sets the value of the '{@link table.ContrainteOperation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see table.OpContrainte
	 * @see #getType()
	 * @generated
	 */
	void setType(OpContrainte value);

	/**
	 * Returns the value of the '<em><b>VComparee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VComparee</em>' attribute.
	 * @see #setVComparee(float)
	 * @see table.TablePackage#getContrainteOperation_VComparee()
	 * @model
	 * @generated
	 */
	float getVComparee();

	/**
	 * Sets the value of the '{@link table.ContrainteOperation#getVComparee <em>VComparee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VComparee</em>' attribute.
	 * @see #getVComparee()
	 * @generated
	 */
	void setVComparee(float value);

} // ContrainteOperation
