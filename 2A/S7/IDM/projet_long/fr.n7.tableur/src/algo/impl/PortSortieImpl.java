/**
 */
package algo.impl;

import algo.AlgoPackage;
import algo.Algorithme;
import algo.PortSortie;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import table.ColonneDeriv;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Sortie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link algo.impl.PortSortieImpl#getCols <em>Cols</em>}</li>
 *   <li>{@link algo.impl.PortSortieImpl#getAlgorithme <em>Algorithme</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortSortieImpl extends MinimalEObjectImpl.Container implements PortSortie {
	/**
	 * The cached value of the '{@link #getCols() <em>Cols</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCols()
	 * @generated
	 * @ordered
	 */
	protected EList<ColonneDeriv> cols;

	/**
	 * The cached value of the '{@link #getAlgorithme() <em>Algorithme</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithme()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithme> algorithme;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortSortieImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgoPackage.Literals.PORT_SORTIE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ColonneDeriv> getCols() {
		if (cols == null) {
			cols = new EObjectResolvingEList<ColonneDeriv>(ColonneDeriv.class, this, AlgoPackage.PORT_SORTIE__COLS);
		}
		return cols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Algorithme> getAlgorithme() {
		if (algorithme == null) {
			algorithme = new EObjectContainmentEList<Algorithme>(Algorithme.class, this, AlgoPackage.PORT_SORTIE__ALGORITHME);
		}
		return algorithme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgoPackage.PORT_SORTIE__ALGORITHME:
				return ((InternalEList<?>)getAlgorithme()).basicRemove(otherEnd, msgs);
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
			case AlgoPackage.PORT_SORTIE__COLS:
				return getCols();
			case AlgoPackage.PORT_SORTIE__ALGORITHME:
				return getAlgorithme();
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
			case AlgoPackage.PORT_SORTIE__COLS:
				getCols().clear();
				getCols().addAll((Collection<? extends ColonneDeriv>)newValue);
				return;
			case AlgoPackage.PORT_SORTIE__ALGORITHME:
				getAlgorithme().clear();
				getAlgorithme().addAll((Collection<? extends Algorithme>)newValue);
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
			case AlgoPackage.PORT_SORTIE__COLS:
				getCols().clear();
				return;
			case AlgoPackage.PORT_SORTIE__ALGORITHME:
				getAlgorithme().clear();
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
			case AlgoPackage.PORT_SORTIE__COLS:
				return cols != null && !cols.isEmpty();
			case AlgoPackage.PORT_SORTIE__ALGORITHME:
				return algorithme != null && !algorithme.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PortSortieImpl
