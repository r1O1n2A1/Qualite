package fr.afcepf.al30.qualimetrie.business;

import fr.afcepf.al30.qualimetrie.data.DaoPromotion;
import fr.afcepf.al30.qualimetrie.data.DaoStagiaire;
import fr.afcepf.al30.qualimetrie.data.IDaoPromotion;
import fr.afcepf.al30.qualimetrie.data.IDaoStagiaire;
import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.entite.Stagiaire;
import fr.afcepf.al30.qualimetrie.exception.CafEnum;
import fr.afcepf.al30.qualimetrie.exception.CafException;

public class GestionRepas implements IGestionRepas {
	/**
	 * dao Promotion acces services de persistence couche data
	 */
	private IDaoPromotion daoPromotion = new DaoPromotion();
	/**
	 * dao Stagiaire acces services de persistence couche data
	 */
	private IDaoStagiaire daoStagiaire = new DaoStagiaire();

	public Promotion ajouterPromotion(Promotion promo) throws CafException {
		return daoPromotion.ajouter(promo);
	}

	public Stagiaire ajouterStagiaire(Stagiaire stagiaire) throws CafException {
		if (!daoStagiaire.existe(stagiaire.getEmail(),
				stagiaire.getNom())) {
			stagiaire = daoStagiaire.ajouter(stagiaire);
		} else {
			throw new CafException("existe",
					CafEnum.BUSINESS_STAGIAIRE_EXISTE);
		}
		return stagiaire;
	}

	public IDaoPromotion getDaoPromotion() {
		return daoPromotion;
	}

	/**
	 * setter , utile pour setter un mock
	 * @param daoPromotion
	 */
	public void setDaoPromotion(IDaoPromotion daoPromotion) {
		this.daoPromotion = daoPromotion;
	}

}
