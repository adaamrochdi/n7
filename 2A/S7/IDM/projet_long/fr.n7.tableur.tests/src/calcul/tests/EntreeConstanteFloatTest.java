/**
 */
package calcul.tests;

import calcul.CalculFactory;
import calcul.EntreeConstanteFloat;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entree Constante Float</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntreeConstanteFloatTest extends EntreeConstanteTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntreeConstanteFloatTest.class);
	}

	/**
	 * Constructs a new Entree Constante Float test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntreeConstanteFloatTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entree Constante Float test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EntreeConstanteFloat getFixture() {
		return (EntreeConstanteFloat)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CalculFactory.eINSTANCE.createEntreeConstanteFloat());
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

} //EntreeConstanteFloatTest
