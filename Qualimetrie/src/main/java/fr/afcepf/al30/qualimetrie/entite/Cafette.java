package fr.afcepf.al30.qualimetrie.entite;


/**
 * Entité qui represente la cafeteria
 * ou les stagiaires mangent en toute
 * COURTOISIE.
 * @author Stagiaire
 *
 */
public class Cafette {
    /**
     * Identifiant de la cafette.
     */
    private Integer id;
    /**
     * nom de la salle contenant la cafette.
     */
    private String nom;
    /**
     * nombre de place.
     */
    private int nbPlace;
    /**
     * Default Constructor.
     */
    public Cafette() {
        super();
    }
    /**
     * @param paramId new id.
     * @param paramNom new nom.
     * @param paramNbPlace new nbPlace.
     */
    public Cafette(Integer paramId, String paramNom, int paramNbPlace) {
        super();
        id = paramId;
        nom = paramNom;
        nbPlace = paramNbPlace;
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
     * @return the nbPlace
     */
    public int getNbPlace() {
        return nbPlace;
    }
    /**
     * @param paramNbPlace the nbPlace to set
     */
    public void setNbPlace(int paramNbPlace) {
        nbPlace = paramNbPlace;
    }
}
