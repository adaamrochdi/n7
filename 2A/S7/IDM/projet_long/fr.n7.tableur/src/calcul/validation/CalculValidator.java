package calcul.validation;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import calcul.*;
import calcul.util.CalculSwitch;

/**
 * Réalise la validation d'un EObject issu de SimplePDL (en théorie, d'un process).
 * Cet classe visite le modèle et utilise les caseXXX pour rediriger l'algo vers la
 * bonne méthode.
 * Attention, lorsqu'une classe est un parent il faut aller faire la visite des enfants
 * manuellement (cf. caseProcess typiquement).
 * 
 * La classe Switch exige un paramètre de généricité (et gère une partie de la visite à
 * base de comparaison à null). Ici le paramètre est un booléen mais en réalité on ne
 * s'en sert pas...
 * 
 * @author Guillaume Dupont
 * @version 0.1
 */
public class CalculValidator extends CalculSwitch<Boolean> {
	/**
	 * Expression régulière qui correspond à un identifiant bien formé.
	 */
	private static final String IDENT_REGEX = "^[A-Za-z_][A-Za-z0-9_]*$";
	
	
	/**
	 * Résultat de la validation (état interne réinitialisé à chaque nouvelle validation).
	 */
	private ValidationResult result = null;
	
	/**
	 * Construire un validateur
	 */
	public CalculValidator() {}
	
	/**
	 * Lancer la validation et compiler les résultats dans un ValidationResult.
	 * Cette méthode se charge de créer un résultat de validation vide puis de
	 * visiter les process présents dans la ressource.
	 * @param resource resource à valider
	 * @return résultat de validation
	 */
	public ValidationResult validate(Resource resource) {
		this.result = new ValidationResult();
		
		for (EObject object : resource.getContents()) {
			this.doSwitch(object);
		}
		
		return this.result;
	}


