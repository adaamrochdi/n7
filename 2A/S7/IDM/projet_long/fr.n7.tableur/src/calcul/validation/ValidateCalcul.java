package calcul.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import calcul.CalculPackage;
import calcul.validation.ValidationResult.ValidationError;

/**
 * Réalise la validation de modèles conformes à SimplePDL à l'aide du validateur et
 * affiche le résultat.
 * 
 * Les modèles sont donnés dans les arguments de la ligne de commande, et le résultat
 * est affiché dans le terminal.
 * 
 * @author Guillaume Dupont
 * @version 0.1
 */
public class ValidateCalcul {
	
	/**
	 * Afficher une lsite d'erreur avec un préfixe.
	 * Le préfixe est affiché avec juste "OK" à la suite si la liste est vide, et sinon
	 * la liste est affiché avec une erreur par ligne, la source de l'erreur et le message
	 * associé.
	 * @param prefix préfixe à afficher avant la liste (potentielle) d'erreurs
	 * @param errors erreurs à afficher
	 */
	private static void afficherErreurs(String prefix, List<ValidationResult.ValidationError> errors) {
		System.out.print(prefix + ":");
		if (errors.isEmpty()) {
			System.out.println(" OK");
		} else {
			System.out.println(" " + errors.size() + " erreurs trouvées");
			for (ValidationResult.ValidationError error : errors) {
				System.out.println("=> " + error.toString());
			}
		}
	}
	
	public static void afficherErreursListe(String prefix, Map<String,List<ValidationResult.ValidationError>> errorsList) {
        System.out.println(prefix + ":");
        if (errorsList.isEmpty()) {
        } else {
            for (Entry<String, List<ValidationError>> errors : errorsList.entrySet()) {
                System.out.print("	- " + errors.getKey() + " : ");
                if (errors.getValue().isEmpty()) {
                    System.out.println("OK");
                } else {
                    System.out.println(errors.getValue().size() + " erreurs trouvées");
                    for (ValidationResult.ValidationError error : errors.getValue()) {
                        System.out.println("=> " + error.toString());
                    }
                }
            }
        }
    }
	
	/**
	 * Affiche les erreurs pour les divers éléments du méta-modèle : process, activités,
	 * dépendances, commentaires.
	 * @param resultat résultat de la validation calculé auparavant
	 */
	private static void afficherResultat(ValidationResult resultat) {
		
		Map<String,List<ValidationResult.ValidationError>> errorsentreeList = new HashMap<String, List<ValidationError>>();
		errorsentreeList.put("EntréeConstanteInt",resultat.getRecordedErrorsFor(CalculPackage.ENTREE_CONSTANTE_INT));
		errorsentreeList.put("EntréeConstanteFloat",resultat.getRecordedErrorsFor(CalculPackage.ENTREE_CONSTANTE_FLOAT));
		errorsentreeList.put("EntréeConstanteBool",resultat.getRecordedErrorsFor(CalculPackage.ENTREE_CONSTANTE_BOOL));
		errorsentreeList.put("EntréeConstanteString",resultat.getRecordedErrorsFor(CalculPackage.ENTREE_CONSTANTE_STRING));
		errorsentreeList.put("EntréeOpérateur",resultat.getRecordedErrorsFor(CalculPackage.ENTREE_OPERATEUR));
		errorsentreeList.put("PortEntrée",resultat.getRecordedErrorsFor(CalculPackage.PORT_ENTREE));
		
		Map<String,List<ValidationResult.ValidationError>> errorssortieList = new HashMap<String, List<ValidationError>>();
		errorssortieList.put("SortieOpérateur",resultat.getRecordedErrorsFor(CalculPackage.SORTIE_OPERATEUR));
		errorssortieList.put("PortSortie",resultat.getRecordedErrorsFor(CalculPackage.PORT_SORTIE));
		
		Map<String,List<ValidationResult.ValidationError>> errorsoperateurList = new HashMap<String, List<ValidationError>>();
		errorsoperateurList.put("OpérateurBinaire",resultat.getRecordedErrorsFor(CalculPackage.OPERATEUR_BINAIRE));
		errorsoperateurList.put("OpérateurUnaire",resultat.getRecordedErrorsFor(CalculPackage.OPERATEUR_UNAIRE));
		

		afficherErreurs("=> Calcul", resultat.getRecordedErrorsFor(CalculPackage.CALCUL));
		afficherErreurs("=> Entrées", resultat.getRecordedErrorsFor(CalculPackage.ENTREE));
		afficherErreurs("=> Sorties", resultat.getRecordedErrorsFor(CalculPackage.SORTIE));
		afficherErreurs("=> Opérateurs", resultat.getRecordedErrorsFor(CalculPackage.OPERATEUR));
		afficherErreursListe("=> Entrée fils", errorsentreeList);
		afficherErreursListe("=> Sortie fils", errorssortieList);
		afficherErreursListe("=> Opérateur fils", errorsoperateurList);
	}

	/**
	 * Fonction principale. Charge le méta-modèle et les modèles passés en paramètre sur
	 * la ligne de commande, lance la validation pour chaque modèle et affiche le résultat.
	 * @param args arguments de la ligne de commande
	 */
	public static void main(String... args) {
		// On a besoin de récupérer l'eINSTANCE pour qu'elle soit correctement instanciée.
		// C'est cette étape qui "charge le méta-modèle".
		// Bien sûr, on n'utilise pas directement packageInstance, d'où le warning "unused" qui
		// est supprimé avec l'annotation.
		@SuppressWarnings("unused")
		CalculPackage packageInstance = CalculPackage.eINSTANCE;
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		
		CalculValidator validator = new CalculValidator();

		for (String model : args) {
			URI modelURI = URI.createURI(model);
			Resource resource = resSet.getResource(modelURI, true);
			ValidationResult resultat = validator.validate(resource);
			
			System.out.println("Résultat de validation pour " + model + ":");
			afficherResultat(resultat);
		}
		
		System.out.println("Fini.");
	
	}

}
