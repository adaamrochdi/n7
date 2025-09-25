/**
 */
package table.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import table.TableFactory;
import table.TableSource;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TableSourceTest extends TestCase {

	/**
	 * The fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableSource fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TableSourceTest.class);
	}

	/**
	 * Constructs a new Source test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableSourceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TableSource fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Source test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableSource getFixture() {
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
		setFixture(TableFactory.eINSTANCE.createTableSource());
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

} //TableSourceTest
