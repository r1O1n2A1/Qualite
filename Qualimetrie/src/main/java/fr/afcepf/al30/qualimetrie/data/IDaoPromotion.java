package fr.afcepf.al30.qualimetrie.data;

import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * Services d'acces a la base de donnees pour 
 * la {@link Promotion}
 * @author ronan
 */
public interface IDaoPromotion {
	/**
	 * Service permettant l'ajout d'une promotion
	 * @param promo {@link Promotion}
	 * @return {@link Promotion}
	 * @throws CafException
	 * <ul>
	 * 		<li>attribut non null est null envoye a la bdd</li>
	 * 		<li>attribut depassant la capacite de l'unite de persistence</li>
	 * 		<li>l'unité de persistence ne repond pas, </li>
	 * </ul>
	 */
	Promotion ajouter(Promotion promo) throws CafException;
}
