/**
 */
package algo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see algo.AlgoFactory
 * @model kind="package"
 * @generated
 */
public interface AlgoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "algo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://algo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "algo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlgoPackage eINSTANCE = algo.impl.AlgoPackageImpl.init();

	/**
	 * The meta object id for the '{@link algo.impl.AlgorithmeImpl <em>Algorithme</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algo.impl.AlgorithmeImpl
	 * @see algo.impl.AlgoPackageImpl#getAlgorithme()
	 * @generated
	 */
	int ALGORITHME = 0;

	/**
	 * The feature id for the '<em><b>Script</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME__SCRIPT = 0;

	/**
	 * The feature id for the '<em><b>Portentree</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME__PORTENTREE = 1;

	/**
	 * The number of structural features of the '<em>Algorithme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Algorithme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algo.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algo.impl.ScriptImpl
	 * @see algo.impl.AlgoPackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algo.impl.PortEntreeImpl <em>Port Entree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algo.impl.PortEntreeImpl
	 * @see algo.impl.AlgoPackageImpl#getPortEntree()
	 * @generated
	 */
	int PORT_ENTREE = 2;

	/**
	 * The feature id for the '<em><b>Cole</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE__COLE = 0;

	/**
	 * The number of structural features of the '<em>Port Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Port Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link algo.impl.PortSortieImpl <em>Port Sortie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see algo.impl.PortSortieImpl
	 * @see algo.impl.AlgoPackageImpl#getPortSortie()
	 * @generated
	 */
	int PORT_SORTIE = 3;

	/**
	 * The feature id for the '<em><b>Cols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE__COLS = 0;

	/**
	 * The feature id for the '<em><b>Algorithme</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE__ALGORITHME = 1;

	/**
	 * The number of structural features of the '<em>Port Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Port Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link algo.Algorithme <em>Algorithme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithme</em>'.
	 * @see algo.Algorithme
	 * @generated
	 */
	EClass getAlgorithme();

	/**
	 * Returns the meta object for the reference '{@link algo.Algorithme#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Script</em>'.
	 * @see algo.Algorithme#getScript()
	 * @see #getAlgorithme()
	 * @generated
	 */
	EReference getAlgorithme_Script();

	/**
	 * Returns the meta object for the containment reference list '{@link algo.Algorithme#getPortentree <em>Portentree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Portentree</em>'.
	 * @see algo.Algorithme#getPortentree()
	 * @see #getAlgorithme()
	 * @generated
	 */
	EReference getAlgorithme_Portentree();

	/**
	 * Returns the meta object for class '{@link algo.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see algo.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the attribute '{@link algo.Script#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see algo.Script#getName()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Name();

	/**
	 * Returns the meta object for class '{@link algo.PortEntree <em>Port Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Entree</em>'.
	 * @see algo.PortEntree
	 * @generated
	 */
	EClass getPortEntree();

	/**
	 * Returns the meta object for the reference list '{@link algo.PortEntree#getCole <em>Cole</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cole</em>'.
	 * @see algo.PortEntree#getCole()
	 * @see #getPortEntree()
	 * @generated
	 */
	EReference getPortEntree_Cole();

	/**
	 * Returns the meta object for class '{@link algo.PortSortie <em>Port Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Sortie</em>'.
	 * @see algo.PortSortie
	 * @generated
	 */
	EClass getPortSortie();

	/**
	 * Returns the meta object for the reference list '{@link algo.PortSortie#getCols <em>Cols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cols</em>'.
	 * @see algo.PortSortie#getCols()
	 * @see #getPortSortie()
	 * @generated
	 */
	EReference getPortSortie_Cols();

	/**
	 * Returns the meta object for the containment reference list '{@link algo.PortSortie#getAlgorithme <em>Algorithme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Algorithme</em>'.
	 * @see algo.PortSortie#getAlgorithme()
	 * @see #getPortSortie()
	 * @generated
	 */
	EReference getPortSortie_Algorithme();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AlgoFactory getAlgoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link algo.impl.AlgorithmeImpl <em>Algorithme</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algo.impl.AlgorithmeImpl
		 * @see algo.impl.AlgoPackageImpl#getAlgorithme()
		 * @generated
		 */
		EClass ALGORITHME = eINSTANCE.getAlgorithme();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHME__SCRIPT = eINSTANCE.getAlgorithme_Script();

		/**
		 * The meta object literal for the '<em><b>Portentree</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHME__PORTENTREE = eINSTANCE.getAlgorithme_Portentree();

		/**
		 * The meta object literal for the '{@link algo.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algo.impl.ScriptImpl
		 * @see algo.impl.AlgoPackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__NAME = eINSTANCE.getScript_Name();

		/**
		 * The meta object literal for the '{@link algo.impl.PortEntreeImpl <em>Port Entree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algo.impl.PortEntreeImpl
		 * @see algo.impl.AlgoPackageImpl#getPortEntree()
		 * @generated
		 */
		EClass PORT_ENTREE = eINSTANCE.getPortEntree();

		/**
		 * The meta object literal for the '<em><b>Cole</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_ENTREE__COLE = eINSTANCE.getPortEntree_Cole();

		/**
		 * The meta object literal for the '{@link algo.impl.PortSortieImpl <em>Port Sortie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see algo.impl.PortSortieImpl
		 * @see algo.impl.AlgoPackageImpl#getPortSortie()
		 * @generated
		 */
		EClass PORT_SORTIE = eINSTANCE.getPortSortie();

		/**
		 * The meta object literal for the '<em><b>Cols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SORTIE__COLS = eINSTANCE.getPortSortie_Cols();

		/**
		 * The meta object literal for the '<em><b>Algorithme</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_SORTIE__ALGORITHME = eINSTANCE.getPortSortie_Algorithme();

	}

} //AlgoPackage
