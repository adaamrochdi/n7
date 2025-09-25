/**
 */
package algo.impl;

import algo.AlgoPackage;
import algo.PortEntree;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import table.Colonne;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Entree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link algo.impl.PortEntreeImpl#getCole <em>Cole</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortEntreeImpl extends MinimalEObjectImpl.Container implements PortEntree {
	/**
	 * The cached value of the '{@link #getCole() <em>Cole</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCole()
	 * @generated
	 * @ordered
	 */
	protected EList<Colonne> cole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortEntreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgoPackage.Literals.PORT_ENTREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Colonne> getCole() {
		if (cole == null) {
			cole = new EObjectResolvingEList<Colonne>(Colonne.class, this, AlgoPackage.PORT_ENTREE__COLE);
		}
		return cole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlgoPackage.PORT_ENTREE__COLE:
				return getCole();
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
			case AlgoPackage.PORT_ENTREE__COLE:
				getCole().clear();
				getCole().addAll((Collection<? extends Colonne>)newValue);
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
			case AlgoPackage.PORT_ENTREE__COLE:
				getCole().clear();
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
			case AlgoPackage.PORT_ENTREE__COLE:
				return cole != null && !cole.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PortEntreeImpl
