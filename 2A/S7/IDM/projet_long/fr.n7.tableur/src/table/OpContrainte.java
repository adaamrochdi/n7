/**
 */
package table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Op Contrainte</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see table.TablePackage#getOpContrainte()
 * @model
 * @generated
 */
public enum OpContrainte implements Enumerator {
	/**
	 * The '<em><b>SUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUP_VALUE
	 * @generated
	 * @ordered
	 */
	SUP(0, "SUP", "SUP"),

	/**
	 * The '<em><b>INF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INF_VALUE
	 * @generated
	 * @ordered
	 */
	INF(1, "INF", "INF"),

	/**
	 * The '<em><b>EGAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EGAL_VALUE
	 * @generated
	 * @ordered
	 */
	EGAL(2, "EGAL", "EGAL"),

	/**
	 * The '<em><b>SUP OU EGAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUP_OU_EGAL_VALUE
	 * @generated
	 * @ordered
	 */
	SUP_OU_EGAL(3, "SUP_OU_EGAL", "SUP_OU_EGAL"),

	/**
	 * The '<em><b>INF OU EGAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INF_OU_EGAL_VALUE
	 * @generated
	 * @ordered
	 */
	INF_OU_EGAL(4, "INF_OU_EGAL", "INF_OU_EGAL");

	/**
	 * The '<em><b>SUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUP_VALUE = 0;

	/**
	 * The '<em><b>INF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INF_VALUE = 1;

	/**
	 * The '<em><b>EGAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EGAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EGAL_VALUE = 2;

	/**
	 * The '<em><b>SUP OU EGAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUP_OU_EGAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUP_OU_EGAL_VALUE = 3;

	/**
	 * The '<em><b>INF OU EGAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INF_OU_EGAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INF_OU_EGAL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Op Contrainte</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OpContrainte[] VALUES_ARRAY =
		new OpContrainte[] {
			SUP,
			INF,
			EGAL,
			SUP_OU_EGAL,
			INF_OU_EGAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Op Contrainte</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OpContrainte> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Op Contrainte</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OpContrainte get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpContrainte result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Op Contrainte</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OpContrainte getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OpContrainte result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Op Contrainte</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OpContrainte get(int value) {
		switch (value) {
			case SUP_VALUE: return SUP;
			case INF_VALUE: return INF;
			case EGAL_VALUE: return EGAL;
			case SUP_OU_EGAL_VALUE: return SUP_OU_EGAL;
			case INF_OU_EGAL_VALUE: return INF_OU_EGAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private OpContrainte(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //OpContrainte
