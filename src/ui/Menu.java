package ui;

import java.util.List;
import java.util.Scanner;
import minhaexcecao.MyException;
import service.Calculadora;
import service.Historico;

public class Menu {
    private final Leitor leitor;
    private final Historico historico = new Historico();

    public Menu(Scanner teclado) {
        this.leitor = new Leitor(teclado);
    }

    public void iniciar() {
        int opcao;
        do {
            exibir();
            opcao = leitor.lerOpcao();

            switch (opcao) {
                case 1, 2, 3, 4 -> executar(opcao);
                case 5 -> exibirHistorico();
                case 6 -> limparHistorico();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void executar(int opcao) {
        double n1 = leitor.leitura("Primeiro");
        double n2 = leitor.leitura("Segundo");

        try {
            double resultado = 
            switch (opcao) {
                case 1 -> Calculadora.soma(n1, n2);
                case 2 -> Calculadora.subtrair(n1, n2);
                case 3 -> Calculadora.multiplicar(n1, n2);
                case 4 -> Calculadora.dividir(n1, n2);
                default -> throw new IllegalArgumentException("Operação desconhecida" + opcao);
            };

            String simbolo =
            switch (opcao) {
                case 1 -> "+";
                case 2 -> "-";
                case 3 -> "x";
                default -> "/";
            };
            
            System.out.printf("Resultado = %.2f%n", resultado);
            historico.adicionar(String.format("%.2f %s %.2f = %.2f", n1, simbolo, n2,resultado));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Historico vazio.");
            return;
        }

        System.out.println("--- Histórico ---");
        List<String> registros = historico.getRegistros();
        for (int i = 0; i < registros.size(); i++) {
            System.out.println((i + 1) + ". " + registros.get(i));
        }
    }

    private void limparHistorico() {
        historico.limpar();
        System.out.println("Hisotrico apagado.");
    }

    private void exibir() {
        System.out.println();
        System.out.println("╔══════════════════════╗");
        System.out.printf("║ %-20s ║%n", "     CALCULADORA");
        System.out.println("╠══════════════════════╣");
        System.out.printf("║ %-20s ║%n", "1 - Somar");
        System.out.printf("║ %-20s ║%n", "2 - Subtrair");
        System.out.printf("║ %-20s ║%n", "3 - Multiplicar");
        System.out.printf("║ %-20s ║%n", "4 - Dividir");
        System.out.printf("║ %-20s ║%n", "5 - Ver historico");
        System.out.printf("║ %-20s ║%n", "6 - Limpar historico");
        System.out.printf("║ %-20s ║%n", "0 - Sair");
        System.out.println("╚══════════════════════╝");
        System.out.print("Escolha uma opção: ");

    }
}
