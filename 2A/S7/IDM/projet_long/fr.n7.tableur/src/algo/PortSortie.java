/**
 */
package algo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import table.ColonneDeriv;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Sortie</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link algo.PortSortie#getCols <em>Cols</em>}</li>
 *   <li>{@link algo.PortSortie#getAlgorithme <em>Algorithme</em>}</li>
 * </ul>
 *
 * @see algo.AlgoPackage#getPortSortie()
 * @model
 * @generated
 */
public interface PortSortie extends EObject {

	/**
	 * Returns the value of the '<em><b>Cols</b></em>' reference list.
	 * The list contents are of type {@link table.ColonneDeriv}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cols</em>' reference list.
	 * @see algo.AlgoPackage#getPortSortie_Cols()
	 * @model
	 * @generated
	 */
	EList<ColonneDeriv> getCols();

	/**
	 * Returns the value of the '<em><b>Algorithme</b></em>' containment reference list.
	 * The list contents are of type {@link algo.Algorithme}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithme</em>' containment reference list.
	 * @see algo.AlgoPackage#getPortSortie_Algorithme()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Algorithme> getAlgorithme();
} // PortSortie
