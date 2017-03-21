package fr.afcepf.al30.qualimetrie.entite;

import java.util.Date;
import java.util.List;
/**
 * Entité representant une promotion de stagaire.
 * @author Stagiaire
 *
 */
public class Promotion {
    /**
     * identifiant de la promotion.
     */
    private Integer id;
    /**
     * intitule de la promotion.
     */
    private String libelle;
    /**
     * code le la promotion.
     */
    private String code;
    /**
     * date d'ouverture de la promotion.
     */
    private Date dateDebut;
    /**
     * date de fin de promotion.
     */
    private Date dateFin;
    /**
     * Les stagiaires de la promotion.
     */
    private List<Stagiaire> stagiaires;
    /**
     * Default Constructor.
     */
    public Promotion() {
    }
    /**
     * @param paramId new id.
     * @param paramLibelle new libelle.
     * @param paramCode new code.
     * @param paramDateDebut new debut.
     * @param paramDateFin new fin.
     */
    public Promotion(Integer paramId, String paramLibelle, String paramCode, Date paramDateDebut, Date paramDateFin) {
        super();
        id = paramId;
        libelle = paramLibelle;
        code = paramCode;
        dateDebut = paramDateDebut;
        dateFin = paramDateFin;
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
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param paramCode the code to set
     */
    public void setCode(String paramCode) {
        code = paramCode;
    }
    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }
    /**
     * @param paramDateDebut the dateDebut to set
     */
    public void setDateDebut(Date paramDateDebut) {
        dateDebut = paramDateDebut;
    }
    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }
    /**
     * @param paramDateFin the dateFin to set
     */
    public void setDateFin(Date paramDateFin) {
        dateFin = paramDateFin;
    }
    /**
     * @return the stagiaires
     */
    public List<Stagiaire> getStagiaires() {
        return stagiaires;
    }
    /**
     * @param paramStagiaires the stagiaires to set
     */
    public void setStagiaires(List<Stagiaire> paramStagiaires) {
        stagiaires = paramStagiaires;
    }
}
