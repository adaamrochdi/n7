package validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import table.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe de validation pour le méta-modèle Table.
 * Contraintes vérifiées :
 * 1. Les noms des tables (Table principale, TableSource, TableResultante) doivent être valides et uniques.
 * 2. Les IDs des colonnes DOIVENT être ABSOLUMENT uniques dans tout le modèle.
 * 3. Les scripts ne peuvent pas avoir une colonne de type ColonneId ou colonneIdResultante comme entrée.
 * 4. Tous les éléments d'une même colonne doivent avoir le même type.
 */
public class tableValidator {

    private ValidationResult result = new ValidationResult();

    public tableValidator() {}

    public ValidationResult validate(Resource resource) {
        result = new ValidationResult();
        Set<String> allColumnIds = new HashSet<>();
        Set<String> allTableNames = new HashSet<>();

        for (EObject object : resource.getContents()) {
            if (object instanceof Table) {
                Table table = (Table) object;

                // Validation des noms de tables
                validateTableName(table, allTableNames);

                // Validation globale des IDs de colonnes pour toutes les sources
                for (TableSource source : table.getTablesource()) {
                    validateTableSourceName(source, allTableNames);
                    validateSourceColumnIds(source, allColumnIds);
                }

                // Validation globale des IDs de colonnes pour les tables résultantes
                for (TableResultante resultante : table.getTableresultante()) {
                    validateResultantTableName(resultante, allTableNames);
                    validateResultantColumnIds(resultante, allColumnIds);
                }

                // Validation des Scripts
                validateScripts(table);
            }
        }

        return result;
    }

    private void validateTableName(Table table, Set<String> allTableNames) {
        String tableName = table.getNom();
        if (tableName == null || !tableName.matches("^[A-Za-z_][A-Za-z0-9_]*$")) {
            result.recordError(table, "Le nom de la Table principale \"" + tableName + "\" n'est pas valide.");
        } else if (!allTableNames.add(tableName)) {
            result.recordError(table, "Le nom de la Table principale \"" + tableName + "\" est dupliqué.");
        }
    }

    private void validateTableSourceName(TableSource source, Set<String> allTableNames) {
        String sourceName = source.getNom();
        if (sourceName == null || !sourceName.matches("^[A-Za-z_][A-Za-z0-9_]*$")) {
            result.recordError(source, "Le nom de la TableSource \"" + sourceName + "\" n'est pas valide.");
        } else if (!allTableNames.add(sourceName)) {
            result.recordError(source, "Le nom de la TableSource \"" + sourceName + "\" est dupliqué.");
        }
    }

    private void validateResultantTableName(TableResultante resultante, Set<String> allTableNames) {
        String resultanteName = resultante.getNom();
        if (resultanteName == null || !resultanteName.matches("^[A-Za-z_][A-Za-z0-9_]*$")) {
            result.recordError(resultante, "Le nom de la TableResultante \"" + resultanteName + "\" n'est pas valide.");
        } else if (!allTableNames.add(resultanteName)) {
            result.recordError(resultante, "Le nom de la TableResultante \"" + resultanteName + "\" est dupliqué.");
        }
    }

    private void validateSourceColumnIds(TableSource source, Set<String> allColumnIds) {
        for (ColonneSaisie colonne : source.getColonnesaisie()) {
            // Vérification de l'ID de colonne
            String columnId = colonne.getId();
            if (columnId == null || columnId.isEmpty()) {
                result.recordError(colonne, "La colonne \"" + colonne.getNom() + "\" dans TableSource doit avoir un ID valide.");
            } else if (!allColumnIds.add(columnId)) {
                // Si l'ID existe déjà, enregistrer une erreur
                result.recordError(colonne, "L'ID de colonne \"" + columnId + "\" est dupliqué dans le modèle.");
            }

            // Vérification de l'homogénéité des types
            if (!colonne.getValeurs().isEmpty()) {
                Object firstValue = colonne.getValeurs().get(0);
                boolean sameType = colonne.getValeurs().stream()
                        .allMatch(value -> value.getClass().equals(firstValue.getClass()));
                if (!sameType) {
                    result.recordError(colonne, "Les éléments de la colonne \"" + colonne.getNom() + "\" n'ont pas le même type.");
                }
            }
        }
    }

    private void validateResultantColumnIds(TableResultante resultante, Set<String> allColumnIds) {
        for (ColonneSaisieRes colonne : resultante.getColonnesaisieres()) {
            // Vérification de l'ID de colonne
            String columnId = colonne.getId();
            if (columnId == null || columnId.isEmpty()) {
                result.recordError(colonne, "La colonne \"" + colonne.getNom() + "\" dans TableResultante doit avoir un ID valide.");
            } else if (!allColumnIds.add(columnId)) {
                // Si l'ID existe déjà, enregistrer une erreur
                result.recordError(colonne, "L'ID de colonne \"" + columnId + "\" est dupliqué dans le modèle.");
            }

            // Vérification de l'homogénéité des types
            if (!colonne.getValeurs().isEmpty()) {
                Object firstValue = colonne.getValeurs().get(0);
                boolean sameType = colonne.getValeurs().stream()
                        .allMatch(value -> value.getClass().equals(firstValue.getClass()));
                if (!sameType) {
                    result.recordError(colonne, "Les éléments de la colonne \"" + colonne.getNom() + "\" n'ont pas le même type.");
                }
            }
        }
    }

    private void validateScripts(Table table) {
        for (Script script : table.getScript()) {
            for (Colonne colonne : script.getEntree()) {
                if (colonne instanceof ColonneId || colonne instanceof colonneIdResultante) {
                    result.recordError(script, "Le script \"" + script.getNom() + "\" ne peut pas avoir une colonne de type ColonneId ou colonneIdResultante comme entrée.");
                }
            }
        }
    }
}