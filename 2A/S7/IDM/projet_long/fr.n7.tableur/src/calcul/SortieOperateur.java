/**
 */
package calcul;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sortie Operateur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.SortieOperateur#getSuivant <em>Suivant</em>}</li>
 *   <li>{@link calcul.SortieOperateur#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getSortieOperateur()
 * @model
 * @generated
 */
public interface SortieOperateur extends Sortie {
	/**
	 * Returns the value of the '<em><b>Suivant</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link calcul.EntreeOperateur#getPrecedent <em>Precedent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suivant</em>' reference.
	 * @see #setSuivant(EntreeOperateur)
	 * @see calcul.CalculPackage#getSortieOperateur_Suivant()
	 * @see calcul.EntreeOperateur#getPrecedent
	 * @model opposite="precedent" required="true"
	 * @generated
	 */
	EntreeOperateur getSuivant();

	/**
	 * Sets the value of the '{@link calcul.SortieOperateur#getSuivant <em>Suivant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suivant</em>' reference.
	 * @see #getSuivant()
	 * @generated
	 */
	void setSuivant(EntreeOperateur value);

	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' reference.
	 * @see #setOperateur(Operateur)
	 * @see calcul.CalculPackage#getSortieOperateur_Operateur()
	 * @model required="true"
	 * @generated
	 */
	Operateur getOperateur();

	/**
	 * Sets the value of the '{@link calcul.SortieOperateur#getOperateur <em>Operateur</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operateur</em>' reference.
	 * @see #getOperateur()
	 * @generated
	 */
	void setOperateur(Operateur value);

} // SortieOperateur
