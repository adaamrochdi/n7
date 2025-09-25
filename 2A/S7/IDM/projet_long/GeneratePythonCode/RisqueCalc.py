import operations as mod

def RisqueCalc(Temperature, Humidite) :
	return mod.operer_binaire_SOMME(mod.operer_binaire_DIVISION(mod.operer_binaire_SOUSTRACTION(Temperature, 22.0), 10.0), mod.operer_binaire_DIVISION(mod.operer_binaire_SOUSTRACTION(Humidite, 45.0), 50.0))


