/**
 */
package algo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import table.Colonne;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Entree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link algo.PortEntree#getCole <em>Cole</em>}</li>
 * </ul>
 *
 * @see algo.AlgoPackage#getPortEntree()
 * @model
 * @generated
 */
public interface PortEntree extends EObject {

	/**
	 * Returns the value of the '<em><b>Cole</b></em>' reference list.
	 * The list contents are of type {@link table.Colonne}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cole</em>' reference list.
	 * @see algo.AlgoPackage#getPortEntree_Cole()
	 * @model required="true"
	 * @generated
	 */
	EList<Colonne> getCole();
} // PortEntree
