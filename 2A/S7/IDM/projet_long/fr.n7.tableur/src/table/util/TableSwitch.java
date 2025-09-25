/**
 */
package table.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import table.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see table.TablePackage
 * @generated
 */
public class TableSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TablePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableSwitch() {
		if (modelPackage == null) {
			modelPackage = TablePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TablePackage.TABLE: {
				Table table = (Table)theEObject;
				T result = caseTable(table);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE: {
				Colonne colonne = (Colonne)theEObject;
				T result = caseColonne(colonne);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE_ID: {
				ColonneId colonneId = (ColonneId)theEObject;
				T result = caseColonneId(colonneId);
				if (result == null) result = caseColonne(colonneId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE_SAISIE: {
				ColonneSaisie colonneSaisie = (ColonneSaisie)theEObject;
				T result = caseColonneSaisie(colonneSaisie);
				if (result == null) result = caseColonne(colonneSaisie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE_DERIV: {
				ColonneDeriv colonneDeriv = (ColonneDeriv)theEObject;
				T result = caseColonneDeriv(colonneDeriv);
				if (result == null) result = caseColonne(colonneDeriv);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.CONTRAINTE: {
				Contrainte contrainte = (Contrainte)theEObject;
				T result = caseContrainte(contrainte);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.CONTRAINTE_OPERATION: {
				ContrainteOperation contrainteOperation = (ContrainteOperation)theEObject;
				T result = caseContrainteOperation(contrainteOperation);
				if (result == null) result = caseContrainte(contrainteOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.TABLE_SOURCE: {
				TableSource tableSource = (TableSource)theEObject;
				T result = caseTableSource(tableSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.TABLE_RESULTANTE: {
				TableResultante tableResultante = (TableResultante)theEObject;
				T result = caseTableResultante(tableResultante);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE_ID_RESULTANTE: {
				colonneIdResultante colonneIdResultante = (colonneIdResultante)theEObject;
				T result = casecolonneIdResultante(colonneIdResultante);
				if (result == null) result = caseColonne(colonneIdResultante);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.COLONNE_SAISIE_RES: {
				ColonneSaisieRes colonneSaisieRes = (ColonneSaisieRes)theEObject;
				T result = caseColonneSaisieRes(colonneSaisieRes);
				if (result == null) result = caseColonne(colonneSaisieRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TablePackage.SCRIPT: {
				Script script = (Script)theEObject;
				T result = caseScript(script);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTable(Table object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Colonne</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Colonne</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColonne(Colonne object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Colonne Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Colonne Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColonneId(ColonneId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Colonne Saisie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Colonne Saisie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColonneSaisie(ColonneSaisie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Colonne Deriv</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Colonne Deriv</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColonneDeriv(ColonneDeriv object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contrainte</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contrainte</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContrainte(Contrainte object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contrainte Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contrainte Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContrainteOperation(ContrainteOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableSource(TableSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resultante</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resultante</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableResultante(TableResultante object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>colonne Id Resultante</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>colonne Id Resultante</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecolonneIdResultante(colonneIdResultante object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Colonne Saisie Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Colonne Saisie Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColonneSaisieRes(ColonneSaisieRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScript(Script object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TableSwitch
