/**
 */
package table;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.Colonne#getNom <em>Nom</em>}</li>
 *   <li>{@link table.Colonne#getId <em>Id</em>}</li>
 *   <li>{@link table.Colonne#getValeurs <em>Valeurs</em>}</li>
 *   <li>{@link table.Colonne#getContrainte <em>Contrainte</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getColonne()
 * @model abstract="true"
 * @generated
 */
public interface Colonne extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see table.TablePackage#getColonne_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link table.Colonne#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see table.TablePackage#getColonne_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link table.Colonne#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Valeurs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valeurs</em>' attribute list.
	 * @see table.TablePackage#getColonne_Valeurs()
	 * @model
	 * @generated
	 */
	EList<Float> getValeurs();

	/**
	 * Returns the value of the '<em><b>Contrainte</b></em>' containment reference list.
	 * The list contents are of type {@link table.Contrainte}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contrainte</em>' containment reference list.
	 * @see table.TablePackage#getColonne_Contrainte()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contrainte> getContrainte();

} // Colonne
