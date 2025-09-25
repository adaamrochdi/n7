import math

# Fcts binaires
def operer_binaire_SOMME(op1, op2):
    if isinstance(op1, bool) or isinstance(op2, bool):
        return bool(op1) + bool(op2)
    if isinstance(op1, str) or isinstance(op2, str):
        return str(op1) + str(op2)
    if isinstance(op1, int) and isinstance(op2, int):
        return op1 + op2
    return float(op1) + float(op2)

def operer_binaire_SOUSTRACTION(op1, op2):
    if isinstance(op1, bool) or isinstance(op2, bool):
        return bool(op1) - bool(op2)
    if isinstance(op1, int) and isinstance(op2, int):
        return op1 - op2
    return float(op1) - float(op2)

def operer_binaire_PRODUIT(op1, op2):
    if isinstance(op1, bool) or isinstance(op2, bool):
        return bool(op1) * bool(op2)
    if isinstance(op1, str) and isinstance(op2, int):
        return op1 * op2  # Répète la chaîne
    if isinstance(op1, int) and isinstance(op2, int):
        return op1 * op2
    return float(op1) * float(op2)

def operer_binaire_DIVISION(op1, op2):
    if float(op2) == 0:
        raise ZeroDivisionError("DIVISION : Division par zéro interdite.")
    result = float(op1) / float(op2)
    return int(result) if result.is_integer() else result

# Fcts unaires
def operer_unaire_COS(op):
    return maths_calcul(op, math.cos)

def operer_unaire_SIN(op):
    return maths_calcul(op, math.sin)

def operer_unaire_EXP(op):
    return maths_calcul(op, math.exp)

def operer_unaire_LOG(op):
    if isinstance(op, (int, float)) and op <= 0:
        raise ValueError("LOG : L'opérande doit être strictement positif.")
    return maths_calcul(op, math.log)

def maths_calcul(op, func):
    if isinstance(op, bool):
        op = int(op)
    elif isinstance(op, str):
        raise TypeError("Les chaînes ne sont pas acceptées pour les opérations mathématiques.")
    return func(float(op))
