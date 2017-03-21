package fr.afcepf.al30.qualimetrie.data;

import fr.afcepf.al30.qualimetrie.entite.Stagiaire;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * Definition des services de persistence pour le {@link Stagiaire}.
 * @author Stagiaire
 *
 */
public interface IDaoStagiaire {
    /**
     * Ajout d'un stagiaire dans l'unité de persistence.
     * @param satgiaire le {@link Stagiaire}.
     * @return le nouveau {@link Stagiaire}.
     * @throws CafException
     * <ul>
     *  <li>Contraintes d'intégrités.</li>
     *  <li>Serveur de persistence HS</li>
     * </ul>
     */
    Stagiaire ajouter(Stagiaire satgiaire) throws CafException;
   /**
    * recherche l'existence d'un {@link Stagiaire}
    * avec un mail et un nom.
    * @param mail le mail cherché.
    * @param nom le nom cherché.
    * @return
    * <ul>
    *   <li>true si il est present</li>
    *   <li>false si il n'est pas present</li>
    * </ul>
    * @throws CafException
    * <ul>
    *   <li>Serveur de persistence HS</li>
    * </ul>
    */
    boolean existe(String mail, String nom) throws CafException;
}