package fr.afcepf.al30.qualimetrie.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.exception.CafEnum;
import fr.afcepf.al30.qualimetrie.exception.CafException;

public class DaoPromotion implements IDaoPromotion {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(DaoPromotion.class);
	/**
	 * notre datasource
	 */
	private DataSource ds = new DSQualite();
	/* (non-Javadoc)
	 * @see fr.afcepf.al30.qualimetrie.data.IDaoPromotion#ajouter(fr.afcepf.al30.qualimetrie.entite.Promotion)
	 */
	private IDaoPromotion daoPromotion;	
	/**
	 * Requete pour ajouter une {@link Promotion}
	 */
	private static final String REQ_ADD = "INSERT INTO promotion "
			+ "(`intitule`,`code`, `date_debut`, `date_fin`) "
			+ "VALUES (?,?,?,?)";
	/**
     * Indice du parametre intitule de la requete reqAdd.
     */
    private static final int REQ_ADD_PARAM_INTITULE = 1;
    /**
     * Indice du parametre code de la requete reqAdd.
     */
    private static final int REQ_ADD_PARAM_CODE = 2;
    /**
     * Indice du parametre date_debut de la requete reqAdd.
     */
    private static final int REQ_ADD_PARAM_DEBUT = 3;
    /**
     * Indice du parametre date_fin de la requete reqAdd.
     */
    private static final int REQ_ADD_PARAM_FIN = 4;
    /**
     * indice de la clef genere
     */
    private static final int INDEX_CLEF_GENERE = 1;
	
	public Promotion ajouter(Promotion promo) throws CafException {
		Connection cnx = null;
		CafException erreur  = null;
		try {
			cnx = ds.getConnection();
			PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(REQ_ADD,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(REQ_ADD_PARAM_INTITULE, promo.getLibelle());
			ps.setString(REQ_ADD_PARAM_CODE, promo.getCode());
			ps.setDate(REQ_ADD_PARAM_DEBUT, new Date(promo.getDateDebut().getTime()));
			ps.setDate(REQ_ADD_PARAM_FIN, new Date(promo.getDateFin().getTime()));
			ps.executeUpdate();
			ResultSet key = ps.getGeneratedKeys();
			key.next();
			promo.setId(key.getInt(INDEX_CLEF_GENERE));
		} catch (Exception e) {
			logger.error(e.getMessage());
			erreur = new CafException(e.getMessage(), 
					CafEnum.DATA_INTEGRITE_DE_DONNEES);
		} finally {
			if (cnx != null) {
				try {
					cnx.close();
				} catch (Exception e) {
					erreur = new CafException("", CafEnum.DATA_MYSQL_HS);
				}
			}
		}
		if (erreur != null) {
			throw erreur;
		}
		return promo;
	}

}
