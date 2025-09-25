/**
 */
package table.impl;

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

import table.ColonneId;
import table.ColonneSaisie;
import table.TablePackage;
import table.TableSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link table.impl.TableSourceImpl#getColonnesaisie <em>Colonnesaisie</em>}</li>
 *   <li>{@link table.impl.TableSourceImpl#getColonneid <em>Colonneid</em>}</li>
 *   <li>{@link table.impl.TableSourceImpl#getNom <em>Nom</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableSourceImpl extends MinimalEObjectImpl.Container implements TableSource {
	/**
	 * The cached value of the '{@link #getColonnesaisie() <em>Colonnesaisie</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonnesaisie()
	 * @generated
	 * @ordered
	 */
	protected EList<ColonneSaisie> colonnesaisie;

	/**
	 * The cached value of the '{@link #getColonneid() <em>Colonneid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonneid()
	 * @generated
	 * @ordered
	 */
	protected ColonneId colonneid;

	/**
	 * The default value of the '{@link #getNom() <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNom()
	 * @generated
	 * @ordered
	 */
	protected static final String NOM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNom() <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNom()
	 * @generated
	 * @ordered
	 */
	protected String nom = NOM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TablePackage.Literals.TABLE_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColonneSaisie> getColonnesaisie() {
		if (colonnesaisie == null) {
			colonnesaisie = new EObjectContainmentEList<ColonneSaisie>(ColonneSaisie.class, this, TablePackage.TABLE_SOURCE__COLONNESAISIE);
		}
		return colonnesaisie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColonneId getColonneid() {
		return colonneid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColonneid(ColonneId newColonneid, NotificationChain msgs) {
		ColonneId oldColonneid = colonneid;
		colonneid = newColonneid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_SOURCE__COLONNEID, oldColonneid, newColonneid);
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
	public void setColonneid(ColonneId newColonneid) {
		if (newColonneid != colonneid) {
			NotificationChain msgs = null;
			if (colonneid != null)
				msgs = ((InternalEObject)colonneid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TablePackage.TABLE_SOURCE__COLONNEID, null, msgs);
			if (newColonneid != null)
				msgs = ((InternalEObject)newColonneid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TablePackage.TABLE_SOURCE__COLONNEID, null, msgs);
			msgs = basicSetColonneid(newColonneid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_SOURCE__COLONNEID, newColonneid, newColonneid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNom(String newNom) {
		String oldNom = nom;
		nom = newNom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_SOURCE__NOM, oldNom, nom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TablePackage.TABLE_SOURCE__COLONNESAISIE:
				return ((InternalEList<?>)getColonnesaisie()).basicRemove(otherEnd, msgs);
			case TablePackage.TABLE_SOURCE__COLONNEID:
				return basicSetColonneid(null, msgs);
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
			case TablePackage.TABLE_SOURCE__COLONNESAISIE:
				return getColonnesaisie();
			case TablePackage.TABLE_SOURCE__COLONNEID:
				return getColonneid();
			case TablePackage.TABLE_SOURCE__NOM:
				return getNom();
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
			case TablePackage.TABLE_SOURCE__COLONNESAISIE:
				getColonnesaisie().clear();
				getColonnesaisie().addAll((Collection<? extends ColonneSaisie>)newValue);
				return;
			case TablePackage.TABLE_SOURCE__COLONNEID:
				setColonneid((ColonneId)newValue);
				return;
			case TablePackage.TABLE_SOURCE__NOM:
				setNom((String)newValue);
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
			case TablePackage.TABLE_SOURCE__COLONNESAISIE:
				getColonnesaisie().clear();
				return;
			case TablePackage.TABLE_SOURCE__COLONNEID:
				setColonneid((ColonneId)null);
				return;
			case TablePackage.TABLE_SOURCE__NOM:
				setNom(NOM_EDEFAULT);
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
			case TablePackage.TABLE_SOURCE__COLONNESAISIE:
				return colonnesaisie != null && !colonnesaisie.isEmpty();
			case TablePackage.TABLE_SOURCE__COLONNEID:
				return colonneid != null;
			case TablePackage.TABLE_SOURCE__NOM:
				return NOM_EDEFAULT == null ? nom != null : !NOM_EDEFAULT.equals(nom);
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
		result.append(" (nom: ");
		result.append(nom);
		result.append(')');
		return result.toString();
	}

} //TableSourceImpl
