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

import table.ColonneDeriv;
import table.ColonneSaisieRes;
import table.TablePackage;
import table.TableResultante;
import table.colonneIdResultante;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resultante</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link table.impl.TableResultanteImpl#getColonneidresultante <em>Colonneidresultante</em>}</li>
 *   <li>{@link table.impl.TableResultanteImpl#getColonnesaisieres <em>Colonnesaisieres</em>}</li>
 *   <li>{@link table.impl.TableResultanteImpl#getColonnederiv <em>Colonnederiv</em>}</li>
 *   <li>{@link table.impl.TableResultanteImpl#getNom <em>Nom</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableResultanteImpl extends MinimalEObjectImpl.Container implements TableResultante {
	/**
	 * The cached value of the '{@link #getColonneidresultante() <em>Colonneidresultante</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonneidresultante()
	 * @generated
	 * @ordered
	 */
	protected colonneIdResultante colonneidresultante;

	/**
	 * The cached value of the '{@link #getColonnesaisieres() <em>Colonnesaisieres</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonnesaisieres()
	 * @generated
	 * @ordered
	 */
	protected EList<ColonneSaisieRes> colonnesaisieres;

	/**
	 * The cached value of the '{@link #getColonnederiv() <em>Colonnederiv</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColonnederiv()
	 * @generated
	 * @ordered
	 */
	protected EList<ColonneDeriv> colonnederiv;

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
	protected TableResultanteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TablePackage.Literals.TABLE_RESULTANTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public colonneIdResultante getColonneidresultante() {
		return colonneidresultante;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColonneidresultante(colonneIdResultante newColonneidresultante, NotificationChain msgs) {
		colonneIdResultante oldColonneidresultante = colonneidresultante;
		colonneidresultante = newColonneidresultante;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE, oldColonneidresultante, newColonneidresultante);
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
	public void setColonneidresultante(colonneIdResultante newColonneidresultante) {
		if (newColonneidresultante != colonneidresultante) {
			NotificationChain msgs = null;
			if (colonneidresultante != null)
				msgs = ((InternalEObject)colonneidresultante).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE, null, msgs);
			if (newColonneidresultante != null)
				msgs = ((InternalEObject)newColonneidresultante).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE, null, msgs);
			msgs = basicSetColonneidresultante(newColonneidresultante, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE, newColonneidresultante, newColonneidresultante));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColonneSaisieRes> getColonnesaisieres() {
		if (colonnesaisieres == null) {
			colonnesaisieres = new EObjectContainmentEList<ColonneSaisieRes>(ColonneSaisieRes.class, this, TablePackage.TABLE_RESULTANTE__COLONNESAISIERES);
		}
		return colonnesaisieres;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColonneDeriv> getColonnederiv() {
		if (colonnederiv == null) {
			colonnederiv = new EObjectContainmentEList<ColonneDeriv>(ColonneDeriv.class, this, TablePackage.TABLE_RESULTANTE__COLONNEDERIV);
		}
		return colonnederiv;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.TABLE_RESULTANTE__NOM, oldNom, nom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE:
				return basicSetColonneidresultante(null, msgs);
			case TablePackage.TABLE_RESULTANTE__COLONNESAISIERES:
				return ((InternalEList<?>)getColonnesaisieres()).basicRemove(otherEnd, msgs);
			case TablePackage.TABLE_RESULTANTE__COLONNEDERIV:
				return ((InternalEList<?>)getColonnederiv()).basicRemove(otherEnd, msgs);
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
			case TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE:
				return getColonneidresultante();
			case TablePackage.TABLE_RESULTANTE__COLONNESAISIERES:
				return getColonnesaisieres();
			case TablePackage.TABLE_RESULTANTE__COLONNEDERIV:
				return getColonnederiv();
			case TablePackage.TABLE_RESULTANTE__NOM:
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
			case TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE:
				setColonneidresultante((colonneIdResultante)newValue);
				return;
			case TablePackage.TABLE_RESULTANTE__COLONNESAISIERES:
				getColonnesaisieres().clear();
				getColonnesaisieres().addAll((Collection<? extends ColonneSaisieRes>)newValue);
				return;
			case TablePackage.TABLE_RESULTANTE__COLONNEDERIV:
				getColonnederiv().clear();
				getColonnederiv().addAll((Collection<? extends ColonneDeriv>)newValue);
				return;
			case TablePackage.TABLE_RESULTANTE__NOM:
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
			case TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE:
				setColonneidresultante((colonneIdResultante)null);
				return;
			case TablePackage.TABLE_RESULTANTE__COLONNESAISIERES:
				getColonnesaisieres().clear();
				return;
			case TablePackage.TABLE_RESULTANTE__COLONNEDERIV:
				getColonnederiv().clear();
				return;
			case TablePackage.TABLE_RESULTANTE__NOM:
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
			case TablePackage.TABLE_RESULTANTE__COLONNEIDRESULTANTE:
				return colonneidresultante != null;
			case TablePackage.TABLE_RESULTANTE__COLONNESAISIERES:
				return colonnesaisieres != null && !colonnesaisieres.isEmpty();
			case TablePackage.TABLE_RESULTANTE__COLONNEDERIV:
				return colonnederiv != null && !colonnederiv.isEmpty();
			case TablePackage.TABLE_RESULTANTE__NOM:
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

} //TableResultanteImpl
