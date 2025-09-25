/**
 */
package calcul.tests;

import calcul.CalculFactory;
import calcul.EntreeConstanteInt;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entree Constante Int</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntreeConstanteIntTest extends EntreeConstanteTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntreeConstanteIntTest.class);
	}

	/**
	 * Constructs a new Entree Constante Int test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntreeConstanteIntTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entree Constante Int test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EntreeConstanteInt getFixture() {
		return (EntreeConstanteInt)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CalculFactory.eINSTANCE.createEntreeConstanteInt());
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

} //EntreeConstanteIntTest
