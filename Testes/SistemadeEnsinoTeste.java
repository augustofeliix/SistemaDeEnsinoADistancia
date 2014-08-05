package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Entidades.Aluno;
import Entidades.Professor;
import Exceções.AlunoInexistenteExcepiton;
import Exceções.AlunoJaExisteException;
import Exceções.ProfessorInexistenteException;
import Exceções.ProfessorJaExistenteException;
import Fachada.SistemaDeEnsinoFachada;

public class SistemadeEnsinoTeste {

	SistemaDeEnsinoFachada fachada;

	@Before
	public void setUp() throws Exception {
		fachada = new SistemaDeEnsinoFachada();
	}

	@Test
	public void testCadastrarAluno() throws AlunoJaExisteException {
		Aluno aluno1 = criarAlunoPadrao();
		fachada.cadastrarAluno(aluno1);
		Aluno aluno2 = criarAlunoMinimo();
		fachada.cadastrarAluno(aluno2);
		ArrayList<Aluno> alunos = fachada.getAlunos();
		assertEquals(2, alunos.size());
		assertEquals(aluno1, alunos.get(0));
		assertEquals(aluno2, alunos.get(1));
	}

	@Test
	public void testRemoverAluno() throws AlunoJaExisteException,
			AlunoInexistenteExcepiton {
		Aluno aluno1 = criarAlunoPadrao();
		fachada.cadastrarAluno(aluno1);
		Aluno aluno2 = criarAlunoMinimo();
		fachada.cadastrarAluno(aluno2);
		fachada.removerAluno(aluno1);
		assertFalse(fachada.getAlunos().contains(aluno1));

	}

	@Test
	public void testCadastrarProfessor() throws ProfessorJaExistenteException {
		Professor professor1 = criarProfessorMinimo();
		fachada.cadastrarProfessor(professor1);
		Professor professor2 = criarProfessorPadrao();
		fachada.cadastrarProfessor(professor2);
		ArrayList<Professor> professores = fachada.getProfessores();
		assertEquals(2, professores.size());
		assertEquals(professor1, professores.get(0));
		assertEquals(professor2, professores.get(1));

	}

	@Test
	public void testRemoverProfessor() throws ProfessorInexistenteException,
			ProfessorJaExistenteException {
		Professor p1 = criarProfessorPadrao();
		fachada.cadastrarProfessor(p1);
		Professor p2 = criarProfessorMinimo();
		fachada.cadastrarProfessor(p2);
		fachada.removerProfessor(p1);
		fachada.removerProfessor(p2);
		assertFalse(fachada.getAlunos().contains(p1));
		assertFalse(fachada.getAlunos().contains(p2));
	}

	@Test
	public void testBuscarProfessor() throws ProfessorJaExistenteException,
			ProfessorInexistenteException {
		Professor p1 = criarProfessorPadrao();
		fachada.cadastrarProfessor(p1);
		Professor p2 = criarProfessorMinimo();
		fachada.cadastrarProfessor(p2);
		fachada.buscarProfessor(p1.getCpf());
		fachada.buscarProfessor(p2.getCpf());
		assertEquals(p1, fachada.buscarProfessor("741852"));
		assertEquals(p2, fachada.buscarProfessor("123456"));

	}

	// Metodos necessários

	private Aluno criarAlunoMinimo() {
		Aluno a = new Aluno();
		a.setNome("Augusto");
		a.setMatricula("123456");
		return a;
	}

	private Aluno criarAlunoPadrao() {
		Aluno a = new Aluno();
		a.setNome("Alisson");
		a.setMatricula("741852");
		a.setCpf("898989898");
		a.setDataNascimento("24/01/1991");
		a.setSexo("Masculino");
		a.setRg("123");
		return a;
	}

	private Professor criarProfessorMinimo() {
		Professor p = new Professor();
		p.setNome("Rodrigo Vilar");
		p.setCpf("123456");
		return p;
	}

	private Professor criarProfessorPadrao() {
		Professor p = new Professor();
		p.setNome("Ayla");
		p.setCpf("741852");
		p.setDataNascimento("xx/xx/xxxx");
		p.setRg("1234566");
		p.setSexo("Feminino");
		return p;

	}

}
