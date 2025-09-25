/**
 */
package table.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import table.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see table.TablePackage
 * @generated
 */
public class TableAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TablePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TablePackage.eINSTANCE;
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
	protected TableSwitch<Adapter> modelSwitch =
		new TableSwitch<Adapter>() {
			@Override
			public Adapter caseTable(Table object) {
				return createTableAdapter();
			}
			@Override
			public Adapter caseColonne(Colonne object) {
				return createColonneAdapter();
			}
			@Override
			public Adapter caseColonneId(ColonneId object) {
				return createColonneIdAdapter();
			}
			@Override
			public Adapter caseColonneSaisie(ColonneSaisie object) {
				return createColonneSaisieAdapter();
			}
			@Override
			public Adapter caseColonneDeriv(ColonneDeriv object) {
				return createColonneDerivAdapter();
			}
			@Override
			public Adapter caseContrainte(Contrainte object) {
				return createContrainteAdapter();
			}
			@Override
			public Adapter caseContrainteOperation(ContrainteOperation object) {
				return createContrainteOperationAdapter();
			}
			@Override
			public Adapter caseTableSource(TableSource object) {
				return createTableSourceAdapter();
			}
			@Override
			public Adapter caseTableResultante(TableResultante object) {
				return createTableResultanteAdapter();
			}
			@Override
			public Adapter casecolonneIdResultante(colonneIdResultante object) {
				return createcolonneIdResultanteAdapter();
			}
			@Override
			public Adapter caseColonneSaisieRes(ColonneSaisieRes object) {
				return createColonneSaisieResAdapter();
			}
			@Override
			public Adapter caseScript(Script object) {
				return createScriptAdapter();
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
	 * Creates a new adapter for an object of class '{@link table.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.Table
	 * @generated
	 */
	public Adapter createTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.Colonne
	 * @generated
	 */
	public Adapter createColonneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.ColonneId <em>Colonne Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.ColonneId
	 * @generated
	 */
	public Adapter createColonneIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.ColonneSaisie <em>Colonne Saisie</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.ColonneSaisie
	 * @generated
	 */
	public Adapter createColonneSaisieAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.ColonneDeriv <em>Colonne Deriv</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.ColonneDeriv
	 * @generated
	 */
	public Adapter createColonneDerivAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.Contrainte <em>Contrainte</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.Contrainte
	 * @generated
	 */
	public Adapter createContrainteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.ContrainteOperation <em>Contrainte Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.ContrainteOperation
	 * @generated
	 */
	public Adapter createContrainteOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.TableSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.TableSource
	 * @generated
	 */
	public Adapter createTableSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.TableResultante <em>Resultante</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.TableResultante
	 * @generated
	 */
	public Adapter createTableResultanteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.colonneIdResultante <em>colonne Id Resultante</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.colonneIdResultante
	 * @generated
	 */
	public Adapter createcolonneIdResultanteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.ColonneSaisieRes <em>Colonne Saisie Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.ColonneSaisieRes
	 * @generated
	 */
	public Adapter createColonneSaisieResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link table.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see table.Script
	 * @generated
	 */
	public Adapter createScriptAdapter() {
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

} //TableAdapterFactory
