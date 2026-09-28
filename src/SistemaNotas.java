import com.alunos.entity.Aluno;

import java.util.Scanner;

public class SistemaNotas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serão cadastrados? ");
        int quantidadeAlunos = sc.nextInt();

        Aluno[] alunos = new Aluno[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("\n--- Aluno " + (i + 1) + " ---");

            sc.nextLine(); // limpa o buffer antes de ler String
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Quantas notas esse aluno terá? ");
            int quantidadeNotas = sc.nextInt();

            Aluno aluno = new Aluno(nome, quantidadeNotas);

            for (int j = 0; j < quantidadeNotas; j++) {
                double nota = lerNotaValida(sc, j + 1);
                aluno.setNota(j, nota);
            }

            alunos[i] = aluno;
        }

        System.out.println("\n===== Resultado Final =====");
        for (Aluno aluno : alunos) {
            System.out.printf("Aluno: %s | Média: %.2f%n", aluno.getNome(), aluno.calcularMedia());
        }

        sc.close();
    }

    static double lerNotaValida(Scanner sc, int numeroProva) {
        double nota;
        do {
            System.out.print("Nota da prova " + numeroProva + ": ");
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }
}
