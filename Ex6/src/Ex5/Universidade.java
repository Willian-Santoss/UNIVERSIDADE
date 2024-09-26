package Ex5;

public class Universidade {
	    private String nome;         // Nome do aluno
	    private String ra;           // Registro Acadêmico do aluno
	    private double[] notas;      // Array para armazenar as notas
	    private boolean ead;         // Indica se a disciplina é EAD
	    private double presenca;     // Percentual de presença para disciplinas presenciais

	    // Construtor para disciplinas EAD
	    public Universidade(String nome, String ra, double[] notas) {
	        this.nome = nome;        // Inicializa o nome do aluno
	        this.ra = ra;            // Inicializa o RA do aluno
	        this.notas = notas;      // Inicializa as notas do aluno
	        this.ead = true;         // Marca como EAD
	    }

	    // Construtor para disciplinas presenciais
	    public Universidade(String nome, String ra, double[] notas, double presenca) {
	        this(nome, ra, notas);    // Chama o construtor EAD
	        this.ead = false;         // Marca como presencial
	        this.presenca = presenca; // Inicializa a presença do aluno
	    }

	    // Método para calcular a nota final
	    public double calcularNotaFinal() {
	        double notaFinal = 0;                // Inicializa a variável para a nota final
	        int totalAvaliacoes = notas.length;  // Obtém o número total de avaliações

	        // Verifica o número de avaliações e calcula a nota final
	        if (totalAvaliacoes == 1 || totalAvaliacoes == 2) {
	            // Para 1 ou 2 avaliações: média aritmética
	            for (double nota : notas) {
	                notaFinal += nota;             // Soma todas as notas
	            }
	            return notaFinal / totalAvaliacoes; // Retorna a média
	        } else if (totalAvaliacoes == 3) {
	            // Para 3 avaliações: média ponderada
	            return (notas[0] + 2 * notas[1] + 2 * notas[2]) / 5; // Cálculo ponderado
	        } else if (totalAvaliacoes == 4) {
	            // Para 4 avaliações: cálculo com pesos definidos
	            return (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45); // Cálculo com pesos
	        }

	        return -1; // Retorna -1 para indicar erro se o número de avaliações for inválido
	    }

	    // Método para verificar se o aluno está aprovado
	    public String verificarSit() {
	        double notaFinal = calcularNotaFinal(); // Calcula a nota final
	        // Verifica se a disciplina é EAD ou presencial e determina a situação
	        if (ead) {
	            return notaFinal >= 5 ? "Aprovado" : "Reprovado"; // Aprovado se nota >= 5
	        } else {
	            return (notaFinal >= 5 && presenca >= 75) ? "Aprovado" : "Reprovado"; // Aprovado se nota >= 5 e presença >= 75%
	        }
	    }

	    // Método para imprimir as informações do aluno
	    public void informação() {
	        double notaFinal = calcularNotaFinal(); // Calcula a nota final
	        String situacao = verificarSit();   // Verifica a situação do aluno

	        // Imprime as informações do aluno formatadas
	        System.out.printf("Nome: %s\nRA: %s\nNota Final: %.2f\nSituação: %s\n", 
	                          nome, ra, notaFinal, situacao);
	    }
	    
	    public static void main(String[] args) {
	        double[] notasPresenciais = {6.0, 7.5, 8.0, 9.0};  // 4 notas, ac1, ac2, ag e af
	        Universidade aluno1 = new Universidade("João Silva", "202301", notasPresenciais, 80);
	        aluno1.informação();

	        System.out.println(" ");
	        
	        double[] notasEAD = {5.0, 6.0, 7.0};  // 3 notas
	        Universidade aluno2 = new Universidade("Maria Oliveira", "202302", notasEAD);
	        aluno2.informação();

	        System.out.println(" ");
	        
	        double[] notas2 = {8.0, 9.0};  // 2 avaliações
	        Universidade aluno3 = new Universidade("Pedro Santos", "202303", notas2, 70);
	        aluno3.informação();
	    }
	}

