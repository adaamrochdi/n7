/**
 */
package calcul;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operation UType</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see calcul.CalculPackage#getOperationUType()
 * @model
 * @generated
 */
public enum OperationUType implements Enumerator {
	/**
	 * The '<em><b>OPPOSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPPOSE_VALUE
	 * @generated
	 * @ordered
	 */
	OPPOSE(0, "OPPOSE", "OPPOSE"),

	/**
	 * The '<em><b>INVERSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVERSE_VALUE
	 * @generated
	 * @ordered
	 */
	INVERSE(1, "INVERSE", "INVERSE"),

	/**
	 * The '<em><b>SINUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINUS_VALUE
	 * @generated
	 * @ordered
	 */
	SINUS(2, "SINUS", "SINUS"),

	/**
	 * The '<em><b>COSINUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSINUS_VALUE
	 * @generated
	 * @ordered
	 */
	COSINUS(3, "COSINUS", "COSINUS"),

	/**
	 * The '<em><b>SQRT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQRT_VALUE
	 * @generated
	 * @ordered
	 */
	SQRT(4, "SQRT", "SQRT"),

	/**
	 * The '<em><b>EXP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXP_VALUE
	 * @generated
	 * @ordered
	 */
	EXP(5, "EXP", "EXP");

	/**
	 * The '<em><b>OPPOSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPPOSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPPOSE_VALUE = 0;

	/**
	 * The '<em><b>INVERSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVERSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INVERSE_VALUE = 1;

	/**
	 * The '<em><b>SINUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINUS_VALUE = 2;

	/**
	 * The '<em><b>COSINUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSINUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COSINUS_VALUE = 3;

	/**
	 * The '<em><b>SQRT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SQRT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SQRT_VALUE = 4;

	/**
	 * The '<em><b>EXP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXP_VALUE = 5;

	/**
	 * An array of all the '<em><b>Operation UType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OperationUType[] VALUES_ARRAY =
		new OperationUType[] {
			OPPOSE,
			INVERSE,
			SINUS,
			COSINUS,
			SQRT,
			EXP,
		};

	/**
	 * A public read-only list of all the '<em><b>Operation UType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OperationUType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operation UType</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationUType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperationUType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation UType</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationUType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperationUType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation UType</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationUType get(int value) {
		switch (value) {
			case OPPOSE_VALUE: return OPPOSE;
			case INVERSE_VALUE: return INVERSE;
			case SINUS_VALUE: return SINUS;
			case COSINUS_VALUE: return COSINUS;
			case SQRT_VALUE: return SQRT;
			case EXP_VALUE: return EXP;
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
	private OperationUType(int value, String name, String literal) {
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
	
} //OperationUType
