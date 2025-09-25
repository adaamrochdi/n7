/**
 */
package calcul.util;

import calcul.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see calcul.CalculPackage
 * @generated
 */
public class CalculAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CalculPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CalculPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalculSwitch<Adapter> modelSwitch =
		new CalculSwitch<Adapter>() {
			@Override
			public Adapter caseCalcul(Calcul object) {
				return createCalculAdapter();
			}
			@Override
			public Adapter caseOperateur(Operateur object) {
				return createOperateurAdapter();
			}
			@Override
			public Adapter caseEntree(Entree object) {
				return createEntreeAdapter();
			}
			@Override
			public Adapter caseSortie(Sortie object) {
				return createSortieAdapter();
			}
			@Override
			public Adapter caseSortieOperateur(SortieOperateur object) {
				return createSortieOperateurAdapter();
			}
			@Override
			public Adapter casePortSortie(PortSortie object) {
				return createPortSortieAdapter();
			}
			@Override
			public Adapter casePortEntree(PortEntree object) {
				return createPortEntreeAdapter();
			}
			@Override
			public Adapter caseEntreeConstante(EntreeConstante object) {
				return createEntreeConstanteAdapter();
			}
			@Override
			public Adapter caseEntreeOperateur(EntreeOperateur object) {
				return createEntreeOperateurAdapter();
			}
			@Override
			public Adapter caseOperateurBinaire(OperateurBinaire object) {
				return createOperateurBinaireAdapter();
			}
			@Override
			public Adapter caseOperateurUnaire(OperateurUnaire object) {
				return createOperateurUnaireAdapter();
			}
			@Override
			public Adapter caseEntreeConstanteInt(EntreeConstanteInt object) {
				return createEntreeConstanteIntAdapter();
			}
			@Override
			public Adapter caseEntreeConstanteString(EntreeConstanteString object) {
				return createEntreeConstanteStringAdapter();
			}
			@Override
			public Adapter caseEntreeConstanteBool(EntreeConstanteBool object) {
				return createEntreeConstanteBoolAdapter();
			}
			@Override
			public Adapter caseEntreeConstanteFloat(EntreeConstanteFloat object) {
				return createEntreeConstanteFloatAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link calcul.Calcul <em>Calcul</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.Calcul
	 * @generated
	 */
	public Adapter createCalculAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.Operateur <em>Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.Operateur
	 * @generated
	 */
	public Adapter createOperateurAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.Entree <em>Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.Entree
	 * @generated
	 */
	public Adapter createEntreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.Sortie <em>Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.Sortie
	 * @generated
	 */
	public Adapter createSortieAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.SortieOperateur <em>Sortie Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.SortieOperateur
	 * @generated
	 */
	public Adapter createSortieOperateurAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.PortSortie <em>Port Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.PortSortie
	 * @generated
	 */
	public Adapter createPortSortieAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.PortEntree <em>Port Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.PortEntree
	 * @generated
	 */
	public Adapter createPortEntreeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeConstante <em>Entree Constante</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeConstante
	 * @generated
	 */
	public Adapter createEntreeConstanteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeOperateur <em>Entree Operateur</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeOperateur
	 * @generated
	 */
	public Adapter createEntreeOperateurAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.OperateurBinaire <em>Operateur Binaire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.OperateurBinaire
	 * @generated
	 */
	public Adapter createOperateurBinaireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.OperateurUnaire <em>Operateur Unaire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.OperateurUnaire
	 * @generated
	 */
	public Adapter createOperateurUnaireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeConstanteInt <em>Entree Constante Int</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeConstanteInt
	 * @generated
	 */
	public Adapter createEntreeConstanteIntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeConstanteString <em>Entree Constante String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeConstanteString
	 * @generated
	 */
	public Adapter createEntreeConstanteStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeConstanteBool <em>Entree Constante Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeConstanteBool
	 * @generated
	 */
	public Adapter createEntreeConstanteBoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link calcul.EntreeConstanteFloat <em>Entree Constante Float</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see calcul.EntreeConstanteFloat
	 * @generated
	 */
	public Adapter createEntreeConstanteFloatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CalculAdapterFactory
