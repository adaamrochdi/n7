/**
 */
package table;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colonne Deriv</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link table.ColonneDeriv#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @see table.TablePackage#getColonneDeriv()
 * @model
 * @generated
 */
public interface ColonneDeriv extends Colonne {

	/**
	 * Returns the value of the '<em><b>Script</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link table.Script#getSortie <em>Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' reference.
	 * @see #setScript(Script)
	 * @see table.TablePackage#getColonneDeriv_Script()
	 * @see table.Script#getSortie
	 * @model opposite="sortie" required="true"
	 * @generated
	 */
	Script getScript();

	/**
	 * Sets the value of the '{@link table.ColonneDeriv#getScript <em>Script</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script</em>' reference.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(Script value);
} // ColonneDeriv
