import operations as mod

def ScoreConfortCalc(Temperature, Humidite) :
	return mod.operer_binaire_SOMME(mod.operer_binaire_PRODUIT(Temperature, 0.3), mod.operer_binaire_PRODUIT(mod.operer_binaire_SOUSTRACTION(50.0, Humidite), 0.1))


