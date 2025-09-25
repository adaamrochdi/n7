/**
 */
package calcul.impl;

import calcul.CalculPackage;
import calcul.OperateurUnaire;
import calcul.OperationUType;
import calcul.TypeElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operateur Unaire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link calcul.impl.OperateurUnaireImpl#getType <em>Type</em>}</li>
 *   <li>{@link calcul.impl.OperateurUnaireImpl#getOperandetype <em>Operandetype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperateurUnaireImpl extends OperateurImpl implements OperateurUnaire {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final OperationUType TYPE_EDEFAULT = OperationUType.OPPOSE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected OperationUType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperandetype() <em>Operandetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandetype()
	 * @generated
	 * @ordered
	 */
	protected static final TypeElement OPERANDETYPE_EDEFAULT = TypeElement.INT;

	/**
	 * The cached value of the '{@link #getOperandetype() <em>Operandetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandetype()
	 * @generated
	 * @ordered
	 */
	protected TypeElement operandetype = OPERANDETYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperateurUnaireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CalculPackage.Literals.OPERATEUR_UNAIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationUType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(OperationUType newType) {
		OperationUType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.OPERATEUR_UNAIRE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeElement getOperandetype() {
		return operandetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperandetype(TypeElement newOperandetype) {
		TypeElement oldOperandetype = operandetype;
		operandetype = newOperandetype == null ? OPERANDETYPE_EDEFAULT : newOperandetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CalculPackage.OPERATEUR_UNAIRE__OPERANDETYPE, oldOperandetype, operandetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CalculPackage.OPERATEUR_UNAIRE__TYPE:
				return getType();
			case CalculPackage.OPERATEUR_UNAIRE__OPERANDETYPE:
				return getOperandetype();
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
			case CalculPackage.OPERATEUR_UNAIRE__TYPE:
				setType((OperationUType)newValue);
				return;
			case CalculPackage.OPERATEUR_UNAIRE__OPERANDETYPE:
				setOperandetype((TypeElement)newValue);
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
			case CalculPackage.OPERATEUR_UNAIRE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CalculPackage.OPERATEUR_UNAIRE__OPERANDETYPE:
				setOperandetype(OPERANDETYPE_EDEFAULT);
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
			case CalculPackage.OPERATEUR_UNAIRE__TYPE:
				return type != TYPE_EDEFAULT;
			case CalculPackage.OPERATEUR_UNAIRE__OPERANDETYPE:
				return operandetype != OPERANDETYPE_EDEFAULT;
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
		result.append(", operandetype: ");
		result.append(operandetype);
		result.append(')');
		return result.toString();
	}

} //OperateurUnaireImpl
