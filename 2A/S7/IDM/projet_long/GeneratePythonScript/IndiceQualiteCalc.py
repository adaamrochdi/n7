import operations as mod

def IndiceQualiteCalc(Temperature, Humidite) :
	return mod.operer_binaire_PRODUIT(mod.operer_binaire_SOUSTRACTION(Temperature, 20.0), mod.operer_binaire_SOUSTRACTION(1.0, mod.operer_binaire_DIVISION(Humidite, 100.0)))


