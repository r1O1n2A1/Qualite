package fr.afcepf.al30.qualimetrie;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.al30.qualimetrie.business.GestionRepas;
import fr.afcepf.al30.qualimetrie.business.IGestionRepas;
import fr.afcepf.al30.qualimetrie.data.DaoPromotion;
import fr.afcepf.al30.qualimetrie.data.IDaoPromotion;
import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.exception.CafEnum;
import fr.afcepf.al30.qualimetrie.exception.CafException;

public class TestIGestionRepasMock {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(TestIGestionRepasMock.class);
	private Promotion nominal;
	private Promotion expected;
	private Promotion error;
	private CafException exceptionExpected;
	private IDaoPromotion mock;
	private IGestionRepas business;
	/**
	 * Un truc qu'on factorise car on l'utilise 4 fois.
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Id expected.
	 */
	private static final int LAST_ID = 7;
	/**
	 * Date de debut pour les Promotions testees.
	 */
	private String dateDbt = "20/03/2017";
	/**
	 * Date de fin pour les Promotions testees.
	 */
	private String dateFin = "20/07/2017";
	/**
	 * constructeur // initalisation
	 */
	public TestIGestionRepasMock() {
		business = new GestionRepas();
		exceptionExpected = new CafException("",CafEnum.DATA_INTEGRITE_DE_DONNEES);
		try {
			nominal = new Promotion(null,
					"nominal", "30",
					sdf.parse(dateDbt), sdf.parse(dateFin));
			expected = new Promotion(LAST_ID,
					nominal.getLibelle(), nominal.getCode(),
					sdf.parse(dateDbt), sdf.parse(dateFin));
			error = new Promotion(LAST_ID,
					nominal.getLibelle(), null,
					sdf.parse(dateDbt), sdf.parse(dateFin));
			mock = new DaoPromotion() {
				@Override
				public Promotion ajouter(Promotion promo) throws CafException {
					if (promo.getCode() == null) {
						throw new CafException("", CafEnum.DATA_INTEGRITE_DE_DONNEES);
					} else {
						promo.setId(LAST_ID);
					}
					return promo;
				}

			};
//			((GestionRepas)business).setDaoPromotion(mock);
			Class<?> clazz = business.getClass();
			Field att = clazz.getDeclaredField("daoPromotion");
			att.setAccessible(true);
			att.set(business, mock);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


	}

	@Test
	public void testNominal() throws CafException {
		Promotion retour = business.ajouterPromotion(nominal);
		Assert.assertNotNull(retour);
		Assert.assertNotNull(retour.getId());
		Assert.assertNotNull(retour.getLibelle());
		Assert.assertNotNull(retour.getCode());
		Assert.assertNotNull(retour.getDateDebut());
		Assert.assertNotNull(retour.getDateFin());
		Assert.assertEquals(expected.getId(),
				retour.getId());
		Assert.assertEquals(expected.getCode(),
				retour.getCode());
		Assert.assertEquals(expected.getLibelle(),
				retour.getLibelle());
		Assert.assertEquals(expected.getDateDebut(),
				retour.getDateDebut());
		Assert.assertEquals(expected.getDateFin(),
				retour.getDateFin());
	}

	@Test 
	public void testError() {
		try {
			business.ajouterPromotion(error);
			Assert.fail("ne doit pas passer par la...");
		} catch (CafException e) {
			logger.error(e.getMessage());
			Assert.assertEquals(exceptionExpected.getCodeErreur(),
					e.getCodeErreur());
		}
	}
}
