/**
 */
package calcul.impl;

import calcul.CalculPackage;
import calcul.Entree;
import calcul.Operateur;
import calcul.Sortie;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operateur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link calcul.impl.OperateurImpl#getSortie <em>Sortie</em>}</li>
 *   <li>{@link calcul.impl.OperateurImpl#getEntreePrincipale <em>Entree Principale</em>}</li>
 *   <li>{@link calcul.impl.OperateurImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OperateurImpl extends MinimalEObjectImpl.Container implements Operateur {
	/**
	 * The cached value of the '{@link #getSortie() <em>Sortie</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortie()
	 * @generated
	 * @ordered
	 */
	protected Sortie sortie;

	/**
	 * The cached value of the '{@link #getEntreePrincipale() <em>Entree Principale</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntreePrincipale()
	 * @generated
	 * @ordered
	 */
	protected EList<Entree> entreePrincipale;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperateurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculPackage.Literals.OPERATEUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sortie getSortie() {
		return sortie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSortie(Sortie newSortie, NotificationChain msgs) {
		Sortie oldSortie = sortie;
		sortie = newSortie;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CalculPackage.OPERATEUR__SORTIE, oldSortie, newSortie);
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
	public void setSortie(Sortie newSortie) {
		if (newSortie != sortie) {
			NotificationChain msgs = null;
			if (sortie != null)
				msgs = ((InternalEObject)sortie).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CalculPackage.OPERATEUR__SORTIE, null, msgs);
			if (newSortie != null)
				msgs = ((InternalEObject)newSortie).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CalculPackage.OPERATEUR__SORTIE, null, msgs);
			msgs = basicSetSortie(newSortie, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.OPERATEUR__SORTIE, newSortie, newSortie));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Entree> getEntreePrincipale() {
		if (entreePrincipale == null) {
			entreePrincipale = new EObjectContainmentEList<Entree>(Entree.class, this, CalculPackage.OPERATEUR__ENTREE_PRINCIPALE);
		}
		return entreePrincipale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.OPERATEUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CalculPackage.OPERATEUR__SORTIE:
				return basicSetSortie(null, msgs);
			case CalculPackage.OPERATEUR__ENTREE_PRINCIPALE:
				return ((InternalEList<?>)getEntreePrincipale()).basicRemove(otherEnd, msgs);
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
			case CalculPackage.OPERATEUR__SORTIE:
				return getSortie();
			case CalculPackage.OPERATEUR__ENTREE_PRINCIPALE:
				return getEntreePrincipale();
			case CalculPackage.OPERATEUR__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CalculPackage.OPERATEUR__SORTIE:
				setSortie((Sortie)newValue);
				return;
			case CalculPackage.OPERATEUR__ENTREE_PRINCIPALE:
				getEntreePrincipale().clear();
				getEntreePrincipale().addAll((Collection<? extends Entree>)newValue);
				return;
			case CalculPackage.OPERATEUR__NAME:
				setName((String)newValue);
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
			case CalculPackage.OPERATEUR__SORTIE:
				setSortie((Sortie)null);
				return;
			case CalculPackage.OPERATEUR__ENTREE_PRINCIPALE:
				getEntreePrincipale().clear();
				return;
			case CalculPackage.OPERATEUR__NAME:
				setName(NAME_EDEFAULT);
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
			case CalculPackage.OPERATEUR__SORTIE:
				return sortie != null;
			case CalculPackage.OPERATEUR__ENTREE_PRINCIPALE:
				return entreePrincipale != null && !entreePrincipale.isEmpty();
			case CalculPackage.OPERATEUR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OperateurImpl