	/**
	 * Méthode appelée lorsque l'objet visité est un Process.
	 * Cet méthode amorce aussi la visite des éléments enfants.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseCalcul(calcul.Calcul object) {
		// Contraintes sur process
		try {
		this.result.recordIfFailed(
				object.getName() != null && object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom du calcul ne respecte pas les conventions Java");
		} catch (Exception e) {
			
		}
		
		// Visite des opérateurs du calcul
		for (Operateur pe : object.getOperateur()) {
			this.doSwitch(pe);
		}
		
		return null;
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est un Opérateur.
	 * Cet méthode amorce aussi la visite des éléments enfants.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseOperateur(calcul.Operateur object) {
		// Contraintes sur Operateur
		try {
		this.result.recordIfFailed(
				object.getName() != null && object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom de l'opérateur ne respecte pas les conventions Java");
		} catch (Exception e) {
			
		}
		
		// Le nombre d'entrées correspond à l'ordre pour cette opérateur
		
		this.result.recordIfFailed(
				((int) object.getEntreePrincipale().stream().count()) == 
				object.getEntreePrincipale().stream().mapToInt(m -> m.getOrdre()).max().getAsInt(),
				object,
				"Les entrées de l'opérateur ont un ordre incohérent");
		
		// Plusieurs fois la même
		
		this.result.recordIfFailed(
				object.getEntreePrincipale().stream().mapToInt(m -> m.getOrdre()).distinct().count() == 
				object.getEntreePrincipale().stream().mapToInt(m -> m.getOrdre()).max().getAsInt(),
				object,
				"Plusieurs entrées ont le même ordre");
		
		// Visite des entrées et sortie
		for (Entree ent : object.getEntreePrincipale()) {
			this.doSwitch(ent);
		}
		this.doSwitch(object.getSortie());
		
		
		return null;
	}

	/**
	 * Méthode appelée lorsque l'objet visité est un Operateur Binaire.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseOperateurBinaire(OperateurBinaire object) {
		
		// L'opérateur ne possède que deux entrées
		this.result.recordIfFailed(
		object.getEntreePrincipale().size() == 2,
		object,
		"L'opérateur binaire ne possède pas deux entrées");
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getEntreePrincipale().stream().allMatch(ent -> ent.getType().equals(object.getOperandetype())),
		object,
		"L'opérateur binaire ne possède pas deux entrées");
		return null;
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est un Operateur Unaire.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseOperateurUnaire(OperateurUnaire object) {
		
		// L'opérateur ne possède qu'une entrée
		this.result.recordIfFailed(
		object.getEntreePrincipale().size() == 1,
		object,
		"L'opérateur binaire ne possède pas deux entrées");
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getEntreePrincipale().stream().allMatch(ent -> ent.getType().equals(object.getOperandetype())),
		object,
		"L'opérateur binaire ne possède pas deux entrées");
		return null;
	}

	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntree(Entree object) {
		// Contraintes sur Entrée
		
		return null;
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Constante.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntreeConstanteBool(EntreeConstanteBool object) {
		// Contraintes sur EntréeConstante
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getType().equals(TypeElement.BOOL),
		object,
		"L'opérateur binaire ne possède pas deux entrées");
		
		return null;
		
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Constante Flottante.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntreeConstanteFloat(EntreeConstanteFloat object) {
		// Contraintes sur EntréeConstante
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getType().equals(TypeElement.FLOAT),
		object,
		"Le type est correcte");
		
		return null;
		
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Constante String.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntreeConstanteString(EntreeConstanteString object) {
		// Contraintes sur EntréeConstante
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getType().equals(TypeElement.STRING),
		object,
		"Le type est correcte");
		
		return null;
		
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Constante String.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntreeOperateur(EntreeOperateur object) {
		// Contraintes sur EntréeOpérateur
		
		// La sortie opérateur est unique à cette entrée
		this.result.recordIfFailed(
		object.getPrecedent().getSuivant().equals(object),
		object,
		"Le type est correcte");
		
		return null;
		
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Operateur.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseSortieOperateur(SortieOperateur object) {
		// Contraintes sur SortieOpérateur
		
		// La sortie opérateur est unique à cette entrée
		this.result.recordIfFailed(
		object.getSuivant().getPrecedent().equals(object),
		object,
		"La sortie opérateur n'est pas lié à la bonne entrée");
		
		return null;
		
	}
	
	
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Entrée Constante Entière.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseEntreeConstanteInt(EntreeConstanteInt object) {
		// Contraintes sur EntréeConstante
		
		// Le typage est correcte
		this.result.recordIfFailed(
		object.getType().equals(TypeElement.INT),
		object,
		"Le type est correcte");
		
		return null;
		
	}

	/**
	 * Méthode appelée lorsque l'objet visité est une Sortie.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean caseSortie(Sortie object) {
		// Contraintes sur Sorties
		
		return null;
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Sortie.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean casePortSortie(PortSortie object) {
		// Contraintes sur Sorties de type Port
		try {
		this.result.recordIfFailed(
				object.getName() != null && object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom du port ne respecte pas les conventions Java");
		} catch (Exception e) {
		
		}
		
		return null;
	}
	
	/**
	 * Méthode appelée lorsque l'objet visité est une Sortie.
	 * @param object élément visité
	 * @return résultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas échéant)
	 */
	@Override
	public Boolean casePortEntree(PortEntree object) {
		// Contraintes sur Sorties de type Port
		try {
		this.result.recordIfFailed(
				object.getName() != null && object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom du port ne respecte pas les conventions Java");
		} catch (Exception e) {
		
		}
		
		
		return null;
	}


	/**
	 * Cas par défaut, lorsque l'objet visité ne correspond pas à un des autres cas.
	 * Cette méthode est aussi appelée lorsqu'une méthode renvoie null (comme une sorte de
	 * fallback).
	 * On pourrait implémenter le switch différemment, en ne renvoyant null dans les autres
	 * méthodes que si la contrainte ne sert à rien, et se servir de cette méthode pour
	 * identifier les éléments étrangers (qui de toute façon ne doivent pas exister).
	 * C'est aussi la méthode appelée si on ne redéfini pas un des caseXXX.
	 * @param object objet visité
	 * @return résultat, null ici
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		return null;
	}
	
	
}
