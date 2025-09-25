/**
 */
package table;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resultante</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.TableResultante#getColonneidresultante <em>Colonneidresultante</em>}</li>
 *   <li>{@link table.TableResultante#getColonnesaisieres <em>Colonnesaisieres</em>}</li>
 *   <li>{@link table.TableResultante#getColonnederiv <em>Colonnederiv</em>}</li>
 *   <li>{@link table.TableResultante#getNom <em>Nom</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getTableResultante()
 * @model
 * @generated
 */
public interface TableResultante extends EObject {
	/**
	 * Returns the value of the '<em><b>Colonneidresultante</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonneidresultante</em>' containment reference.
	 * @see #setColonneidresultante(colonneIdResultante)
	 * @see table.TablePackage#getTableResultante_Colonneidresultante()
	 * @model containment="true" required="true"
	 * @generated
	 */
	colonneIdResultante getColonneidresultante();

	/**
	 * Sets the value of the '{@link table.TableResultante#getColonneidresultante <em>Colonneidresultante</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colonneidresultante</em>' containment reference.
	 * @see #getColonneidresultante()
	 * @generated
	 */
	void setColonneidresultante(colonneIdResultante value);

	/**
	 * Returns the value of the '<em><b>Colonnesaisieres</b></em>' containment reference list.
	 * The list contents are of type {@link table.ColonneSaisieRes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonnesaisieres</em>' containment reference list.
	 * @see table.TablePackage#getTableResultante_Colonnesaisieres()
	 * @model containment="true"
	 * @generated
	 */
	EList<ColonneSaisieRes> getColonnesaisieres();

	/**
	 * Returns the value of the '<em><b>Colonnederiv</b></em>' containment reference list.
	 * The list contents are of type {@link table.ColonneDeriv}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colonnederiv</em>' containment reference list.
	 * @see table.TablePackage#getTableResultante_Colonnederiv()
	 * @model containment="true"
	 * @generated
	 */
	EList<ColonneDeriv> getColonnederiv();

	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see table.TablePackage#getTableResultante_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link table.TableResultante#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

} // TableResultante
