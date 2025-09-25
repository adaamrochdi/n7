/**
 */
package calcul;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operation BType</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see calcul.CalculPackage#getOperationBType()
 * @model
 * @generated
 */
public enum OperationBType implements Enumerator {
	/**
	 * The '<em><b>SOMME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOMME_VALUE
	 * @generated
	 * @ordered
	 */
	SOMME(0, "SOMME", "SOMME"),

	/**
	 * The '<em><b>SOUSTRACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUSTRACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SOUSTRACTION(1, "SOUSTRACTION", "SOUSTRACTION"),

	/**
	 * The '<em><b>PRODUIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUIT_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUIT(2, "PRODUIT", "PRODUIT"),

	/**
	 * The '<em><b>MAXIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MAXIMUM(3, "MAXIMUM", "MAXIMUM"),

	/**
	 * The '<em><b>MINIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMUM(4, "MINIMUM", "MINIMUM"),

	/**
	 * The '<em><b>DIVISION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVISION_VALUE
	 * @generated
	 * @ordered
	 */
	DIVISION(5, "DIVISION", "DIVISION");

	/**
	 * The '<em><b>SOMME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOMME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOMME_VALUE = 0;

	/**
	 * The '<em><b>SOUSTRACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUSTRACTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOUSTRACTION_VALUE = 1;

	/**
	 * The '<em><b>PRODUIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRODUIT_VALUE = 2;

	/**
	 * The '<em><b>MAXIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAXIMUM_VALUE = 3;

	/**
	 * The '<em><b>MINIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MINIMUM_VALUE = 4;

	/**
	 * The '<em><b>DIVISION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVISION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIVISION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Operation BType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OperationBType[] VALUES_ARRAY =
		new OperationBType[] {
			SOMME,
			SOUSTRACTION,
			PRODUIT,
			MAXIMUM,
			MINIMUM,
			DIVISION,
		};

	/**
	 * A public read-only list of all the '<em><b>Operation BType</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OperationBType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operation BType</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationBType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperationBType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation BType</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationBType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperationBType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation BType</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static OperationBType get(int value) {
		switch (value) {
			case SOMME_VALUE: return SOMME;
			case SOUSTRACTION_VALUE: return SOUSTRACTION;
			case PRODUIT_VALUE: return PRODUIT;
			case MAXIMUM_VALUE: return MAXIMUM;
			case MINIMUM_VALUE: return MINIMUM;
			case DIVISION_VALUE: return DIVISION;
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
	private OperationBType(int value, String name, String literal) {
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
	
} //OperationBType
