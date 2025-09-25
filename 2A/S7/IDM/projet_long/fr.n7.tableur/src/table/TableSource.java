/**
 */
package table;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.TableSource#getColonnesaisie <em>Colonnesaisie</em>}</li>
 *   <li>{@link table.TableSource#getColonneid <em>Colonneid</em>}</li>
 *   <li>{@link table.TableSource#getNom <em>Nom</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getTableSource()
 * @model
 * @generated
 */
public interface TableSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Colonnesaisie</b></em>' containment reference list.
	 * The list contents are of type {@link table.ColonneSaisie}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonnesaisie</em>' containment reference list.
	 * @see table.TablePackage#getTableSource_Colonnesaisie()
	 * @model containment="true"
	 * @generated
	 */
	EList<ColonneSaisie> getColonnesaisie();

	/**
	 * Returns the value of the '<em><b>Colonneid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonneid</em>' containment reference.
	 * @see #setColonneid(ColonneId)
	 * @see table.TablePackage#getTableSource_Colonneid()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ColonneId getColonneid();

	/**
	 * Sets the value of the '{@link table.TableSource#getColonneid <em>Colonneid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colonneid</em>' containment reference.
	 * @see #getColonneid()
	 * @generated
	 */
	void setColonneid(ColonneId value);

	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see table.TablePackage#getTableSource_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link table.TableSource#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

} // TableSource
