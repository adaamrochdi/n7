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
import table.Script;
import table.Table;
import table.TablePackage;
import table.TableResultante;
import table.TableSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link table.impl.TableImpl#getNom <em>Nom</em>}</li>
 *   <li>{@link table.impl.TableImpl#getTablesource <em>Tablesource</em>}</li>
 *   <li>{@link table.impl.TableImpl#getTableresultante <em>Tableresultante</em>}</li>
 *   <li>{@link table.impl.TableImpl#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends MinimalEObjectImpl.Container implements Table {
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
	 * The cached value of the '{@link #getTablesource() <em>Tablesource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablesource()
	 * @generated
	 * @ordered
	 */
	protected EList<TableSource> tablesource;

	/**
	 * The cached value of the '{@link #getTableresultante() <em>Tableresultante</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableresultante()
	 * @generated
	 * @ordered
	 */
	protected EList<TableResultante> tableresultante;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected EList<Script> script;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TablePackage.Literals.TABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TablePackage.TABLE__NOM, oldNom, nom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TableSource> getTablesource() {
		if (tablesource == null) {
			tablesource = new EObjectContainmentEList<TableSource>(TableSource.class, this, TablePackage.TABLE__TABLESOURCE);
		}
		return tablesource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TableResultante> getTableresultante() {
		if (tableresultante == null) {
			tableresultante = new EObjectContainmentEList<TableResultante>(TableResultante.class, this, TablePackage.TABLE__TABLERESULTANTE);
		}
		return tableresultante;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Script> getScript() {
		if (script == null) {
			script = new EObjectContainmentEList<Script>(Script.class, this, TablePackage.TABLE__SCRIPT);
		}
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TablePackage.TABLE__TABLESOURCE:
				return ((InternalEList<?>)getTablesource()).basicRemove(otherEnd, msgs);
			case TablePackage.TABLE__TABLERESULTANTE:
				return ((InternalEList<?>)getTableresultante()).basicRemove(otherEnd, msgs);
			case TablePackage.TABLE__SCRIPT:
				return ((InternalEList<?>)getScript()).basicRemove(otherEnd, msgs);
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
			case TablePackage.TABLE__NOM:
				return getNom();
			case TablePackage.TABLE__TABLESOURCE:
				return getTablesource();
			case TablePackage.TABLE__TABLERESULTANTE:
				return getTableresultante();
			case TablePackage.TABLE__SCRIPT:
				return getScript();
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
			case TablePackage.TABLE__NOM:
				setNom((String)newValue);
				return;
			case TablePackage.TABLE__TABLESOURCE:
				getTablesource().clear();
				getTablesource().addAll((Collection<? extends TableSource>)newValue);
				return;
			case TablePackage.TABLE__TABLERESULTANTE:
				getTableresultante().clear();
				getTableresultante().addAll((Collection<? extends TableResultante>)newValue);
				return;
			case TablePackage.TABLE__SCRIPT:
				getScript().clear();
				getScript().addAll((Collection<? extends Script>)newValue);
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
			case TablePackage.TABLE__NOM:
				setNom(NOM_EDEFAULT);
				return;
			case TablePackage.TABLE__TABLESOURCE:
				getTablesource().clear();
				return;
			case TablePackage.TABLE__TABLERESULTANTE:
				getTableresultante().clear();
				return;
			case TablePackage.TABLE__SCRIPT:
				getScript().clear();
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
			case TablePackage.TABLE__NOM:
				return NOM_EDEFAULT == null ? nom != null : !NOM_EDEFAULT.equals(nom);
			case TablePackage.TABLE__TABLESOURCE:
				return tablesource != null && !tablesource.isEmpty();
			case TablePackage.TABLE__TABLERESULTANTE:
				return tableresultante != null && !tableresultante.isEmpty();
			case TablePackage.TABLE__SCRIPT:
				return script != null && !script.isEmpty();
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

} //TableImpl
