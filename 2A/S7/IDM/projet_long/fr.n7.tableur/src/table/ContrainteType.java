/**
 */
package table;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contrainte Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.ContrainteType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getContrainteType()
 * @model
 * @generated
 */
public interface ContrainteType extends Contrainte {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link table.TypeElements}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see table.TypeElements
	 * @see #setType(TypeElements)
	 * @see table.TablePackage#getContrainteType_Type()
	 * @model
	 * @generated
	 */
	TypeElements getType();

	/**
	 * Sets the value of the '{@link table.ContrainteType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see table.TypeElements
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeElements value);

} // ContrainteType
