/**
 */
package calcul.tests;

import calcul.CalculFactory;
import calcul.EntreeConstanteBool;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Entree Constante Bool</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntreeConstanteBoolTest extends EntreeConstanteTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EntreeConstanteBoolTest.class);
	}

	/**
	 * Constructs a new Entree Constante Bool test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntreeConstanteBoolTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Entree Constante Bool test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EntreeConstanteBool getFixture() {
		return (EntreeConstanteBool)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CalculFactory.eINSTANCE.createEntreeConstanteBool());
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

} //EntreeConstanteBoolTest
