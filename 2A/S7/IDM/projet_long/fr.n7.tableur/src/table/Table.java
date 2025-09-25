/**
 */
package table;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.Table#getNom <em>Nom</em>}</li>
 *   <li>{@link table.Table#getTablesource <em>Tablesource</em>}</li>
 *   <li>{@link table.Table#getTableresultante <em>Tableresultante</em>}</li>
 *   <li>{@link table.Table#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see table.TablePackage#getTable_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link table.Table#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Tablesource</b></em>' containment reference list.
	 * The list contents are of type {@link table.TableSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tablesource</em>' containment reference list.
	 * @see table.TablePackage#getTable_Tablesource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TableSource> getTablesource();

	/**
	 * Returns the value of the '<em><b>Tableresultante</b></em>' containment reference list.
	 * The list contents are of type {@link table.TableResultante}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tableresultante</em>' containment reference list.
	 * @see table.TablePackage#getTable_Tableresultante()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TableResultante> getTableresultante();

	/**
	 * Returns the value of the '<em><b>Script</b></em>' containment reference list.
	 * The list contents are of type {@link table.Script}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' containment reference list.
	 * @see table.TablePackage#getTable_Script()
	 * @model containment="true"
	 * @generated
	 */
	EList<Script> getScript();

} // Table
