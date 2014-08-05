package Fachada;

import java.util.ArrayList;

import Controle.ControleAluno;
import Controle.ControleProfessor;
import Entidades.Aluno;
import Entidades.Professor;
import Exceções.AlunoInexistenteExcepiton;
import Exceções.AlunoJaExisteException;
import Exceções.ProfessorInexistenteException;
import Exceções.ProfessorJaExistenteException;

public class SistemaDeEnsinoFachada {

	ControleAluno ca = new ControleAluno();
	ControleProfessor cp = new ControleProfessor();

	public ArrayList<Aluno> getAlunos() {
		return ca.getAlunos();
	}

	public void cadastrarAluno(Aluno a) throws AlunoJaExisteException {
		ca.cadastrarAluno(a);
	}

	public void removerAluno(Aluno a) throws AlunoInexistenteExcepiton {
		ca.removerAluno(a);
	}

	public ArrayList<Professor> getProfessores() {
		return cp.getProfessores();
	}

	public void cadastrarProfessor(Professor p)
			throws ProfessorJaExistenteException {
		cp.cadastrarProfessor(p);
	}

	public void removerProfessor(Professor p)
			throws ProfessorInexistenteException {
		cp.removerProfessor(p);
	}

	public Professor buscarProfessor(String cpf)
			throws ProfessorInexistenteException {
		return cp.buscarProfessor(cpf);
	}

}
