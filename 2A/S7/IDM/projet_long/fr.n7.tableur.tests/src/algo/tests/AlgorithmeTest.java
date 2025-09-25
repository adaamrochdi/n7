/**
 */
package algo.tests;

import algo.AlgoFactory;
import algo.Algorithme;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Algorithme</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlgorithmeTest extends TestCase {

	/**
	 * The fixture for this Algorithme test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Algorithme fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlgorithmeTest.class);
	}

	/**
	 * Constructs a new Algorithme test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Algorithme test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Algorithme fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Algorithme test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Algorithme getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AlgoFactory.eINSTANCE.createAlgorithme());
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

} //AlgorithmeTest
