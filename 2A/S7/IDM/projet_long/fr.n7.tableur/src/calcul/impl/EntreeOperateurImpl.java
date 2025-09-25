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
 * An implementation of the model object '<em><b>Entree Operateur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link calcul.impl.EntreeOperateurImpl#getPrecedent <em>Precedent</em>}</li>
 *   <li>{@link calcul.impl.EntreeOperateurImpl#getOperateur <em>Operateur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntreeOperateurImpl extends EntreeImpl implements EntreeOperateur {
	/**
	 * The cached value of the '{@link #getPrecedent() <em>Precedent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedent()
	 * @generated
	 * @ordered
	 */
	protected SortieOperateur precedent;

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
	protected EntreeOperateurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculPackage.Literals.ENTREE_OPERATEUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SortieOperateur getPrecedent() {
		if (precedent != null && precedent.eIsProxy()) {
			InternalEObject oldPrecedent = (InternalEObject)precedent;
			precedent = (SortieOperateur)eResolveProxy(oldPrecedent);
			if (precedent != oldPrecedent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, oldPrecedent, precedent));
			}
		}
		return precedent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortieOperateur basicGetPrecedent() {
		return precedent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrecedent(SortieOperateur newPrecedent, NotificationChain msgs) {
		SortieOperateur oldPrecedent = precedent;
		precedent = newPrecedent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, oldPrecedent, newPrecedent);
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
	public void setPrecedent(SortieOperateur newPrecedent) {
		if (newPrecedent != precedent) {
			NotificationChain msgs = null;
			if (precedent != null)
				msgs = ((InternalEObject)precedent).eInverseRemove(this, CalculPackage.SORTIE_OPERATEUR__SUIVANT, SortieOperateur.class, msgs);
			if (newPrecedent != null)
				msgs = ((InternalEObject)newPrecedent).eInverseAdd(this, CalculPackage.SORTIE_OPERATEUR__SUIVANT, SortieOperateur.class, msgs);
			msgs = basicSetPrecedent(newPrecedent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.ENTREE_OPERATEUR__PRECEDENT, newPrecedent, newPrecedent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CalculPackage.ENTREE_OPERATEUR__OPERATEUR, oldOperateur, operateur));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.ENTREE_OPERATEUR__OPERATEUR, oldOperateur, operateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				if (precedent != null)
					msgs = ((InternalEObject)precedent).eInverseRemove(this, CalculPackage.SORTIE_OPERATEUR__SUIVANT, SortieOperateur.class, msgs);
				return basicSetPrecedent((SortieOperateur)otherEnd, msgs);
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
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				return basicSetPrecedent(null, msgs);
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
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				if (resolve) return getPrecedent();
				return basicGetPrecedent();
			case CalculPackage.ENTREE_OPERATEUR__OPERATEUR:
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
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				setPrecedent((SortieOperateur)newValue);
				return;
			case CalculPackage.ENTREE_OPERATEUR__OPERATEUR:
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
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				setPrecedent((SortieOperateur)null);
				return;
			case CalculPackage.ENTREE_OPERATEUR__OPERATEUR:
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
			case CalculPackage.ENTREE_OPERATEUR__PRECEDENT:
				return precedent != null;
			case CalculPackage.ENTREE_OPERATEUR__OPERATEUR:
				return operateur != null;
		}
		return super.eIsSet(featureID);
	}

} //EntreeOperateurImpl
