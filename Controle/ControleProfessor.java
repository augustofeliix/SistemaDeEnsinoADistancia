package Controle;

import java.util.ArrayList;

import Entidades.Professor;
import Exceções.ProfessorInexistenteException;
import Exceções.ProfessorJaExistenteException;

public class ControleProfessor {
	
	private ArrayList<Professor> professores = new ArrayList<Professor>();

	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	
	public void cadastrarProfessor(Professor p) throws ProfessorJaExistenteException{
		boolean verifica = false;
		for(Professor p1 : professores){
			if(p1.getCpf().equalsIgnoreCase(p.getCpf())){
				verifica = true;
			}
		}
		
		if(verifica == true){
			throw new ProfessorJaExistenteException("Professor já existente!");
		}
		professores.add(p);
		
	}
	
	public void removerProfessor(Professor p) throws ProfessorInexistenteException{
		boolean verifica = false;
		for(Professor p1 : professores){
			if(p1.getCpf().equalsIgnoreCase(p.getCpf())){
				verifica = true;
			}
		}
		
		if(verifica != true){
			throw new ProfessorInexistenteException("Professor Inexistente");
		}
		professores.remove(p);
	}
	
	public Professor buscarProfessor(String cpf) throws ProfessorInexistenteException{
		for(Professor p : professores){
			if(p.getCpf().equalsIgnoreCase(cpf)){
				return p;
			}
		}
		throw new ProfessorInexistenteException("Professor Inexistente");
		
	
	}


	
	
	
	

}
