/**
 */
package calcul.tests;

import calcul.CalculFactory;
import calcul.SortieOperateur;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sortie Operateur</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SortieOperateurTest extends SortieTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SortieOperateurTest.class);
	}

	/**
	 * Constructs a new Sortie Operateur test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortieOperateurTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sortie Operateur test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SortieOperateur getFixture() {
		return (SortieOperateur)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CalculFactory.eINSTANCE.createSortieOperateur());
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

} //SortieOperateurTest
