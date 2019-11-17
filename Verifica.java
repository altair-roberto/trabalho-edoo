
/******************************************************************************
 *	@author Altair Roberto
 *	@author Rogério Oliveira
 *
 *	Compilation:  javac -cp ../algs4 Verifica.java
 *  Execution:    java -cp ../algs4.jar:. Verifica < entrada.txt
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.*;
import java.util.ArrayList;

class Turma {
	private String nome;
	private String dia;
	private String hora;
	private String duracao;
	private String local;

	public Turma(String nome, String dia, String hora, String duracao, String local) {
		this.nome = nome;
		this.dia = dia;
		this.hora = hora;
		this.duracao = duracao;
		this.local = local;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDia() {
		return this.dia;
	}

	public String getHora() {
		return this.hora;
	}

	public String getDuracao() {
		return this.duracao;
	}

	public String getLocal() {
		return this.local;
	}

	public String toString() {
		String s = "{";
		s += this.dia + ", " + this.hora + ", " + this.duracao + ", " + this.local + "}";
		return s;
	}
}

public class Verifica {
	public static void main(String[] args) {
		RedBlackBST<String, String> stProfessor = new RedBlackBST<String, String>();
		RedBlackBST<String, String> stTurma = new RedBlackBST<String, String>();
		RedBlackBST<String, String> stSala = new RedBlackBST<String, String>();
		RedBlackBST<String, String> stSalaTurma = new RedBlackBST<String, String>();
		RedBlackBST<String, ArrayList<Turma>> stDadosTurma = new RedBlackBST<String, ArrayList<Turma>>();
		RedBlackBST<String, ArrayList<String>> stProfessorTurma = new RedBlackBST<String, ArrayList<String>>();
		RedBlackBST<String, String> stTurmaProfessor = new RedBlackBST<String, String>();
		RedBlackBST<String, String> stHorarios = new RedBlackBST<String, String>();
		SET<String> setHorariosDeInicio = new SET<String>();
		String mensagensDeErro = "";

		String[] horarios = { "7h15", "8h15", "9h25", "10h25", "11h25", "13h15", "14h15", "15h25", "16h25", "17h25",
				"18h30", "20h40", "21h40" };

		for (int i = 0; i < horarios.length; ++i) {
			setHorariosDeInicio.add(horarios[i]);
		}

		// lê nome do professor e abreviação
		while (StdIn.hasNextLine()) {
			String str = StdIn.readLine();

			if (str.compareTo("") == 0) {
				break;
			}

			str = str.replaceAll("\"", "");
			String[] strArray = str.split(",");
			strArray[1] = strArray[1].trim();

			stProfessor.put(strArray[1], strArray[0]);
		}

		// lê nome da turma e abreviação
		while (StdIn.hasNextLine()) {
			String str = StdIn.readLine();

			if (str.compareTo("") == 0) {
				break;
			}

			str = str.replaceAll("\"", "");
			String[] strArray = str.split(",");
			strArray[1] = strArray[1].trim();

			stTurma.put(strArray[1], strArray[0]);
		}

		// lê o nome da sala e abreviação
		while (StdIn.hasNextLine()) {
			String str = StdIn.readLine();

			if (str.compareTo("") == 0) {
				break;
			}

			str = str.replaceAll("\"", "");
			String[] strArray = str.split(",");
			strArray[1] = strArray[1].trim();

			stSala.put(strArray[1], strArray[0]);
		}

		// lê associações entre os elementos
		while (StdIn.hasNextLine()) {
			String str = StdIn.readLine();

			if (str.compareTo("") == 0) {
				break;
			}

			str = str.replaceAll("\"", "");
			String[] strArray = str.split(",");

			for (int i = 0; i < strArray.length; ++i) {
				strArray[i] = strArray[i].trim();
			}

			// verifica se a sala está cadastrada
			boolean existeSala = stSala.contains(strArray[4]);
			if (!existeSala) {
				mensagensDeErro += strArray[4] + " é uma sala inexistente\n";
			}

			// verifica se a turma está cadastrada
			boolean existeTurma = stTurma.contains(strArray[0]);
			if (!existeTurma) {
				mensagensDeErro += strArray[0] + " é uma turma inexistente\n";
			}

			// verifica se o horario de inicio e a duração de aula são válidos
			boolean horarioValido = setHorariosDeInicio.contains(strArray[2]);

			if (!horarioValido) {
				mensagensDeErro += "O horário de início da aula " + strArray[0] + " e inválido\n";
			} else {

				int duracao = Integer.parseInt(strArray[3]);
				duracao = duracao * 100;

				String inicio = strArray[2];
				inicio = inicio.replaceAll("h", "");
				int inicioInt = Integer.parseInt(inicio);

				if (inicioInt == 715 || inicioInt == 815) {
					if (inicioInt + duracao > 915) {
						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}
				}

				if (inicioInt == 925 || inicioInt == 1025 || inicioInt == 1125) {
					if (inicioInt + duracao > 1225) {
						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}
				}

				if (inicioInt == 1315 || inicioInt == 1415) {
					if (inicioInt + duracao > 1515) {
						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}
				}

				if (inicioInt == 1525 || inicioInt == 1625 || inicioInt == 1725) {
					if (inicioInt + duracao > 1825) {

						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}
				}

				if (inicioInt == 1830 || inicioInt == 1930) {
					if (inicioInt + duracao > 2030) {
						StdOut.println(strArray[0] + ": " + "Inicio: " + inicioInt + "Fim: " + (inicioInt + duracao));
						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}

				}

				if (inicioInt == 2040 || inicioInt == 2140) {
					if (inicioInt + duracao > 2230) {
						mensagensDeErro += "Duração de aula de " + strArray[0] + " ultrapassa os limites permitidos\n";
						horarioValido = false;
					}
				}
			}

			// verifica se a sala esta disponível no horário
			String codigoDeAlocacao = strArray[4] + strArray[1] + strArray[2];
			boolean salaDisponivel = !stSalaTurma.contains(codigoDeAlocacao);
			if (!salaDisponivel) {
				mensagensDeErro += strArray[4] + " está com mais de uma turma alocada no mesmo horário: "
						+ stSalaTurma.get(codigoDeAlocacao) + ", " + strArray[0] + "\n";
			}

			// se tudo estiver correto insere as informações da turma na estrutura de dados
			if (existeSala && existeTurma && horarioValido && salaDisponivel) {
				Turma turma = new Turma(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4]);
				if (stDadosTurma.contains(turma.getNome())) {
					stDadosTurma.get(turma.getNome()).add(turma);
				} else {
					ArrayList<Turma> ar = new ArrayList<Turma>();
					ar.add(turma);
					stDadosTurma.put(turma.getNome(), ar);
				}

				stSalaTurma.put(codigoDeAlocacao, strArray[0]);
			}
		}

		// lê atribuições de turma para um professor
		while (StdIn.hasNextLine()) {
			String str = StdIn.readLine();

			if (str.compareTo("") == 0) {
				break;
			}

			str = str.replaceAll("\"", "");
			String[] strArray = str.split(",");
			strArray[1] = strArray[1].trim();

			// verifica se a turma está cadastrada
			boolean existeTurma = stTurma.contains(strArray[0]);
			if (!existeTurma) {
				mensagensDeErro += strArray[0] + " é uma turma inexistente\n";
			}

			// verifica se o professor está cadastrado
			boolean existeProfessor = stProfessor.contains(strArray[1]);
			if (!existeProfessor) {
				mensagensDeErro += strArray[1] + " é um professor inexistente\n";
			}

			// verifica se a turma já é ministrada por outro professor
			boolean turmaDisponivel = !stTurmaProfessor.contains(strArray[0]);
			if (!turmaDisponivel) {
				mensagensDeErro += strArray[0] + " está sendo ministrada por mais de um professor: "
						+ stTurmaProfessor.get(strArray[0]) + ", " + strArray[1] + "\n";
			}

			// checa se o professor dá aula para outra turma no mesmo horário
			boolean conflitoDeHorarios = false;
			if (stProfessorTurma.contains(strArray[1]) && stDadosTurma.contains(strArray[0])) {
				loops:
				for (String s : stProfessorTurma.get(strArray[1])) {
					for (Turma t1 : stDadosTurma.get(strArray[0])) {
						for (Turma t2 : stDadosTurma.get(s)) {
							if (t1.getHora().compareTo(t2.getHora()) == 0) {
								conflitoDeHorarios = true;
								mensagensDeErro += strArray[1] + " está ministrando duas turmas no mesmo horario: " +
									t2.getNome() + ", " + strArray[0] + "\n";
									break loops;
							}
						}
					}
				}
			}

			// se todas as informações estiverem corretas atribui a turma ao professor
			if (existeTurma && existeProfessor && turmaDisponivel && !conflitoDeHorarios) {
				if (stProfessorTurma.contains(strArray[1])) {
					stProfessorTurma.get(strArray[1]).add(strArray[0]);
				} else {
					ArrayList<String> ar = new ArrayList<String>();
					ar.add(strArray[0]);
					stProfessorTurma.put(strArray[1], ar);
				}

				stTurmaProfessor.put(strArray[0], strArray[1]);
			}
		}

		/*// exibe informacoes armazenadas
		StdOut.println("LISTA DE PROFESSORES");
		for (String s : stProfessor.keys()) {
			StdOut.println(s + ": " + stProfessor.get(s));
		}

		StdOut.println("\nLISTA DE TURMAS");
		for (String s : stTurma.keys()) {
			StdOut.println(s + ": " + stTurma.get(s));
		}

		StdOut.println("\nLISTA DE SALAS");
		for (String s : stSala.keys()) {
			StdOut.println(s + ": " + stSala.get(s));
		}

		StdOut.println("\nLISTA DE TURMAS E SEUS LOCAIS E HORARIOS");
		for (String s : stDadosTurma.keys()) {
			StdOut.println(s + ": " + stDadosTurma.get(s));
		}

		StdOut.println("\nLISTA DE TURMAS E SEUS PROFESSORES");
		for (String s : stTurmaProfessor.keys()) {
			StdOut.println(s + ": " + stTurmaProfessor.get(s));
		}

		StdOut.println("\nLISTA DE TURMAS DE CADA PROFESSOR");
		for (String s : stProfessorTurma.keys()) {
			StdOut.println(s + ": " + stProfessorTurma.get(s));
		}*/

		// exibe os eventuais erros encontrados
		StdOut.print(mensagensDeErro);

	}
}
