/**
 */
package table;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see table.TableFactory
 * @model kind="package"
 * @generated
 */
public interface TablePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "table";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://table";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "table";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TablePackage eINSTANCE = table.impl.TablePackageImpl.init();

	/**
	 * The meta object id for the '{@link table.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.TableImpl
	 * @see table.impl.TablePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 0;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NOM = 0;

	/**
	 * The feature id for the '<em><b>Tablesource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TABLESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Tableresultante</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__TABLERESULTANTE = 2;

	/**
	 * The feature id for the '<em><b>Script</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__SCRIPT = 3;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.impl.ColonneImpl <em>Colonne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ColonneImpl
	 * @see table.impl.TablePackageImpl#getColonne()
	 * @generated
	 */
	int COLONNE = 1;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__NOM = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__ID = 1;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__VALEURS = 2;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE__CONTRAINTE = 3;

	/**
	 * The number of structural features of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Colonne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.impl.ColonneIdImpl <em>Colonne Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ColonneIdImpl
	 * @see table.impl.TablePackageImpl#getColonneId()
	 * @generated
	 */
	int COLONNE_ID = 2;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID__NOM = COLONNE__NOM;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID__ID = COLONNE__ID;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID__VALEURS = COLONNE__VALEURS;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID__CONTRAINTE = COLONNE__CONTRAINTE;

	/**
	 * The number of structural features of the '<em>Colonne Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Colonne Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.ColonneSaisieImpl <em>Colonne Saisie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ColonneSaisieImpl
	 * @see table.impl.TablePackageImpl#getColonneSaisie()
	 * @generated
	 */
	int COLONNE_SAISIE = 3;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE__NOM = COLONNE__NOM;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE__ID = COLONNE__ID;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE__VALEURS = COLONNE__VALEURS;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE__CONTRAINTE = COLONNE__CONTRAINTE;

	/**
	 * The number of structural features of the '<em>Colonne Saisie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Colonne Saisie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.ColonneDerivImpl <em>Colonne Deriv</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ColonneDerivImpl
	 * @see table.impl.TablePackageImpl#getColonneDeriv()
	 * @generated
	 */
	int COLONNE_DERIV = 4;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV__NOM = COLONNE__NOM;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV__ID = COLONNE__ID;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV__VALEURS = COLONNE__VALEURS;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV__CONTRAINTE = COLONNE__CONTRAINTE;

	/**
	 * The feature id for the '<em><b>Script</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV__SCRIPT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Colonne Deriv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Colonne Deriv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_DERIV_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.ContrainteImpl <em>Contrainte</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ContrainteImpl
	 * @see table.impl.TablePackageImpl#getContrainte()
	 * @generated
	 */
	int CONTRAINTE = 5;

	/**
	 * The number of structural features of the '<em>Contrainte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Contrainte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.impl.ContrainteOperationImpl <em>Contrainte Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ContrainteOperationImpl
	 * @see table.impl.TablePackageImpl#getContrainteOperation()
	 * @generated
	 */
	int CONTRAINTE_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_OPERATION__TYPE = CONTRAINTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>VComparee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_OPERATION__VCOMPAREE = CONTRAINTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contrainte Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_OPERATION_FEATURE_COUNT = CONTRAINTE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Contrainte Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRAINTE_OPERATION_OPERATION_COUNT = CONTRAINTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.TableSourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.TableSourceImpl
	 * @see table.impl.TablePackageImpl#getTableSource()
	 * @generated
	 */
	int TABLE_SOURCE = 7;

	/**
	 * The feature id for the '<em><b>Colonnesaisie</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_SOURCE__COLONNESAISIE = 0;

	/**
	 * The feature id for the '<em><b>Colonneid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_SOURCE__COLONNEID = 1;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_SOURCE__NOM = 2;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_SOURCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.impl.TableResultanteImpl <em>Resultante</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.TableResultanteImpl
	 * @see table.impl.TablePackageImpl#getTableResultante()
	 * @generated
	 */
	int TABLE_RESULTANTE = 8;

	/**
	 * The feature id for the '<em><b>Colonneidresultante</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE__COLONNEIDRESULTANTE = 0;

	/**
	 * The feature id for the '<em><b>Colonnesaisieres</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE__COLONNESAISIERES = 1;

	/**
	 * The feature id for the '<em><b>Colonnederiv</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE__COLONNEDERIV = 2;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE__NOM = 3;

	/**
	 * The number of structural features of the '<em>Resultante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Resultante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_RESULTANTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.impl.colonneIdResultanteImpl <em>colonne Id Resultante</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.colonneIdResultanteImpl
	 * @see table.impl.TablePackageImpl#getcolonneIdResultante()
	 * @generated
	 */
	int COLONNE_ID_RESULTANTE = 9;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE__NOM = COLONNE__NOM;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE__ID = COLONNE__ID;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE__VALEURS = COLONNE__VALEURS;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE__CONTRAINTE = COLONNE__CONTRAINTE;

	/**
	 * The number of structural features of the '<em>colonne Id Resultante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>colonne Id Resultante</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_ID_RESULTANTE_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.ColonneSaisieResImpl <em>Colonne Saisie Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ColonneSaisieResImpl
	 * @see table.impl.TablePackageImpl#getColonneSaisieRes()
	 * @generated
	 */
	int COLONNE_SAISIE_RES = 10;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES__NOM = COLONNE__NOM;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES__ID = COLONNE__ID;

	/**
	 * The feature id for the '<em><b>Valeurs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES__VALEURS = COLONNE__VALEURS;

	/**
	 * The feature id for the '<em><b>Contrainte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES__CONTRAINTE = COLONNE__CONTRAINTE;

	/**
	 * The number of structural features of the '<em>Colonne Saisie Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES_FEATURE_COUNT = COLONNE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Colonne Saisie Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLONNE_SAISIE_RES_OPERATION_COUNT = COLONNE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link table.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.impl.ScriptImpl
	 * @see table.impl.TablePackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 11;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__NOM = 0;

	/**
	 * The feature id for the '<em><b>Sortie</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__SORTIE = 1;

	/**
	 * The feature id for the '<em><b>Entree</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__ENTREE = 2;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link table.OpContrainte <em>Op Contrainte</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see table.OpContrainte
	 * @see table.impl.TablePackageImpl#getOpContrainte()
	 * @generated
	 */
	int OP_CONTRAINTE = 12;


	/**
	 * Returns the meta object for class '{@link table.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see table.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link table.Table#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see table.Table#getNom()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Nom();

	/**
	 * Returns the meta object for the containment reference list '{@link table.Table#getTablesource <em>Tablesource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tablesource</em>'.
	 * @see table.Table#getTablesource()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Tablesource();

	/**
	 * Returns the meta object for the containment reference list '{@link table.Table#getTableresultante <em>Tableresultante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tableresultante</em>'.
	 * @see table.Table#getTableresultante()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Tableresultante();

	/**
	 * Returns the meta object for the containment reference list '{@link table.Table#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Script</em>'.
	 * @see table.Table#getScript()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Script();

	/**
	 * Returns the meta object for class '{@link table.Colonne <em>Colonne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne</em>'.
	 * @see table.Colonne
	 * @generated
	 */
	EClass getColonne();

	/**
	 * Returns the meta object for the attribute '{@link table.Colonne#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see table.Colonne#getNom()
	 * @see #getColonne()
	 * @generated
	 */
	EAttribute getColonne_Nom();

	/**
	 * Returns the meta object for the attribute '{@link table.Colonne#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see table.Colonne#getId()
	 * @see #getColonne()
	 * @generated
	 */
	EAttribute getColonne_Id();

	/**
	 * Returns the meta object for the attribute list '{@link table.Colonne#getValeurs <em>Valeurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Valeurs</em>'.
	 * @see table.Colonne#getValeurs()
	 * @see #getColonne()
	 * @generated
	 */
	EAttribute getColonne_Valeurs();

	/**
	 * Returns the meta object for the containment reference list '{@link table.Colonne#getContrainte <em>Contrainte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contrainte</em>'.
	 * @see table.Colonne#getContrainte()
	 * @see #getColonne()
	 * @generated
	 */
	EReference getColonne_Contrainte();

	/**
	 * Returns the meta object for class '{@link table.ColonneId <em>Colonne Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Id</em>'.
	 * @see table.ColonneId
	 * @generated
	 */
	EClass getColonneId();

	/**
	 * Returns the meta object for class '{@link table.ColonneSaisie <em>Colonne Saisie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Saisie</em>'.
	 * @see table.ColonneSaisie
	 * @generated
	 */
	EClass getColonneSaisie();

	/**
	 * Returns the meta object for class '{@link table.ColonneDeriv <em>Colonne Deriv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Deriv</em>'.
	 * @see table.ColonneDeriv
	 * @generated
	 */
	EClass getColonneDeriv();

	/**
	 * Returns the meta object for the reference '{@link table.ColonneDeriv#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Script</em>'.
	 * @see table.ColonneDeriv#getScript()
	 * @see #getColonneDeriv()
	 * @generated
	 */
	EReference getColonneDeriv_Script();

	/**
	 * Returns the meta object for class '{@link table.Contrainte <em>Contrainte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contrainte</em>'.
	 * @see table.Contrainte
	 * @generated
	 */
	EClass getContrainte();

	/**
	 * Returns the meta object for class '{@link table.ContrainteOperation <em>Contrainte Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contrainte Operation</em>'.
	 * @see table.ContrainteOperation
	 * @generated
	 */
	EClass getContrainteOperation();

	/**
	 * Returns the meta object for the attribute '{@link table.ContrainteOperation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see table.ContrainteOperation#getType()
	 * @see #getContrainteOperation()
	 * @generated
	 */
	EAttribute getContrainteOperation_Type();

	/**
	 * Returns the meta object for the attribute '{@link table.ContrainteOperation#getVComparee <em>VComparee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>VComparee</em>'.
	 * @see table.ContrainteOperation#getVComparee()
	 * @see #getContrainteOperation()
	 * @generated
	 */
	EAttribute getContrainteOperation_VComparee();

	/**
	 * Returns the meta object for class '{@link table.TableSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source</em>'.
	 * @see table.TableSource
	 * @generated
	 */
	EClass getTableSource();

	/**
	 * Returns the meta object for the containment reference list '{@link table.TableSource#getColonnesaisie <em>Colonnesaisie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonnesaisie</em>'.
	 * @see table.TableSource#getColonnesaisie()
	 * @see #getTableSource()
	 * @generated
	 */
	EReference getTableSource_Colonnesaisie();

	/**
	 * Returns the meta object for the containment reference '{@link table.TableSource#getColonneid <em>Colonneid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Colonneid</em>'.
	 * @see table.TableSource#getColonneid()
	 * @see #getTableSource()
	 * @generated
	 */
	EReference getTableSource_Colonneid();

	/**
	 * Returns the meta object for the attribute '{@link table.TableSource#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see table.TableSource#getNom()
	 * @see #getTableSource()
	 * @generated
	 */
	EAttribute getTableSource_Nom();

	/**
	 * Returns the meta object for class '{@link table.TableResultante <em>Resultante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resultante</em>'.
	 * @see table.TableResultante
	 * @generated
	 */
	EClass getTableResultante();

	/**
	 * Returns the meta object for the containment reference '{@link table.TableResultante#getColonneidresultante <em>Colonneidresultante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Colonneidresultante</em>'.
	 * @see table.TableResultante#getColonneidresultante()
	 * @see #getTableResultante()
	 * @generated
	 */
	EReference getTableResultante_Colonneidresultante();

	/**
	 * Returns the meta object for the containment reference list '{@link table.TableResultante#getColonnesaisieres <em>Colonnesaisieres</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonnesaisieres</em>'.
	 * @see table.TableResultante#getColonnesaisieres()
	 * @see #getTableResultante()
	 * @generated
	 */
	EReference getTableResultante_Colonnesaisieres();

	/**
	 * Returns the meta object for the containment reference list '{@link table.TableResultante#getColonnederiv <em>Colonnederiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Colonnederiv</em>'.
	 * @see table.TableResultante#getColonnederiv()
	 * @see #getTableResultante()
	 * @generated
	 */
	EReference getTableResultante_Colonnederiv();

	/**
	 * Returns the meta object for the attribute '{@link table.TableResultante#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see table.TableResultante#getNom()
	 * @see #getTableResultante()
	 * @generated
	 */
	EAttribute getTableResultante_Nom();

	/**
	 * Returns the meta object for class '{@link table.colonneIdResultante <em>colonne Id Resultante</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>colonne Id Resultante</em>'.
	 * @see table.colonneIdResultante
	 * @generated
	 */
	EClass getcolonneIdResultante();

	/**
	 * Returns the meta object for class '{@link table.ColonneSaisieRes <em>Colonne Saisie Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colonne Saisie Res</em>'.
	 * @see table.ColonneSaisieRes
	 * @generated
	 */
	EClass getColonneSaisieRes();

	/**
	 * Returns the meta object for class '{@link table.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see table.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the attribute '{@link table.Script#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see table.Script#getNom()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Nom();

	/**
	 * Returns the meta object for the reference '{@link table.Script#getSortie <em>Sortie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sortie</em>'.
	 * @see table.Script#getSortie()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Sortie();

	/**
	 * Returns the meta object for the reference list '{@link table.Script#getEntree <em>Entree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entree</em>'.
	 * @see table.Script#getEntree()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Entree();

	/**
	 * Returns the meta object for enum '{@link table.OpContrainte <em>Op Contrainte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Op Contrainte</em>'.
	 * @see table.OpContrainte
	 * @generated
	 */
	EEnum getOpContrainte();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TableFactory getTableFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link table.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.TableImpl
		 * @see table.impl.TablePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NOM = eINSTANCE.getTable_Nom();

		/**
		 * The meta object literal for the '<em><b>Tablesource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TABLESOURCE = eINSTANCE.getTable_Tablesource();

		/**
		 * The meta object literal for the '<em><b>Tableresultante</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__TABLERESULTANTE = eINSTANCE.getTable_Tableresultante();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__SCRIPT = eINSTANCE.getTable_Script();

		/**
		 * The meta object literal for the '{@link table.impl.ColonneImpl <em>Colonne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ColonneImpl
		 * @see table.impl.TablePackageImpl#getColonne()
		 * @generated
		 */
		EClass COLONNE = eINSTANCE.getColonne();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLONNE__NOM = eINSTANCE.getColonne_Nom();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLONNE__ID = eINSTANCE.getColonne_Id();

		/**
		 * The meta object literal for the '<em><b>Valeurs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLONNE__VALEURS = eINSTANCE.getColonne_Valeurs();

		/**
		 * The meta object literal for the '<em><b>Contrainte</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE__CONTRAINTE = eINSTANCE.getColonne_Contrainte();

		/**
		 * The meta object literal for the '{@link table.impl.ColonneIdImpl <em>Colonne Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ColonneIdImpl
		 * @see table.impl.TablePackageImpl#getColonneId()
		 * @generated
		 */
		EClass COLONNE_ID = eINSTANCE.getColonneId();

		/**
		 * The meta object literal for the '{@link table.impl.ColonneSaisieImpl <em>Colonne Saisie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ColonneSaisieImpl
		 * @see table.impl.TablePackageImpl#getColonneSaisie()
		 * @generated
		 */
		EClass COLONNE_SAISIE = eINSTANCE.getColonneSaisie();

		/**
		 * The meta object literal for the '{@link table.impl.ColonneDerivImpl <em>Colonne Deriv</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ColonneDerivImpl
		 * @see table.impl.TablePackageImpl#getColonneDeriv()
		 * @generated
		 */
		EClass COLONNE_DERIV = eINSTANCE.getColonneDeriv();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLONNE_DERIV__SCRIPT = eINSTANCE.getColonneDeriv_Script();

		/**
		 * The meta object literal for the '{@link table.impl.ContrainteImpl <em>Contrainte</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ContrainteImpl
		 * @see table.impl.TablePackageImpl#getContrainte()
		 * @generated
		 */
		EClass CONTRAINTE = eINSTANCE.getContrainte();

		/**
		 * The meta object literal for the '{@link table.impl.ContrainteOperationImpl <em>Contrainte Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ContrainteOperationImpl
		 * @see table.impl.TablePackageImpl#getContrainteOperation()
		 * @generated
		 */
		EClass CONTRAINTE_OPERATION = eINSTANCE.getContrainteOperation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRAINTE_OPERATION__TYPE = eINSTANCE.getContrainteOperation_Type();

		/**
		 * The meta object literal for the '<em><b>VComparee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRAINTE_OPERATION__VCOMPAREE = eINSTANCE.getContrainteOperation_VComparee();

		/**
		 * The meta object literal for the '{@link table.impl.TableSourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.TableSourceImpl
		 * @see table.impl.TablePackageImpl#getTableSource()
		 * @generated
		 */
		EClass TABLE_SOURCE = eINSTANCE.getTableSource();

		/**
		 * The meta object literal for the '<em><b>Colonnesaisie</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_SOURCE__COLONNESAISIE = eINSTANCE.getTableSource_Colonnesaisie();

		/**
		 * The meta object literal for the '<em><b>Colonneid</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_SOURCE__COLONNEID = eINSTANCE.getTableSource_Colonneid();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_SOURCE__NOM = eINSTANCE.getTableSource_Nom();

		/**
		 * The meta object literal for the '{@link table.impl.TableResultanteImpl <em>Resultante</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.TableResultanteImpl
		 * @see table.impl.TablePackageImpl#getTableResultante()
		 * @generated
		 */
		EClass TABLE_RESULTANTE = eINSTANCE.getTableResultante();

		/**
		 * The meta object literal for the '<em><b>Colonneidresultante</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_RESULTANTE__COLONNEIDRESULTANTE = eINSTANCE.getTableResultante_Colonneidresultante();

		/**
		 * The meta object literal for the '<em><b>Colonnesaisieres</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_RESULTANTE__COLONNESAISIERES = eINSTANCE.getTableResultante_Colonnesaisieres();

		/**
		 * The meta object literal for the '<em><b>Colonnederiv</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_RESULTANTE__COLONNEDERIV = eINSTANCE.getTableResultante_Colonnederiv();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_RESULTANTE__NOM = eINSTANCE.getTableResultante_Nom();

		/**
		 * The meta object literal for the '{@link table.impl.colonneIdResultanteImpl <em>colonne Id Resultante</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.colonneIdResultanteImpl
		 * @see table.impl.TablePackageImpl#getcolonneIdResultante()
		 * @generated
		 */
		EClass COLONNE_ID_RESULTANTE = eINSTANCE.getcolonneIdResultante();

		/**
		 * The meta object literal for the '{@link table.impl.ColonneSaisieResImpl <em>Colonne Saisie Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ColonneSaisieResImpl
		 * @see table.impl.TablePackageImpl#getColonneSaisieRes()
		 * @generated
		 */
		EClass COLONNE_SAISIE_RES = eINSTANCE.getColonneSaisieRes();

		/**
		 * The meta object literal for the '{@link table.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.impl.ScriptImpl
		 * @see table.impl.TablePackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__NOM = eINSTANCE.getScript_Nom();

		/**
		 * The meta object literal for the '<em><b>Sortie</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__SORTIE = eINSTANCE.getScript_Sortie();

		/**
		 * The meta object literal for the '<em><b>Entree</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT__ENTREE = eINSTANCE.getScript_Entree();

		/**
		 * The meta object literal for the '{@link table.OpContrainte <em>Op Contrainte</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see table.OpContrainte
		 * @see table.impl.TablePackageImpl#getOpContrainte()
		 * @generated
		 */
		EEnum OP_CONTRAINTE = eINSTANCE.getOpContrainte();

	}

} //TablePackage
