/**
 */
package calcul.tests;

import calcul.CalculFactory;
import calcul.EntreeConstanteString;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entree Constante String</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntreeConstanteStringTest extends EntreeConstanteTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntreeConstanteStringTest.class);
	}

	/**
	 * Constructs a new Entree Constante String test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntreeConstanteStringTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entree Constante String test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EntreeConstanteString getFixture() {
		return (EntreeConstanteString)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CalculFactory.eINSTANCE.createEntreeConstanteString());
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

} //EntreeConstanteStringTest
