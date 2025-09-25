/**
 */
package algo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link algo.Algorithme#getScript <em>Script</em>}</li>
 *   <li>{@link algo.Algorithme#getPortentree <em>Portentree</em>}</li>
 * </ul>
 *
 * @see algo.AlgoPackage#getAlgorithme()
 * @model
 * @generated
 */
public interface Algorithme extends EObject {
	/**
	 * Returns the value of the '<em><b>Script</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' reference.
	 * @see #setScript(Script)
	 * @see algo.AlgoPackage#getAlgorithme_Script()
	 * @model required="true"
	 * @generated
	 */
	Script getScript();

	/**
	 * Sets the value of the '{@link algo.Algorithme#getScript <em>Script</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script</em>' reference.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(Script value);

	/**
	 * Returns the value of the '<em><b>Portentree</b></em>' containment reference list.
	 * The list contents are of type {@link algo.PortEntree}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Portentree</em>' containment reference list.
	 * @see algo.AlgoPackage#getAlgorithme_Portentree()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PortEntree> getPortentree();

} // Algorithme
