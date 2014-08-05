package Exceções;

public class ProfessorJaExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorJaExistenteException(String nome){
		super(nome);
	}

}
