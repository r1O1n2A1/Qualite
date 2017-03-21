package fr.afcepf.al30.qualimetrie.business;

import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.entite.Stagiaire;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * Services metiers concernant la gestion des {@link Promotion},
 * de l'occupation de la salle de cafette.
 * @author Stagiaire
 *
 */
public interface IGestionRepas {
    /**
     * Service permettant l'ajout d'une {@link Promotion} dans
     * le S.I.
     * @param promo la {@link Promotion}.
     * @return la nouvelle {@link Promotion}.
     * @throws CafException
     * <ul>
     *  <li>Si la couche data leve une exception.</li>
     *  <li>erreur de Math.Max().</li>
     * </ul>
     */
    Promotion ajouterPromotion(Promotion promo)
            throws CafException;
    /**
     * Service permettant l'ajout d'un {@link Stagiaire}
     * dans le S.I.
     * @param stagiaire le stagiaire a ajouter.
     * @return le nouveau {@link Stagiaire}.
     * @throws CafException
     * <ul>
     *  <li>un stagiaire avec meme nom ET mail existe deja.</li>
     *  <li>la couche data leve une exception.</li>
     *  <li>Maxception.</li>
     * </ul>
     */
    Stagiaire ajouterStagiaire(Stagiaire stagiaire)
            throws CafException;
}
