/**
 */
package calcul.impl;

import calcul.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CalculFactoryImpl extends EFactoryImpl implements CalculFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CalculFactory init() {
		try {
			CalculFactory theCalculFactory = (CalculFactory)EPackage.Registry.INSTANCE.getEFactory(CalculPackage.eNS_URI);
			if (theCalculFactory != null) {
				return theCalculFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CalculFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CalculPackage.CALCUL: return createCalcul();
			case CalculPackage.SORTIE_OPERATEUR: return createSortieOperateur();
			case CalculPackage.PORT_SORTIE: return createPortSortie();
			case CalculPackage.PORT_ENTREE: return createPortEntree();
			case CalculPackage.ENTREE_OPERATEUR: return createEntreeOperateur();
			case CalculPackage.OPERATEUR_BINAIRE: return createOperateurBinaire();
			case CalculPackage.OPERATEUR_UNAIRE: return createOperateurUnaire();
			case CalculPackage.ENTREE_CONSTANTE_INT: return createEntreeConstanteInt();
			case CalculPackage.ENTREE_CONSTANTE_STRING: return createEntreeConstanteString();
			case CalculPackage.ENTREE_CONSTANTE_BOOL: return createEntreeConstanteBool();
			case CalculPackage.ENTREE_CONSTANTE_FLOAT: return createEntreeConstanteFloat();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CalculPackage.OPERATION_BTYPE:
				return createOperationBTypeFromString(eDataType, initialValue);
			case CalculPackage.OPERATION_UTYPE:
				return createOperationUTypeFromString(eDataType, initialValue);
			case CalculPackage.TYPE_ELEMENT:
				return createTypeElementFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CalculPackage.OPERATION_BTYPE:
				return convertOperationBTypeToString(eDataType, instanceValue);
			case CalculPackage.OPERATION_UTYPE:
				return convertOperationUTypeToString(eDataType, instanceValue);
			case CalculPackage.TYPE_ELEMENT:
				return convertTypeElementToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Calcul createCalcul() {
		CalculImpl calcul = new CalculImpl();
		return calcul;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SortieOperateur createSortieOperateur() {
		SortieOperateurImpl sortieOperateur = new SortieOperateurImpl();
		return sortieOperateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortSortie createPortSortie() {
		PortSortieImpl portSortie = new PortSortieImpl();
		return portSortie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortEntree createPortEntree() {
		PortEntreeImpl portEntree = new PortEntreeImpl();
		return portEntree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeOperateur createEntreeOperateur() {
		EntreeOperateurImpl entreeOperateur = new EntreeOperateurImpl();
		return entreeOperateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperateurBinaire createOperateurBinaire() {
		OperateurBinaireImpl operateurBinaire = new OperateurBinaireImpl();
		return operateurBinaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperateurUnaire createOperateurUnaire() {
		OperateurUnaireImpl operateurUnaire = new OperateurUnaireImpl();
		return operateurUnaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeConstanteInt createEntreeConstanteInt() {
		EntreeConstanteIntImpl entreeConstanteInt = new EntreeConstanteIntImpl();
		return entreeConstanteInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeConstanteString createEntreeConstanteString() {
		EntreeConstanteStringImpl entreeConstanteString = new EntreeConstanteStringImpl();
		return entreeConstanteString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeConstanteBool createEntreeConstanteBool() {
		EntreeConstanteBoolImpl entreeConstanteBool = new EntreeConstanteBoolImpl();
		return entreeConstanteBool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeConstanteFloat createEntreeConstanteFloat() {
		EntreeConstanteFloatImpl entreeConstanteFloat = new EntreeConstanteFloatImpl();
		return entreeConstanteFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationBType createOperationBTypeFromString(EDataType eDataType, String initialValue) {
		OperationBType result = OperationBType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationBTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationUType createOperationUTypeFromString(EDataType eDataType, String initialValue) {
		OperationUType result = OperationUType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationUTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeElement createTypeElementFromString(EDataType eDataType, String initialValue) {
		TypeElement result = TypeElement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeElementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CalculPackage getCalculPackage() {
		return (CalculPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CalculPackage getPackage() {
		return CalculPackage.eINSTANCE;
	}

} //CalculFactoryImpl
