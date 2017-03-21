package fr.afcepf.al30.qualimetrie.exception;

/**
 * Exception personnalise pour notre application
 * de gestion de cafeteria
 * @author ronan
 *
 */
public class CafException extends Exception {
	
	/**
	 * serialisation (contexte RMI, ou externalisation
	 * de l'objet serialise)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * message personnalise
	 */
	private String message;
	
	/**
	 * code erreur de l'exception
	 */
	private CafEnum codeErreur;
	/**
     * Default constructor.
     */
    public CafException() {
    }
    /**
     * @param paramMessage message de l'exception.
     */
    public CafException(String paramMessage) {
        super(paramMessage);
    }
    /**
     * @param paramMessage message de l'exception.
     * @param paramCodeErreur code d'erreur de l'exception.
     */
    public CafException(String paramMessage, CafEnum paramCodeErreur) {
        super(paramMessage);
        codeErreur = paramCodeErreur;
    }
    /**
     * @return the codeErreur
     */
    public CafEnum getCodeErreur() {
        return codeErreur;
    }
    /**
     * @param paramCodeErreur the codeErreur to set
     */
    public void setCodeErreur(CafEnum paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }
}
