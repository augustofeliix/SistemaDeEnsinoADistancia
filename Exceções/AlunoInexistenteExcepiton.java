package Exceções;

public class AlunoInexistenteExcepiton extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoInexistenteExcepiton(String nome){
		super(nome);
	}

}
