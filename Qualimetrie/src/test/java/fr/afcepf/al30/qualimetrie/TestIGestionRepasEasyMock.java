package fr.afcepf.al30.qualimetrie;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.al30.qualimetrie.business.GestionRepas;
import fr.afcepf.al30.qualimetrie.business.IGestionRepas;
import fr.afcepf.al30.qualimetrie.data.IDaoStagiaire;
import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.entite.Stagiaire;
import fr.afcepf.al30.qualimetrie.exception.CafEnum;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * Test service metiers pour la gestion des repas avec {@link EasyMock}
 * @author ronan
 *
 */
public class TestIGestionRepasEasyMock {
	private static Logger logger = Logger.getLogger(TestIGestionRepasEasyMock.class);
	private static Stagiaire nominal;
	private static Stagiaire expected;
	private static Stagiaire nomNull;
	private static CafException exceptionNullDb;
	private static Stagiaire existe;
	private static CafException exceptionExiste;
	private static String mailExiste = "stagiaire15@afcepf.fr";
	private static String nomExiste = "stagiaire 15";
	private static String nomExistePas = "Max";
	private static Promotion promo;
	private static IDaoStagiaire mock;
	private static IGestionRepas business = new GestionRepas();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static String dateDbt = "20/03/2017";
	private static String dateFin = "20/07/2017";
	private static final int LAST_ID = 16;

	@BeforeClass
	public static void faitAvantTousLesTests() throws CafException {
		try {
			//initialisation
			promo = new Promotion(1,
					"libelle",
					"code",
					sdf.parse(dateDbt),
					sdf.parse(dateFin));
			nominal = new Stagiaire(null,
					nomExistePas,
					mailExiste,
					true,
					promo);
			expected = new Stagiaire(LAST_ID, 
					nominal.getNom(),
					nominal.getEmail(),
					false,
					promo);
			nomNull = new Stagiaire(null, 
					null,
					mailExiste,
					false,
					promo);
			existe = new Stagiaire(null,
					nomExiste,
					mailExiste,
					false,
					promo);
			exceptionExiste = new CafException("existe",CafEnum.BUSINESS_STAGIAIRE_EXISTE);
			exceptionNullDb = new CafException("",CafEnum.DATA_INTEGRITE_DE_DONNEES);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		mock = EasyMock.createMock(IDaoStagiaire.class);
		EasyMock.expect(mock.existe(mailExiste, nomExistePas))
		.andReturn(false);
		EasyMock.expect(mock.existe(mailExiste, nomExiste))
		.andReturn(true);
		EasyMock.expect(mock.existe(mailExiste, null))
		.andReturn(false);
		EasyMock.expect(mock.ajouter(nominal))
		.andReturn(expected);
		EasyMock.expect(mock.ajouter(nomNull))
		.andThrow(exceptionNullDb);
		EasyMock.replay(mock);

		// reflection pour definir le mock dans le business
		Class<?> clazz = business.getClass();
		Field att;
		try {
			att = clazz.getDeclaredField("daoStagiaire");
			att.setAccessible(true);
			att.set(business, mock);
		} catch (NoSuchFieldException e) {
			logger.error(e.getMessage());
		} catch (SecurityException e) {
			logger.error(e.getMessage());;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());;
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());;
		}

	}

	@AfterClass
	public static void apresTousLesTests() {
		EasyMock.verify(mock);
	}

	@Test
	public void testNominal() throws CafException {
		Stagiaire retour = business.ajouterStagiaire(nominal);
		Assert.assertNotNull(retour);
		Assert.assertEquals(expected.getNom(), retour.getNom());
		Assert.assertEquals(expected.getPromo(), retour.getPromo());
	}
	
	@Test (expected = CafException.class)
	public void testExiste() throws CafException {
		Stagiaire retour = business.ajouterStagiaire(existe); 
	}

	@Test
	public void testErreur() {
		try {
			business.ajouterStagiaire(nomNull);
			Assert.fail("ne passe pas par la...");
		} catch (CafException excep) {
			Assert.assertEquals(excep.getCodeErreur(),
					exceptionNullDb.getCodeErreur());
		}
	}

}
