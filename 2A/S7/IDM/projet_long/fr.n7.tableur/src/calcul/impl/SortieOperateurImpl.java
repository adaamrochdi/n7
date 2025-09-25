/**
 */
package calcul.impl;

import calcul.CalculPackage;
import calcul.EntreeOperateur;
import calcul.Operateur;
import calcul.SortieOperateur;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sortie Operateur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link calcul.impl.SortieOperateurImpl#getSuivant <em>Suivant</em>}</li>
 *   <li>{@link calcul.impl.SortieOperateurImpl#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SortieOperateurImpl extends SortieImpl implements SortieOperateur {
	/**
	 * The cached value of the '{@link #getSuivant() <em>Suivant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuivant()
	 * @generated
	 * @ordered
	 */
	protected EntreeOperateur suivant;

	/**
	 * The cached value of the '{@link #getOperateur() <em>Operateur</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperateur()
	 * @generated
	 * @ordered
	 */
	protected Operateur operateur;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SortieOperateurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculPackage.Literals.SORTIE_OPERATEUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntreeOperateur getSuivant() {
		if (suivant != null && suivant.eIsProxy()) {
			InternalEObject oldSuivant = (InternalEObject)suivant;
			suivant = (EntreeOperateur)eResolveProxy(oldSuivant);
			if (suivant != oldSuivant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CalculPackage.SORTIE_OPERATEUR__SUIVANT, oldSuivant, suivant));
			}
		}
		return suivant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntreeOperateur basicGetSuivant() {
		return suivant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuivant(EntreeOperateur newSuivant, NotificationChain msgs) {
		EntreeOperateur oldSuivant = suivant;
		suivant = newSuivant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CalculPackage.SORTIE_OPERATEUR__SUIVANT, oldSuivant, newSuivant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuivant(EntreeOperateur newSuivant) {
		if (newSuivant != suivant) {
			NotificationChain msgs = null;
			if (suivant != null)
				msgs = ((InternalEObject)suivant).eInverseRemove(this, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, EntreeOperateur.class, msgs);
			if (newSuivant != null)
				msgs = ((InternalEObject)newSuivant).eInverseAdd(this, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, EntreeOperateur.class, msgs);
			msgs = basicSetSuivant(newSuivant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.SORTIE_OPERATEUR__SUIVANT, newSuivant, newSuivant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operateur getOperateur() {
		if (operateur != null && operateur.eIsProxy()) {
			InternalEObject oldOperateur = (InternalEObject)operateur;
			operateur = (Operateur)eResolveProxy(oldOperateur);
			if (operateur != oldOperateur) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CalculPackage.SORTIE_OPERATEUR__OPERATEUR, oldOperateur, operateur));
			}
		}
		return operateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operateur basicGetOperateur() {
		return operateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperateur(Operateur newOperateur) {
		Operateur oldOperateur = operateur;
		operateur = newOperateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.SORTIE_OPERATEUR__OPERATEUR, oldOperateur, operateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				if (suivant != null)
					msgs = ((InternalEObject)suivant).eInverseRemove(this, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, EntreeOperateur.class, msgs);
				return basicSetSuivant((EntreeOperateur)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				return basicSetSuivant(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				if (resolve) return getSuivant();
				return basicGetSuivant();
			case CalculPackage.SORTIE_OPERATEUR__OPERATEUR:
				if (resolve) return getOperateur();
				return basicGetOperateur();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				setSuivant((EntreeOperateur)newValue);
				return;
			case CalculPackage.SORTIE_OPERATEUR__OPERATEUR:
				setOperateur((Operateur)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				setSuivant((EntreeOperateur)null);
				return;
			case CalculPackage.SORTIE_OPERATEUR__OPERATEUR:
				setOperateur((Operateur)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CalculPackage.SORTIE_OPERATEUR__SUIVANT:
				return suivant != null;
			case CalculPackage.SORTIE_OPERATEUR__OPERATEUR:
				return operateur != null;
		}
		return super.eIsSet(featureID);
	}

} //SortieOperateurImpl
