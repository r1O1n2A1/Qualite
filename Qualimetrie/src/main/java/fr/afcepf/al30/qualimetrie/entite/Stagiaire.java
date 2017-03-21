package fr.afcepf.al30.qualimetrie.entite;

/**
 * Entité representant un Stagiaire dans une promotion.
 * @author Stagiaire
 *
 */
public class Stagiaire {
    /**
     * Identifiant du {@link Stagiaire}.
     */
    private Integer id;
    /**
     * nom du {@link Stagiaire}.
     */
    private String nom;
    /**
     * Adresse mail du {@link Stagiaire}.
     */
    private String email;
    /**
     * Mange-t-il du gluten, mais osef!.
     */
    private boolean glutenophobe;
    /**
     * La {@link Promotion} du {@link Stagiaire}.
     */
    private Promotion promo;
    /**
     * Default Constructor.
     */
    public Stagiaire() {
    }
    /**
     * @param paramId the id to set
     * @param paramNom the nom to set
     * @param paramEmail the email to set
     * @param paramGlutenophobe the gluten to set
     * @param paramPromo the promo to set
     */
    public Stagiaire(Integer paramId, String paramNom,
                     String paramEmail, boolean paramGlutenophobe,
                     Promotion paramPromo) {
        super();
        id = paramId;
        nom = paramNom;
        email = paramEmail;
        glutenophobe = paramGlutenophobe;
        promo = paramPromo;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param paramEmail the email to set
     */
    public void setEmail(String paramEmail) {
        email = paramEmail;
    }
    /**
     * @return the glutenophobe
     */
    public boolean isGlutenophobe() {
        return glutenophobe;
    }
    /**
     * @param paramGlutenophobe the glutenophobe to set
     */
    public void setGlutenophobe(boolean paramGlutenophobe) {
        glutenophobe = paramGlutenophobe;
    }
    /**
     * @return the promo
     */
    public Promotion getPromo() {
        return promo;
    }
    /**
     * @param paramPromo the promo to set
     */
    public void setPromo(Promotion paramPromo) {
        promo = paramPromo;
    }
}
