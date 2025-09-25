/**
 */
package table.tests;

import junit.textui.TestRunner;

import table.ColonneSaisieRes;
import table.TableFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Colonne Saisie Res</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ColonneSaisieResTest extends ColonneTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ColonneSaisieResTest.class);
	}

	/**
	 * Constructs a new Colonne Saisie Res test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColonneSaisieResTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Colonne Saisie Res test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ColonneSaisieRes getFixture() {
		return (ColonneSaisieRes)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TableFactory.eINSTANCE.createColonneSaisieRes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ColonneSaisieResTest
