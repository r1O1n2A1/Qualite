package fr.afcepf.al30.qualimetrie.data;

import fr.afcepf.al30.qualimetrie.entite.Stagiaire;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * Implementation des services de persistence pour le {@link Stagiaire}.
 * @author Stagiaire
 *
 */
public class DaoStagiaire implements IDaoStagiaire {

    public Stagiaire ajouter(Stagiaire paramSatgiaire) throws CafException {
        return null;
    }

    public boolean existe(String paramMail, String paramNom) throws CafException {
        return false;
    }
}