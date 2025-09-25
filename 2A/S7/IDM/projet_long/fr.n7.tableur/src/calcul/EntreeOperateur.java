/**
 */
package calcul;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entree Operateur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link calcul.EntreeOperateur#getPrecedent <em>Precedent</em>}</li>
 *   <li>{@link calcul.EntreeOperateur#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @see calcul.CalculPackage#getEntreeOperateur()
 * @model
 * @generated
 */
public interface EntreeOperateur extends Entree {
	/**
	 * Returns the value of the '<em><b>Precedent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link calcul.SortieOperateur#getSuivant <em>Suivant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedent</em>' reference.
	 * @see #setPrecedent(SortieOperateur)
	 * @see calcul.CalculPackage#getEntreeOperateur_Precedent()
	 * @see calcul.SortieOperateur#getSuivant
	 * @model opposite="suivant" required="true"
	 * @generated
	 */
	SortieOperateur getPrecedent();

	/**
	 * Sets the value of the '{@link calcul.EntreeOperateur#getPrecedent <em>Precedent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedent</em>' reference.
	 * @see #getPrecedent()
	 * @generated
	 */
	void setPrecedent(SortieOperateur value);

	/**
	 * Returns the value of the '<em><b>Operateur</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operateur</em>' reference.
	 * @see #setOperateur(Operateur)
	 * @see calcul.CalculPackage#getEntreeOperateur_Operateur()
	 * @model required="true"
	 * @generated
	 */
	Operateur getOperateur();

	/**
	 * Sets the value of the '{@link calcul.EntreeOperateur#getOperateur <em>Operateur</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operateur</em>' reference.
	 * @see #getOperateur()
	 * @generated
	 */
	void setOperateur(Operateur value);

} // EntreeOperateur
