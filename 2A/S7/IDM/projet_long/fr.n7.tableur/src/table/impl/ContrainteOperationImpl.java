/**
 */
package table.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import table.ContrainteOperation;
import table.OpContrainte;
import table.TablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contrainte Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link table.impl.ContrainteOperationImpl#getType <em>Type</em>}</li>
 *   <li>{@link table.impl.ContrainteOperationImpl#getVComparee <em>VComparee</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContrainteOperationImpl extends ContrainteImpl implements ContrainteOperation {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final OpContrainte TYPE_EDEFAULT = OpContrainte.SUP;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected OpContrainte type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVComparee() <em>VComparee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVComparee()
	 * @generated
	 * @ordered
	 */
	protected static final float VCOMPAREE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getVComparee() <em>VComparee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVComparee()
	 * @generated
	 * @ordered
	 */
	protected float vComparee = VCOMPAREE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContrainteOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TablePackage.Literals.CONTRAINTE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpContrainte getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(OpContrainte newType) {
		OpContrainte oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.CONTRAINTE_OPERATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getVComparee() {
		return vComparee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVComparee(float newVComparee) {
		float oldVComparee = vComparee;
		vComparee = newVComparee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.CONTRAINTE_OPERATION__VCOMPAREE, oldVComparee, vComparee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TablePackage.CONTRAINTE_OPERATION__TYPE:
				return getType();
			case TablePackage.CONTRAINTE_OPERATION__VCOMPAREE:
				return getVComparee();
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
			case TablePackage.CONTRAINTE_OPERATION__TYPE:
				setType((OpContrainte)newValue);
				return;
			case TablePackage.CONTRAINTE_OPERATION__VCOMPAREE:
				setVComparee((Float)newValue);
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
			case TablePackage.CONTRAINTE_OPERATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TablePackage.CONTRAINTE_OPERATION__VCOMPAREE:
				setVComparee(VCOMPAREE_EDEFAULT);
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
			case TablePackage.CONTRAINTE_OPERATION__TYPE:
				return type != TYPE_EDEFAULT;
			case TablePackage.CONTRAINTE_OPERATION__VCOMPAREE:
				return vComparee != VCOMPAREE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", vComparee: ");
		result.append(vComparee);
		result.append(')');
		return result.toString();
	}

} //ContrainteOperationImpl
