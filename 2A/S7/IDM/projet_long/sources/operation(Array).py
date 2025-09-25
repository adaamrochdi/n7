import numpy as np

# Fcts binaires
def operer_binaire_SOMME(array1, array2):
    if array1.dtype == 'bool' and array2.dtype == 'bool':
        return np.logical_or(array1, array2)  # Booléen = OR logique
    if np.issubdtype(array1.dtype, np.str_) or np.issubdtype(array2.dtype, np.str_):
        return np.char.add(array1, array2)
    return np.add(array1, array2)

def operer_binaire_SOUSTRACTION(array1, array2):
    if array1.dtype == 'bool' or array2.dtype == 'bool':
        raise TypeError("Soustraction non supportée pour les booléens.")
    return np.subtract(array1, array2)

def operer_binaire_MULTIPLICATION(array1, array2):
    if array1.dtype == 'bool' or array2.dtype == 'bool':
        return np.logical_and(array1, array2)  
    if np.issubdtype(array1.dtype, np.str_) or np.issubdtype(array2.dtype, np.str_):
        raise TypeError("Multiplication non supportée pour les chaînes de caractères.")
    return np.multiply(array1, array2)

def operer_binaire_DIVISION(array1, array2):
    if array1.dtype == 'bool' or array2.dtype == 'bool':
        raise TypeError("Division non supportée pour les booléens.")
    with np.errstate(divide='ignore', invalid='ignore'):
        result = np.true_divide(array1, array2)
        result[np.isnan(result)] = 0
    return result

# Fcts unaires
def operer_unaire_COS(array):
    if array.dtype == 'bool':
        array = array.astype(float)  # On convertit les bool en float
    return np.cos(array)

def operer_unaire_SIN(array):
    if array.dtype == 'bool':
        array = array.astype(float)
    return np.sin(array)

def operer_unaire_EXP(array):
    if array.dtype == 'bool':
        array = array.astype(float)
    return np.exp(array)

def operer_unaire_LOG(array):
    if array.dtype == 'bool':
        array = array.astype(float)
    with np.errstate(divide='ignore', invalid='ignore'):
        result = np.log(array)
        result[np.isnan(result)] = 0
    return result
