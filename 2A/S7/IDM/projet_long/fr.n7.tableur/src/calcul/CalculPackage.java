/**
 */
package calcul;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see calcul.CalculFactory
 * @model kind="package"
 * @generated
 */
public interface CalculPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "calcul";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://calcul";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "calcul";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CalculPackage eINSTANCE = calcul.impl.CalculPackageImpl.init();

	/**
	 * The meta object id for the '{@link calcul.impl.CalculImpl <em>Calcul</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.CalculImpl
	 * @see calcul.impl.CalculPackageImpl#getCalcul()
	 * @generated
	 */
	int CALCUL = 0;

	/**
	 * The feature id for the '<em><b>Operateur</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL__OPERATEUR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL__NAME = 1;

	/**
	 * The number of structural features of the '<em>Calcul</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Calcul</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCUL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link calcul.impl.OperateurImpl <em>Operateur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.OperateurImpl
	 * @see calcul.impl.CalculPackageImpl#getOperateur()
	 * @generated
	 */
	int OPERATEUR = 1;

	/**
	 * The feature id for the '<em><b>Sortie</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR__SORTIE = 0;

	/**
	 * The feature id for the '<em><b>Entree Principale</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR__ENTREE_PRINCIPALE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR__NAME = 2;

	/**
	 * The number of structural features of the '<em>Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeImpl <em>Entree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeImpl
	 * @see calcul.impl.CalculPackageImpl#getEntree()
	 * @generated
	 */
	int ENTREE = 2;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE__ORDRE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link calcul.impl.SortieImpl <em>Sortie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.SortieImpl
	 * @see calcul.impl.CalculPackageImpl#getSortie()
	 * @generated
	 */
	int SORTIE = 3;

	/**
	 * The number of structural features of the '<em>Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link calcul.impl.SortieOperateurImpl <em>Sortie Operateur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.SortieOperateurImpl
	 * @see calcul.impl.CalculPackageImpl#getSortieOperateur()
	 * @generated
	 */
	int SORTIE_OPERATEUR = 4;

	/**
	 * The feature id for the '<em><b>Suivant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_OPERATEUR__SUIVANT = SORTIE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operateur</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_OPERATEUR__OPERATEUR = SORTIE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sortie Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_OPERATEUR_FEATURE_COUNT = SORTIE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sortie Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORTIE_OPERATEUR_OPERATION_COUNT = SORTIE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.PortSortieImpl <em>Port Sortie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.PortSortieImpl
	 * @see calcul.impl.CalculPackageImpl#getPortSortie()
	 * @generated
	 */
	int PORT_SORTIE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE__NAME = SORTIE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE_FEATURE_COUNT = SORTIE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Port Sortie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_SORTIE_OPERATION_COUNT = SORTIE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.PortEntreeImpl <em>Port Entree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.PortEntreeImpl
	 * @see calcul.impl.CalculPackageImpl#getPortEntree()
	 * @generated
	 */
	int PORT_ENTREE = 6;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE__ORDRE = ENTREE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE__TYPE = ENTREE__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE__NAME = ENTREE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE_FEATURE_COUNT = ENTREE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Port Entree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_ENTREE_OPERATION_COUNT = ENTREE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeConstanteImpl <em>Entree Constante</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeConstanteImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeConstante()
	 * @generated
	 */
	int ENTREE_CONSTANTE = 7;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE__ORDRE = ENTREE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE__TYPE = ENTREE__TYPE;

	/**
	 * The number of structural features of the '<em>Entree Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FEATURE_COUNT = ENTREE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entree Constante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_OPERATION_COUNT = ENTREE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeOperateurImpl <em>Entree Operateur</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeOperateurImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeOperateur()
	 * @generated
	 */
	int ENTREE_OPERATEUR = 8;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR__ORDRE = ENTREE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR__TYPE = ENTREE__TYPE;

	/**
	 * The feature id for the '<em><b>Precedent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR__PRECEDENT = ENTREE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operateur</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR__OPERATEUR = ENTREE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entree Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR_FEATURE_COUNT = ENTREE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entree Operateur</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_OPERATEUR_OPERATION_COUNT = ENTREE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.OperateurBinaireImpl <em>Operateur Binaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.OperateurBinaireImpl
	 * @see calcul.impl.CalculPackageImpl#getOperateurBinaire()
	 * @generated
	 */
	int OPERATEUR_BINAIRE = 9;

	/**
	 * The feature id for the '<em><b>Sortie</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__SORTIE = OPERATEUR__SORTIE;

	/**
	 * The feature id for the '<em><b>Entree Principale</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__ENTREE_PRINCIPALE = OPERATEUR__ENTREE_PRINCIPALE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__NAME = OPERATEUR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__TYPE = OPERATEUR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operandetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE__OPERANDETYPE = OPERATEUR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operateur Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE_FEATURE_COUNT = OPERATEUR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operateur Binaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_BINAIRE_OPERATION_COUNT = OPERATEUR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.OperateurUnaireImpl <em>Operateur Unaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.OperateurUnaireImpl
	 * @see calcul.impl.CalculPackageImpl#getOperateurUnaire()
	 * @generated
	 */
	int OPERATEUR_UNAIRE = 10;

	/**
	 * The feature id for the '<em><b>Sortie</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__SORTIE = OPERATEUR__SORTIE;

	/**
	 * The feature id for the '<em><b>Entree Principale</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__ENTREE_PRINCIPALE = OPERATEUR__ENTREE_PRINCIPALE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__NAME = OPERATEUR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__TYPE = OPERATEUR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operandetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE__OPERANDETYPE = OPERATEUR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operateur Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE_FEATURE_COUNT = OPERATEUR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operateur Unaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATEUR_UNAIRE_OPERATION_COUNT = OPERATEUR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeConstanteIntImpl <em>Entree Constante Int</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeConstanteIntImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteInt()
	 * @generated
	 */
	int ENTREE_CONSTANTE_INT = 11;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_INT__ORDRE = ENTREE_CONSTANTE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_INT__TYPE = ENTREE_CONSTANTE__TYPE;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_INT__VALEUR = ENTREE_CONSTANTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entree Constante Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_INT_FEATURE_COUNT = ENTREE_CONSTANTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entree Constante Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_INT_OPERATION_COUNT = ENTREE_CONSTANTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeConstanteStringImpl <em>Entree Constante String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeConstanteStringImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteString()
	 * @generated
	 */
	int ENTREE_CONSTANTE_STRING = 12;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_STRING__ORDRE = ENTREE_CONSTANTE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_STRING__TYPE = ENTREE_CONSTANTE__TYPE;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_STRING__VALEUR = ENTREE_CONSTANTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entree Constante String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_STRING_FEATURE_COUNT = ENTREE_CONSTANTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entree Constante String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_STRING_OPERATION_COUNT = ENTREE_CONSTANTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeConstanteBoolImpl <em>Entree Constante Bool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeConstanteBoolImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteBool()
	 * @generated
	 */
	int ENTREE_CONSTANTE_BOOL = 13;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_BOOL__ORDRE = ENTREE_CONSTANTE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_BOOL__TYPE = ENTREE_CONSTANTE__TYPE;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_BOOL__VALEUR = ENTREE_CONSTANTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entree Constante Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_BOOL_FEATURE_COUNT = ENTREE_CONSTANTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entree Constante Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_BOOL_OPERATION_COUNT = ENTREE_CONSTANTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.impl.EntreeConstanteFloatImpl <em>Entree Constante Float</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.impl.EntreeConstanteFloatImpl
	 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteFloat()
	 * @generated
	 */
	int ENTREE_CONSTANTE_FLOAT = 14;

	/**
	 * The feature id for the '<em><b>Ordre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FLOAT__ORDRE = ENTREE_CONSTANTE__ORDRE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FLOAT__TYPE = ENTREE_CONSTANTE__TYPE;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FLOAT__VALEUR = ENTREE_CONSTANTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entree Constante Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FLOAT_FEATURE_COUNT = ENTREE_CONSTANTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entree Constante Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTREE_CONSTANTE_FLOAT_OPERATION_COUNT = ENTREE_CONSTANTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link calcul.OperationBType <em>Operation BType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.OperationBType
	 * @see calcul.impl.CalculPackageImpl#getOperationBType()
	 * @generated
	 */
	int OPERATION_BTYPE = 15;

	/**
	 * The meta object id for the '{@link calcul.OperationUType <em>Operation UType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.OperationUType
	 * @see calcul.impl.CalculPackageImpl#getOperationUType()
	 * @generated
	 */
	int OPERATION_UTYPE = 16;

	/**
	 * The meta object id for the '{@link calcul.TypeElement <em>Type Element</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see calcul.TypeElement
	 * @see calcul.impl.CalculPackageImpl#getTypeElement()
	 * @generated
	 */
	int TYPE_ELEMENT = 17;


	/**
	 * Returns the meta object for class '{@link calcul.Calcul <em>Calcul</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calcul</em>'.
	 * @see calcul.Calcul
	 * @generated
	 */
	EClass getCalcul();

	/**
	 * Returns the meta object for the containment reference list '{@link calcul.Calcul#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operateur</em>'.
	 * @see calcul.Calcul#getOperateur()
	 * @see #getCalcul()
	 * @generated
	 */
	EReference getCalcul_Operateur();

	/**
	 * Returns the meta object for the attribute '{@link calcul.Calcul#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see calcul.Calcul#getName()
	 * @see #getCalcul()
	 * @generated
	 */
	EAttribute getCalcul_Name();

	/**
	 * Returns the meta object for class '{@link calcul.Operateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operateur</em>'.
	 * @see calcul.Operateur
	 * @generated
	 */
	EClass getOperateur();

	/**
	 * Returns the meta object for the containment reference '{@link calcul.Operateur#getSortie <em>Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sortie</em>'.
	 * @see calcul.Operateur#getSortie()
	 * @see #getOperateur()
	 * @generated
	 */
	EReference getOperateur_Sortie();

	/**
	 * Returns the meta object for the containment reference list '{@link calcul.Operateur#getEntreePrincipale <em>Entree Principale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entree Principale</em>'.
	 * @see calcul.Operateur#getEntreePrincipale()
	 * @see #getOperateur()
	 * @generated
	 */
	EReference getOperateur_EntreePrincipale();

	/**
	 * Returns the meta object for the attribute '{@link calcul.Operateur#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see calcul.Operateur#getName()
	 * @see #getOperateur()
	 * @generated
	 */
	EAttribute getOperateur_Name();

	/**
	 * Returns the meta object for class '{@link calcul.Entree <em>Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree</em>'.
	 * @see calcul.Entree
	 * @generated
	 */
	EClass getEntree();

	/**
	 * Returns the meta object for the attribute '{@link calcul.Entree#getOrdre <em>Ordre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordre</em>'.
	 * @see calcul.Entree#getOrdre()
	 * @see #getEntree()
	 * @generated
	 */
	EAttribute getEntree_Ordre();

	/**
	 * Returns the meta object for the attribute '{@link calcul.Entree#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see calcul.Entree#getType()
	 * @see #getEntree()
	 * @generated
	 */
	EAttribute getEntree_Type();

	/**
	 * Returns the meta object for class '{@link calcul.Sortie <em>Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sortie</em>'.
	 * @see calcul.Sortie
	 * @generated
	 */
	EClass getSortie();

	/**
	 * Returns the meta object for class '{@link calcul.SortieOperateur <em>Sortie Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sortie Operateur</em>'.
	 * @see calcul.SortieOperateur
	 * @generated
	 */
	EClass getSortieOperateur();

	/**
	 * Returns the meta object for the reference '{@link calcul.SortieOperateur#getSuivant <em>Suivant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Suivant</em>'.
	 * @see calcul.SortieOperateur#getSuivant()
	 * @see #getSortieOperateur()
	 * @generated
	 */
	EReference getSortieOperateur_Suivant();

	/**
	 * Returns the meta object for the reference '{@link calcul.SortieOperateur#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operateur</em>'.
	 * @see calcul.SortieOperateur#getOperateur()
	 * @see #getSortieOperateur()
	 * @generated
	 */
	EReference getSortieOperateur_Operateur();

	/**
	 * Returns the meta object for class '{@link calcul.PortSortie <em>Port Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Sortie</em>'.
	 * @see calcul.PortSortie
	 * @generated
	 */
	EClass getPortSortie();

	/**
	 * Returns the meta object for the attribute '{@link calcul.PortSortie#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see calcul.PortSortie#getName()
	 * @see #getPortSortie()
	 * @generated
	 */
	EAttribute getPortSortie_Name();

	/**
	 * Returns the meta object for class '{@link calcul.PortEntree <em>Port Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Entree</em>'.
	 * @see calcul.PortEntree
	 * @generated
	 */
	EClass getPortEntree();

	/**
	 * Returns the meta object for the attribute '{@link calcul.PortEntree#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see calcul.PortEntree#getName()
	 * @see #getPortEntree()
	 * @generated
	 */
	EAttribute getPortEntree_Name();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeConstante <em>Entree Constante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Constante</em>'.
	 * @see calcul.EntreeConstante
	 * @generated
	 */
	EClass getEntreeConstante();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeOperateur <em>Entree Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Operateur</em>'.
	 * @see calcul.EntreeOperateur
	 * @generated
	 */
	EClass getEntreeOperateur();

	/**
	 * Returns the meta object for the reference '{@link calcul.EntreeOperateur#getPrecedent <em>Precedent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedent</em>'.
	 * @see calcul.EntreeOperateur#getPrecedent()
	 * @see #getEntreeOperateur()
	 * @generated
	 */
	EReference getEntreeOperateur_Precedent();

	/**
	 * Returns the meta object for the reference '{@link calcul.EntreeOperateur#getOperateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operateur</em>'.
	 * @see calcul.EntreeOperateur#getOperateur()
	 * @see #getEntreeOperateur()
	 * @generated
	 */
	EReference getEntreeOperateur_Operateur();

	/**
	 * Returns the meta object for class '{@link calcul.OperateurBinaire <em>Operateur Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operateur Binaire</em>'.
	 * @see calcul.OperateurBinaire
	 * @generated
	 */
	EClass getOperateurBinaire();

	/**
	 * Returns the meta object for the attribute '{@link calcul.OperateurBinaire#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see calcul.OperateurBinaire#getType()
	 * @see #getOperateurBinaire()
	 * @generated
	 */
	EAttribute getOperateurBinaire_Type();

	/**
	 * Returns the meta object for the attribute '{@link calcul.OperateurBinaire#getOperandetype <em>Operandetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operandetype</em>'.
	 * @see calcul.OperateurBinaire#getOperandetype()
	 * @see #getOperateurBinaire()
	 * @generated
	 */
	EAttribute getOperateurBinaire_Operandetype();

	/**
	 * Returns the meta object for class '{@link calcul.OperateurUnaire <em>Operateur Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operateur Unaire</em>'.
	 * @see calcul.OperateurUnaire
	 * @generated
	 */
	EClass getOperateurUnaire();

	/**
	 * Returns the meta object for the attribute '{@link calcul.OperateurUnaire#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see calcul.OperateurUnaire#getType()
	 * @see #getOperateurUnaire()
	 * @generated
	 */
	EAttribute getOperateurUnaire_Type();

	/**
	 * Returns the meta object for the attribute '{@link calcul.OperateurUnaire#getOperandetype <em>Operandetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operandetype</em>'.
	 * @see calcul.OperateurUnaire#getOperandetype()
	 * @see #getOperateurUnaire()
	 * @generated
	 */
	EAttribute getOperateurUnaire_Operandetype();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeConstanteInt <em>Entree Constante Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Constante Int</em>'.
	 * @see calcul.EntreeConstanteInt
	 * @generated
	 */
	EClass getEntreeConstanteInt();

	/**
	 * Returns the meta object for the attribute '{@link calcul.EntreeConstanteInt#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see calcul.EntreeConstanteInt#getValeur()
	 * @see #getEntreeConstanteInt()
	 * @generated
	 */
	EAttribute getEntreeConstanteInt_Valeur();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeConstanteString <em>Entree Constante String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Constante String</em>'.
	 * @see calcul.EntreeConstanteString
	 * @generated
	 */
	EClass getEntreeConstanteString();

	/**
	 * Returns the meta object for the attribute '{@link calcul.EntreeConstanteString#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see calcul.EntreeConstanteString#getValeur()
	 * @see #getEntreeConstanteString()
	 * @generated
	 */
	EAttribute getEntreeConstanteString_Valeur();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeConstanteBool <em>Entree Constante Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Constante Bool</em>'.
	 * @see calcul.EntreeConstanteBool
	 * @generated
	 */
	EClass getEntreeConstanteBool();

	/**
	 * Returns the meta object for the attribute '{@link calcul.EntreeConstanteBool#isValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see calcul.EntreeConstanteBool#isValeur()
	 * @see #getEntreeConstanteBool()
	 * @generated
	 */
	EAttribute getEntreeConstanteBool_Valeur();

	/**
	 * Returns the meta object for class '{@link calcul.EntreeConstanteFloat <em>Entree Constante Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entree Constante Float</em>'.
	 * @see calcul.EntreeConstanteFloat
	 * @generated
	 */
	EClass getEntreeConstanteFloat();

	/**
	 * Returns the meta object for the attribute '{@link calcul.EntreeConstanteFloat#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see calcul.EntreeConstanteFloat#getValeur()
	 * @see #getEntreeConstanteFloat()
	 * @generated
	 */
	EAttribute getEntreeConstanteFloat_Valeur();

	/**
	 * Returns the meta object for enum '{@link calcul.OperationBType <em>Operation BType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation BType</em>'.
	 * @see calcul.OperationBType
	 * @generated
	 */
	EEnum getOperationBType();

	/**
	 * Returns the meta object for enum '{@link calcul.OperationUType <em>Operation UType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation UType</em>'.
	 * @see calcul.OperationUType
	 * @generated
	 */
	EEnum getOperationUType();

	/**
	 * Returns the meta object for enum '{@link calcul.TypeElement <em>Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Element</em>'.
	 * @see calcul.TypeElement
	 * @generated
	 */
	EEnum getTypeElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CalculFactory getCalculFactory();

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
		 * The meta object literal for the '{@link calcul.impl.CalculImpl <em>Calcul</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.CalculImpl
		 * @see calcul.impl.CalculPackageImpl#getCalcul()
		 * @generated
		 */
		EClass CALCUL = eINSTANCE.getCalcul();

		/**
		 * The meta object literal for the '<em><b>Operateur</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALCUL__OPERATEUR = eINSTANCE.getCalcul_Operateur();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALCUL__NAME = eINSTANCE.getCalcul_Name();

		/**
		 * The meta object literal for the '{@link calcul.impl.OperateurImpl <em>Operateur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.OperateurImpl
		 * @see calcul.impl.CalculPackageImpl#getOperateur()
		 * @generated
		 */
		EClass OPERATEUR = eINSTANCE.getOperateur();

		/**
		 * The meta object literal for the '<em><b>Sortie</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATEUR__SORTIE = eINSTANCE.getOperateur_Sortie();

		/**
		 * The meta object literal for the '<em><b>Entree Principale</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATEUR__ENTREE_PRINCIPALE = eINSTANCE.getOperateur_EntreePrincipale();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR__NAME = eINSTANCE.getOperateur_Name();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeImpl <em>Entree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeImpl
		 * @see calcul.impl.CalculPackageImpl#getEntree()
		 * @generated
		 */
		EClass ENTREE = eINSTANCE.getEntree();

		/**
		 * The meta object literal for the '<em><b>Ordre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE__ORDRE = eINSTANCE.getEntree_Ordre();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE__TYPE = eINSTANCE.getEntree_Type();

		/**
		 * The meta object literal for the '{@link calcul.impl.SortieImpl <em>Sortie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.SortieImpl
		 * @see calcul.impl.CalculPackageImpl#getSortie()
		 * @generated
		 */
		EClass SORTIE = eINSTANCE.getSortie();

		/**
		 * The meta object literal for the '{@link calcul.impl.SortieOperateurImpl <em>Sortie Operateur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.SortieOperateurImpl
		 * @see calcul.impl.CalculPackageImpl#getSortieOperateur()
		 * @generated
		 */
		EClass SORTIE_OPERATEUR = eINSTANCE.getSortieOperateur();

		/**
		 * The meta object literal for the '<em><b>Suivant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORTIE_OPERATEUR__SUIVANT = eINSTANCE.getSortieOperateur_Suivant();

		/**
		 * The meta object literal for the '<em><b>Operateur</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORTIE_OPERATEUR__OPERATEUR = eINSTANCE.getSortieOperateur_Operateur();

		/**
		 * The meta object literal for the '{@link calcul.impl.PortSortieImpl <em>Port Sortie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.PortSortieImpl
		 * @see calcul.impl.CalculPackageImpl#getPortSortie()
		 * @generated
		 */
		EClass PORT_SORTIE = eINSTANCE.getPortSortie();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_SORTIE__NAME = eINSTANCE.getPortSortie_Name();

		/**
		 * The meta object literal for the '{@link calcul.impl.PortEntreeImpl <em>Port Entree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.PortEntreeImpl
		 * @see calcul.impl.CalculPackageImpl#getPortEntree()
		 * @generated
		 */
		EClass PORT_ENTREE = eINSTANCE.getPortEntree();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_ENTREE__NAME = eINSTANCE.getPortEntree_Name();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeConstanteImpl <em>Entree Constante</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeConstanteImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeConstante()
		 * @generated
		 */
		EClass ENTREE_CONSTANTE = eINSTANCE.getEntreeConstante();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeOperateurImpl <em>Entree Operateur</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeOperateurImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeOperateur()
		 * @generated
		 */
		EClass ENTREE_OPERATEUR = eINSTANCE.getEntreeOperateur();

		/**
		 * The meta object literal for the '<em><b>Precedent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTREE_OPERATEUR__PRECEDENT = eINSTANCE.getEntreeOperateur_Precedent();

		/**
		 * The meta object literal for the '<em><b>Operateur</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTREE_OPERATEUR__OPERATEUR = eINSTANCE.getEntreeOperateur_Operateur();

		/**
		 * The meta object literal for the '{@link calcul.impl.OperateurBinaireImpl <em>Operateur Binaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.OperateurBinaireImpl
		 * @see calcul.impl.CalculPackageImpl#getOperateurBinaire()
		 * @generated
		 */
		EClass OPERATEUR_BINAIRE = eINSTANCE.getOperateurBinaire();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_BINAIRE__TYPE = eINSTANCE.getOperateurBinaire_Type();

		/**
		 * The meta object literal for the '<em><b>Operandetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_BINAIRE__OPERANDETYPE = eINSTANCE.getOperateurBinaire_Operandetype();

		/**
		 * The meta object literal for the '{@link calcul.impl.OperateurUnaireImpl <em>Operateur Unaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.OperateurUnaireImpl
		 * @see calcul.impl.CalculPackageImpl#getOperateurUnaire()
		 * @generated
		 */
		EClass OPERATEUR_UNAIRE = eINSTANCE.getOperateurUnaire();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_UNAIRE__TYPE = eINSTANCE.getOperateurUnaire_Type();

		/**
		 * The meta object literal for the '<em><b>Operandetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATEUR_UNAIRE__OPERANDETYPE = eINSTANCE.getOperateurUnaire_Operandetype();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeConstanteIntImpl <em>Entree Constante Int</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeConstanteIntImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteInt()
		 * @generated
		 */
		EClass ENTREE_CONSTANTE_INT = eINSTANCE.getEntreeConstanteInt();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE_CONSTANTE_INT__VALEUR = eINSTANCE.getEntreeConstanteInt_Valeur();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeConstanteStringImpl <em>Entree Constante String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeConstanteStringImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteString()
		 * @generated
		 */
		EClass ENTREE_CONSTANTE_STRING = eINSTANCE.getEntreeConstanteString();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE_CONSTANTE_STRING__VALEUR = eINSTANCE.getEntreeConstanteString_Valeur();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeConstanteBoolImpl <em>Entree Constante Bool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeConstanteBoolImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteBool()
		 * @generated
		 */
		EClass ENTREE_CONSTANTE_BOOL = eINSTANCE.getEntreeConstanteBool();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE_CONSTANTE_BOOL__VALEUR = eINSTANCE.getEntreeConstanteBool_Valeur();

		/**
		 * The meta object literal for the '{@link calcul.impl.EntreeConstanteFloatImpl <em>Entree Constante Float</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.impl.EntreeConstanteFloatImpl
		 * @see calcul.impl.CalculPackageImpl#getEntreeConstanteFloat()
		 * @generated
		 */
		EClass ENTREE_CONSTANTE_FLOAT = eINSTANCE.getEntreeConstanteFloat();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTREE_CONSTANTE_FLOAT__VALEUR = eINSTANCE.getEntreeConstanteFloat_Valeur();

		/**
		 * The meta object literal for the '{@link calcul.OperationBType <em>Operation BType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.OperationBType
		 * @see calcul.impl.CalculPackageImpl#getOperationBType()
		 * @generated
		 */
		EEnum OPERATION_BTYPE = eINSTANCE.getOperationBType();

		/**
		 * The meta object literal for the '{@link calcul.OperationUType <em>Operation UType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.OperationUType
		 * @see calcul.impl.CalculPackageImpl#getOperationUType()
		 * @generated
		 */
		EEnum OPERATION_UTYPE = eINSTANCE.getOperationUType();

		/**
		 * The meta object literal for the '{@link calcul.TypeElement <em>Type Element</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see calcul.TypeElement
		 * @see calcul.impl.CalculPackageImpl#getTypeElement()
		 * @generated
		 */
		EEnum TYPE_ELEMENT = eINSTANCE.getTypeElement();

	}

} //CalculPackage
