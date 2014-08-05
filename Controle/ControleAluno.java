package Controle;

import java.util.ArrayList;

import Entidades.Aluno;
import Exceções.AlunoInexistenteExcepiton;
import Exceções.AlunoJaExisteException;



public class ControleAluno {
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void cadastrarAluno(Aluno a) throws AlunoJaExisteException{
		boolean verifica = false;
		
		for(Aluno aluno: alunos){
			if(aluno.getMatricula().equalsIgnoreCase(a.getMatricula())){
				verifica = true;
				break;
			}
		}
		if(verifica == true ){
			throw new AlunoJaExisteException("Aluno já existente!");
		}
		alunos.add(a);
		
	}
	
	public void removerAluno(Aluno a) throws AlunoInexistenteExcepiton{
		boolean verifica = false;
		
		for(Aluno a1 : alunos){
			if(a1.getMatricula().equalsIgnoreCase(a.getMatricula())){
				verifica = true;
				
			}
		}
		if(verifica != true){
			throw new AlunoInexistenteExcepiton("Aluno Inexistente");
		}
		
		alunos.remove(a);
	}
	
	

	
	
	

}
