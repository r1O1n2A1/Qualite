package fr.afcepf.al30.qualimetrie;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al30.qualimetrie.data.DaoPromotion;
import fr.afcepf.al30.qualimetrie.data.IDaoPromotion;
import fr.afcepf.al30.qualimetrie.entite.Promotion;
import fr.afcepf.al30.qualimetrie.exception.CafEnum;
import fr.afcepf.al30.qualimetrie.exception.CafException;

/**
 * test des services acces a la base de donnees
 * pour la {@link Promotion}
 * @author ronan
 */
public class TestIDaoPromotion {
	/**
	 * logger pour nos erreurs
	 */
	private static Logger logger = Logger.getLogger(TestIDaoPromotion.class);
	/**
	 * service a tester
	 */
	private IDaoPromotion daoPromotion;
	/**
	 * cas nominal
	 */
	private Promotion promoNominal;
	/**
	 * cas nominal expected
	 */
	private Promotion promoNominalExpected;
	/**
	 * cas attribut null
	 */
	private Promotion promoAttNull;
	  /**
     * Pour le test att trop long.
     */
    private Promotion promoAttTropLong;
    /**
     * Exception attendue pour le test Echec att trop long.
     */
    private CafException exceptionTropLongExpected;
    /**
     * Date début Promotion.
     */
    private String dateDebut = "20/03/2017";
    /**
     * Date fin Promotion.
     */
    private String dateFin = "20/07/2017";
    /**
     * definition format date
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * IdExpected.
     */
    private static final int ID_EXPECTED = 7;
    
    @Before
    public void init() {
//    	String path = Thread.currentThread().getContextClassLoader()
//    			.getResource("./createBdd.sh").getPath();
//    	try {
//			Process proc = Runtime.getRuntime().exec(path);
//			proc.waitFor();
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
    	
    }
    
    /**
     * constructor // initialisation 
     */
    public TestIDaoPromotion() {
    	daoPromotion = new DaoPromotion();
    	  exceptionTropLongExpected = new CafException("",
                  CafEnum.DATA_INTEGRITE_DE_DONNEES);
          try {
              promoNominal = new Promotion(null,
                      "libelle Nominal", "code Nominal",
                      sdf.parse(dateDebut), sdf.parse(dateFin));
              promoNominalExpected =
                      new Promotion(ID_EXPECTED,
                      promoNominal.getLibelle(),
                      promoNominal.getCode(),
                      sdf.parse(dateDebut), sdf.parse(dateFin));
              promoAttNull =
                      new Promotion(null, null, "error Code",
                      sdf.parse(dateDebut), sdf.parse(dateFin));
              promoAttTropLong =
                  new Promotion(null,
                      "libelle error",
                      "code trop long pour entrer dans l'unite de persistence",
                      sdf.parse(dateDebut), sdf.parse(dateFin));
          } catch (ParseException e) {
              e.printStackTrace();
          }
    }
    
    /**
     * test cas nominal
     * @throws CafException
     */
    @Test
    public void testCasNominal() throws CafException {
    	Promotion retour = daoPromotion.ajouter(promoNominal);
    	Assert.assertNotNull(retour);
    	  Assert.assertNotNull(retour.getId());
          Assert.assertNotNull(retour.getLibelle());
          Assert.assertNotNull(retour.getCode());
          Assert.assertNotNull(retour.getDateDebut());
          Assert.assertNotNull(retour.getDateFin());
          Assert.assertEquals(promoNominalExpected.getId(),
                              retour.getId());
          Assert.assertEquals(promoNominalExpected.getCode(),
                              retour.getCode());
          Assert.assertEquals(promoNominalExpected.getLibelle(),
                              retour.getLibelle());
          Assert.assertEquals(promoNominalExpected.getDateDebut(),
                              retour.getDateDebut());
          Assert.assertEquals(promoNominalExpected.getDateFin(),
                              retour.getDateFin());    	
    }
    
    /**
     * test cas attribut null
     * @throws CafException
     */
    @Test(expected = CafException.class)
    public void testCasErreurAttNull() throws CafException {
    	daoPromotion.ajouter(promoAttNull);
    }

    /**
     * test cas erreur attribut trop longue
     */
    @Test
    public void testCasErreurTropLong() {
    	try {
    		daoPromotion.ajouter(promoAttTropLong);
    	} catch (CafException caf){
    		Assert.assertEquals(caf.getCodeErreur(), 
    				exceptionTropLongExpected.getCodeErreur());
    	}
    }
}

