package fr.afcepf.al30.qualimetrie.exception;

/**
 * Definition des codes erreurs de l'application
 * pour les Exceptions
 * @author ronan
 */
public enum CafEnum {
	  /**
     * au cas ou je ne suis pas sur en tant que dév.
     */
    CA_MARCHE_PAS,
    /**
     * exception business pour l'existance d'un Stagiaire.
     */
    BUSINESS_STAGIAIRE_EXISTE,
    /**
     * exception business si pas de possibilité de manger
     * cette semaine.
     */
    BUSINESS_AUCUNE_PLAGE_DISPO,
    /**
     * cas dao ou le serveur de données ne reponds pas.
     */
    DATA_MYSQL_HS,
    /**
     * pour les contraintes nullable, taille dans la BDD.
     */
    DATA_INTEGRITE_DE_DONNEES
}
