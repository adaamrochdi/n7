/**
 */
package table;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.Script#getNom <em>Nom</em>}</li>
 *   <li>{@link table.Script#getSortie <em>Sortie</em>}</li>
 *   <li>{@link table.Script#getEntree <em>Entree</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getScript()
 * @model
 * @generated
 */
public interface Script extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see table.TablePackage#getScript_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link table.Script#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Sortie</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link table.ColonneDeriv#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sortie</em>' reference.
	 * @see #setSortie(ColonneDeriv)
	 * @see table.TablePackage#getScript_Sortie()
	 * @see table.ColonneDeriv#getScript
	 * @model opposite="script" required="true"
	 * @generated
	 */
	ColonneDeriv getSortie();

	/**
	 * Sets the value of the '{@link table.Script#getSortie <em>Sortie</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sortie</em>' reference.
	 * @see #getSortie()
	 * @generated
	 */
	void setSortie(ColonneDeriv value);

	/**
	 * Returns the value of the '<em><b>Entree</b></em>' reference list.
	 * The list contents are of type {@link table.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entree</em>' reference list.
	 * @see table.TablePackage#getScript_Entree()
	 * @model required="true"
	 * @generated
	 */
	EList<Colonne> getEntree();

} // Script
