/**
 */
package calcul.util;

import calcul.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see calcul.CalculPackage
 * @generated
 */
public class CalculSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CalculPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculSwitch() {
		if (modelPackage == null) {
			modelPackage = CalculPackage.eINSTANCE;
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
			case CalculPackage.CALCUL: {
				Calcul calcul = (Calcul)theEObject;
				T result = caseCalcul(calcul);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.OPERATEUR: {
				Operateur operateur = (Operateur)theEObject;
				T result = caseOperateur(operateur);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE: {
				Entree entree = (Entree)theEObject;
				T result = caseEntree(entree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.SORTIE: {
				Sortie sortie = (Sortie)theEObject;
				T result = caseSortie(sortie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.SORTIE_OPERATEUR: {
				SortieOperateur sortieOperateur = (SortieOperateur)theEObject;
				T result = caseSortieOperateur(sortieOperateur);
				if (result == null) result = caseSortie(sortieOperateur);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.PORT_SORTIE: {
				PortSortie portSortie = (PortSortie)theEObject;
				T result = casePortSortie(portSortie);
				if (result == null) result = caseSortie(portSortie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.PORT_ENTREE: {
				PortEntree portEntree = (PortEntree)theEObject;
				T result = casePortEntree(portEntree);
				if (result == null) result = caseEntree(portEntree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_CONSTANTE: {
				EntreeConstante entreeConstante = (EntreeConstante)theEObject;
				T result = caseEntreeConstante(entreeConstante);
				if (result == null) result = caseEntree(entreeConstante);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_OPERATEUR: {
				EntreeOperateur entreeOperateur = (EntreeOperateur)theEObject;
				T result = caseEntreeOperateur(entreeOperateur);
				if (result == null) result = caseEntree(entreeOperateur);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.OPERATEUR_BINAIRE: {
				OperateurBinaire operateurBinaire = (OperateurBinaire)theEObject;
				T result = caseOperateurBinaire(operateurBinaire);
				if (result == null) result = caseOperateur(operateurBinaire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.OPERATEUR_UNAIRE: {
				OperateurUnaire operateurUnaire = (OperateurUnaire)theEObject;
				T result = caseOperateurUnaire(operateurUnaire);
				if (result == null) result = caseOperateur(operateurUnaire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_CONSTANTE_INT: {
				EntreeConstanteInt entreeConstanteInt = (EntreeConstanteInt)theEObject;
				T result = caseEntreeConstanteInt(entreeConstanteInt);
				if (result == null) result = caseEntreeConstante(entreeConstanteInt);
				if (result == null) result = caseEntree(entreeConstanteInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_CONSTANTE_STRING: {
				EntreeConstanteString entreeConstanteString = (EntreeConstanteString)theEObject;
				T result = caseEntreeConstanteString(entreeConstanteString);
				if (result == null) result = caseEntreeConstante(entreeConstanteString);
				if (result == null) result = caseEntree(entreeConstanteString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_CONSTANTE_BOOL: {
				EntreeConstanteBool entreeConstanteBool = (EntreeConstanteBool)theEObject;
				T result = caseEntreeConstanteBool(entreeConstanteBool);
				if (result == null) result = caseEntreeConstante(entreeConstanteBool);
				if (result == null) result = caseEntree(entreeConstanteBool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CalculPackage.ENTREE_CONSTANTE_FLOAT: {
				EntreeConstanteFloat entreeConstanteFloat = (EntreeConstanteFloat)theEObject;
				T result = caseEntreeConstanteFloat(entreeConstanteFloat);
				if (result == null) result = caseEntreeConstante(entreeConstanteFloat);
				if (result == null) result = caseEntree(entreeConstanteFloat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calcul</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calcul</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalcul(Calcul object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operateur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operateur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperateur(Operateur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntree(Entree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sortie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sortie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSortie(Sortie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sortie Operateur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sortie Operateur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSortieOperateur(SortieOperateur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Sortie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Sortie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortSortie(PortSortie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Entree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Entree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortEntree(PortEntree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Constante</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Constante</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeConstante(EntreeConstante object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Operateur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Operateur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeOperateur(EntreeOperateur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operateur Binaire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operateur Binaire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperateurBinaire(OperateurBinaire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operateur Unaire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operateur Unaire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperateurUnaire(OperateurUnaire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Constante Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Constante Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeConstanteInt(EntreeConstanteInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Constante String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Constante String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeConstanteString(EntreeConstanteString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Constante Bool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Constante Bool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeConstanteBool(EntreeConstanteBool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entree Constante Float</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entree Constante Float</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntreeConstanteFloat(EntreeConstanteFloat object) {
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

} //CalculSwitch
