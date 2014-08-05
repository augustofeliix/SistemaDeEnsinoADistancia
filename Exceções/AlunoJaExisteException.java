package Exceções;

public class AlunoJaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoJaExisteException(String nome){
		super(nome);
	}

}
