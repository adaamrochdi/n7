/**
 */
package calcul.impl;

import calcul.Calcul;
import calcul.CalculFactory;
import calcul.CalculPackage;
import calcul.Entree;
import calcul.EntreeConstante;
import calcul.EntreeConstanteBool;
import calcul.EntreeConstanteFloat;
import calcul.EntreeConstanteInt;
import calcul.EntreeConstanteString;
import calcul.EntreeOperateur;
import calcul.Operateur;
import calcul.OperateurBinaire;
import calcul.OperateurUnaire;
import calcul.OperationBType;
import calcul.OperationUType;
import calcul.PortEntree;
import calcul.PortSortie;
import calcul.Sortie;
import calcul.SortieOperateur;
import calcul.TypeElement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CalculPackageImpl extends EPackageImpl implements CalculPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operateurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sortieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sortieOperateurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portSortieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEntreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeConstanteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeOperateurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operateurBinaireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operateurUnaireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeConstanteIntEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeConstanteStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeConstanteBoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entreeConstanteFloatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationBTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationUTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeElementEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see calcul.CalculPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CalculPackageImpl() {
		super(eNS_URI, CalculFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CalculPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CalculPackage init() {
		if (isInited) return (CalculPackage)EPackage.Registry.INSTANCE.getEPackage(CalculPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCalculPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CalculPackageImpl theCalculPackage = registeredCalculPackage instanceof CalculPackageImpl ? (CalculPackageImpl)registeredCalculPackage : new CalculPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theCalculPackage.createPackageContents();

		// Initialize created meta-data
		theCalculPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCalculPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CalculPackage.eNS_URI, theCalculPackage);
		return theCalculPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCalcul() {
		return calculEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCalcul_Operateur() {
		return (EReference)calculEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCalcul_Name() {
		return (EAttribute)calculEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperateur() {
		return operateurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperateur_Sortie() {
		return (EReference)operateurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperateur_EntreePrincipale() {
		return (EReference)operateurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateur_Name() {
		return (EAttribute)operateurEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntree() {
		return entreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntree_Ordre() {
		return (EAttribute)entreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntree_Type() {
		return (EAttribute)entreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSortie() {
		return sortieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSortieOperateur() {
		return sortieOperateurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSortieOperateur_Suivant() {
		return (EReference)sortieOperateurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSortieOperateur_Operateur() {
		return (EReference)sortieOperateurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPortSortie() {
		return portSortieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPortSortie_Name() {
		return (EAttribute)portSortieEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPortEntree() {
		return portEntreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPortEntree_Name() {
		return (EAttribute)portEntreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeConstante() {
		return entreeConstanteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeOperateur() {
		return entreeOperateurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntreeOperateur_Precedent() {
		return (EReference)entreeOperateurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntreeOperateur_Operateur() {
		return (EReference)entreeOperateurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperateurBinaire() {
		return operateurBinaireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurBinaire_Type() {
		return (EAttribute)operateurBinaireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurBinaire_Operandetype() {
		return (EAttribute)operateurBinaireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperateurUnaire() {
		return operateurUnaireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurUnaire_Type() {
		return (EAttribute)operateurUnaireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperateurUnaire_Operandetype() {
		return (EAttribute)operateurUnaireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeConstanteInt() {
		return entreeConstanteIntEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntreeConstanteInt_Valeur() {
		return (EAttribute)entreeConstanteIntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeConstanteString() {
		return entreeConstanteStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntreeConstanteString_Valeur() {
		return (EAttribute)entreeConstanteStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeConstanteBool() {
		return entreeConstanteBoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntreeConstanteBool_Valeur() {
		return (EAttribute)entreeConstanteBoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntreeConstanteFloat() {
		return entreeConstanteFloatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntreeConstanteFloat_Valeur() {
		return (EAttribute)entreeConstanteFloatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperationBType() {
		return operationBTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperationUType() {
		return operationUTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTypeElement() {
		return typeElementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CalculFactory getCalculFactory() {
		return (CalculFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		calculEClass = createEClass(CALCUL);
		createEReference(calculEClass, CALCUL__OPERATEUR);
		createEAttribute(calculEClass, CALCUL__NAME);

		operateurEClass = createEClass(OPERATEUR);
		createEReference(operateurEClass, OPERATEUR__SORTIE);
		createEReference(operateurEClass, OPERATEUR__ENTREE_PRINCIPALE);
		createEAttribute(operateurEClass, OPERATEUR__NAME);

		entreeEClass = createEClass(ENTREE);
		createEAttribute(entreeEClass, ENTREE__ORDRE);
		createEAttribute(entreeEClass, ENTREE__TYPE);

		sortieEClass = createEClass(SORTIE);

		sortieOperateurEClass = createEClass(SORTIE_OPERATEUR);
		createEReference(sortieOperateurEClass, SORTIE_OPERATEUR__SUIVANT);
		createEReference(sortieOperateurEClass, SORTIE_OPERATEUR__OPERATEUR);

		portSortieEClass = createEClass(PORT_SORTIE);
		createEAttribute(portSortieEClass, PORT_SORTIE__NAME);

		portEntreeEClass = createEClass(PORT_ENTREE);
		createEAttribute(portEntreeEClass, PORT_ENTREE__NAME);

		entreeConstanteEClass = createEClass(ENTREE_CONSTANTE);

		entreeOperateurEClass = createEClass(ENTREE_OPERATEUR);
		createEReference(entreeOperateurEClass, ENTREE_OPERATEUR__PRECEDENT);
		createEReference(entreeOperateurEClass, ENTREE_OPERATEUR__OPERATEUR);

		operateurBinaireEClass = createEClass(OPERATEUR_BINAIRE);
		createEAttribute(operateurBinaireEClass, OPERATEUR_BINAIRE__TYPE);
		createEAttribute(operateurBinaireEClass, OPERATEUR_BINAIRE__OPERANDETYPE);

		operateurUnaireEClass = createEClass(OPERATEUR_UNAIRE);
		createEAttribute(operateurUnaireEClass, OPERATEUR_UNAIRE__TYPE);
		createEAttribute(operateurUnaireEClass, OPERATEUR_UNAIRE__OPERANDETYPE);

		entreeConstanteIntEClass = createEClass(ENTREE_CONSTANTE_INT);
		createEAttribute(entreeConstanteIntEClass, ENTREE_CONSTANTE_INT__VALEUR);

		entreeConstanteStringEClass = createEClass(ENTREE_CONSTANTE_STRING);
		createEAttribute(entreeConstanteStringEClass, ENTREE_CONSTANTE_STRING__VALEUR);

		entreeConstanteBoolEClass = createEClass(ENTREE_CONSTANTE_BOOL);
		createEAttribute(entreeConstanteBoolEClass, ENTREE_CONSTANTE_BOOL__VALEUR);

		entreeConstanteFloatEClass = createEClass(ENTREE_CONSTANTE_FLOAT);
		createEAttribute(entreeConstanteFloatEClass, ENTREE_CONSTANTE_FLOAT__VALEUR);

		// Create enums
		operationBTypeEEnum = createEEnum(OPERATION_BTYPE);
		operationUTypeEEnum = createEEnum(OPERATION_UTYPE);
		typeElementEEnum = createEEnum(TYPE_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sortieOperateurEClass.getESuperTypes().add(this.getSortie());
		portSortieEClass.getESuperTypes().add(this.getSortie());
		portEntreeEClass.getESuperTypes().add(this.getEntree());
		entreeConstanteEClass.getESuperTypes().add(this.getEntree());
		entreeOperateurEClass.getESuperTypes().add(this.getEntree());
		operateurBinaireEClass.getESuperTypes().add(this.getOperateur());
		operateurUnaireEClass.getESuperTypes().add(this.getOperateur());
		entreeConstanteIntEClass.getESuperTypes().add(this.getEntreeConstante());
		entreeConstanteStringEClass.getESuperTypes().add(this.getEntreeConstante());
		entreeConstanteBoolEClass.getESuperTypes().add(this.getEntreeConstante());
		entreeConstanteFloatEClass.getESuperTypes().add(this.getEntreeConstante());

		// Initialize classes, features, and operations; add parameters
		initEClass(calculEClass, Calcul.class, "Calcul", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCalcul_Operateur(), this.getOperateur(), null, "operateur", null, 1, -1, Calcul.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalcul_Name(), ecorePackage.getEString(), "name", null, 1, 1, Calcul.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operateurEClass, Operateur.class, "Operateur", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperateur_Sortie(), this.getSortie(), null, "sortie", null, 1, 1, Operateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperateur_EntreePrincipale(), this.getEntree(), null, "entreePrincipale", null, 1, -1, Operateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperateur_Name(), ecorePackage.getEString(), "name", null, 1, 1, Operateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeEClass, Entree.class, "Entree", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntree_Ordre(), ecorePackage.getEInt(), "ordre", null, 1, 1, Entree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntree_Type(), this.getTypeElement(), "type", null, 1, 1, Entree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sortieEClass, Sortie.class, "Sortie", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sortieOperateurEClass, SortieOperateur.class, "SortieOperateur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSortieOperateur_Suivant(), this.getEntreeOperateur(), this.getEntreeOperateur_Precedent(), "suivant", null, 1, 1, SortieOperateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSortieOperateur_Operateur(), this.getOperateur(), null, "operateur", null, 1, 1, SortieOperateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portSortieEClass, PortSortie.class, "PortSortie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortSortie_Name(), ecorePackage.getEString(), "name", null, 1, 1, PortSortie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEntreeEClass, PortEntree.class, "PortEntree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortEntree_Name(), ecorePackage.getEString(), "name", null, 1, 1, PortEntree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeConstanteEClass, EntreeConstante.class, "EntreeConstante", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entreeOperateurEClass, EntreeOperateur.class, "EntreeOperateur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntreeOperateur_Precedent(), this.getSortieOperateur(), this.getSortieOperateur_Suivant(), "precedent", null, 1, 1, EntreeOperateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntreeOperateur_Operateur(), this.getOperateur(), null, "operateur", null, 1, 1, EntreeOperateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operateurBinaireEClass, OperateurBinaire.class, "OperateurBinaire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperateurBinaire_Type(), this.getOperationBType(), "type", null, 1, 1, OperateurBinaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperateurBinaire_Operandetype(), this.getTypeElement(), "operandetype", null, 1, 1, OperateurBinaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operateurUnaireEClass, OperateurUnaire.class, "OperateurUnaire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperateurUnaire_Type(), this.getOperationUType(), "type", null, 1, 1, OperateurUnaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperateurUnaire_Operandetype(), this.getTypeElement(), "operandetype", null, 1, 1, OperateurUnaire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeConstanteIntEClass, EntreeConstanteInt.class, "EntreeConstanteInt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntreeConstanteInt_Valeur(), ecorePackage.getEInt(), "valeur", null, 1, 1, EntreeConstanteInt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeConstanteStringEClass, EntreeConstanteString.class, "EntreeConstanteString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntreeConstanteString_Valeur(), ecorePackage.getEString(), "valeur", null, 1, 1, EntreeConstanteString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeConstanteBoolEClass, EntreeConstanteBool.class, "EntreeConstanteBool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntreeConstanteBool_Valeur(), ecorePackage.getEBoolean(), "valeur", null, 1, 1, EntreeConstanteBool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entreeConstanteFloatEClass, EntreeConstanteFloat.class, "EntreeConstanteFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntreeConstanteFloat_Valeur(), ecorePackage.getEFloat(), "valeur", null, 0, 1, EntreeConstanteFloat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(operationBTypeEEnum, OperationBType.class, "OperationBType");
		addEEnumLiteral(operationBTypeEEnum, OperationBType.SOMME);
		addEEnumLiteral(operationBTypeEEnum, OperationBType.SOUSTRACTION);
		addEEnumLiteral(operationBTypeEEnum, OperationBType.PRODUIT);
		addEEnumLiteral(operationBTypeEEnum, OperationBType.MAXIMUM);
		addEEnumLiteral(operationBTypeEEnum, OperationBType.MINIMUM);
		addEEnumLiteral(operationBTypeEEnum, OperationBType.DIVISION);

		initEEnum(operationUTypeEEnum, OperationUType.class, "OperationUType");
		addEEnumLiteral(operationUTypeEEnum, OperationUType.OPPOSE);
		addEEnumLiteral(operationUTypeEEnum, OperationUType.INVERSE);
		addEEnumLiteral(operationUTypeEEnum, OperationUType.SINUS);
		addEEnumLiteral(operationUTypeEEnum, OperationUType.COSINUS);
		addEEnumLiteral(operationUTypeEEnum, OperationUType.SQRT);
		addEEnumLiteral(operationUTypeEEnum, OperationUType.EXP);

		initEEnum(typeElementEEnum, TypeElement.class, "TypeElement");
		addEEnumLiteral(typeElementEEnum, TypeElement.INT);
		addEEnumLiteral(typeElementEEnum, TypeElement.STRING);
		addEEnumLiteral(typeElementEEnum, TypeElement.FLOAT);
		addEEnumLiteral(typeElementEEnum, TypeElement.BOOL);

		// Create resource
		createResource(eNS_URI);
	}

} //CalculPackageImpl
