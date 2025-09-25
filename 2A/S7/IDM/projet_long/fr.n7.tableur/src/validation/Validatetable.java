package validation;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import table.*;

import java.util.List;
import java.util.Map;

/**
 * Classe pour valider des fichiers XMI conformes au méta-modèle Table.
 * Elle utilise tableValidator pour effectuer la validation et affiche les erreurs détectées.
 */
public class Validatetable {

    /**
     * Affiche une liste d'erreurs avec un préfixe.
     * @param prefix préfixe pour identifier le groupe d'erreurs
     * @param errors liste d'erreurs à afficher
     */
    private static void afficherErreurs(String prefix, List<ValidationResult.ValidationError> errors) {
        System.out.print(prefix + ": ");
        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            System.out.println(errors.size() + " erreur(s) trouvée(s):");
            for (ValidationResult.ValidationError error : errors) {
                System.out.println("=> " + error);
            }
        }
    }

    /**
     * Affiche les erreurs pour chaque type d'entité du méta-modèle Table.
     * @param resultat résultat de la validation
     */
    private static void afficherResultat(ValidationResult resultat) {
        afficherErreurs("- Tables", resultat.getRecordedErrorsFor(TablePackage.Literals.TABLE));
        afficherErreurs("- Colonnes", resultat.getRecordedErrorsFor(TablePackage.Literals.COLONNE));
        afficherErreurs("- Contraintes", resultat.getRecordedErrorsFor(TablePackage.Literals.CONTRAINTE));
        afficherErreurs("- Scripts", resultat.getRecordedErrorsFor(TablePackage.Literals.SCRIPT));
        afficherErreurs("- TableSources", resultat.getRecordedErrorsFor(TablePackage.Literals.TABLE_SOURCE));
        afficherErreurs("- TableResultantes", resultat.getRecordedErrorsFor(TablePackage.Literals.TABLE_RESULTANTE));
    }

    /**
     * Point d'entrée principal pour exécuter la validation.
     * @param args chemins des fichiers XMI à valider
     */
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Veuillez spécifier au moins un fichier XMI à valider.");
            return;
        }

        // Charger le méta-modèle Table
        @SuppressWarnings("unused")
        TablePackage packageInstance = TablePackage.eINSTANCE;

        // Configuration du ResourceSet
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());
        ResourceSet resSet = new ResourceSetImpl();

        // Instancier le validateur
        tableValidator validator = new tableValidator();

        // Valider chaque fichier spécifié dans les arguments
        for (String filePath : args) {
            try {
                URI modelURI = URI.createFileURI(filePath);
                Resource resource = resSet.getResource(modelURI, true);
                ValidationResult resultat = validator.validate(resource);

                System.out.println("Résultat de validation pour le fichier : " + filePath);
                afficherResultat(resultat);
            } catch (Exception e) {
                System.err.println("Erreur lors de la validation du fichier " + filePath + " : " + e.getMessage());
            }
        }

        System.out.println("Validation terminée.");
    }
}