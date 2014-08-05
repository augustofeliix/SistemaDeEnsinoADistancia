package Exceções;

public class ProfessorInexistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorInexistenteException(String nome){
		super(nome);
	}

}
