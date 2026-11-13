package ui;

import java.util.Scanner;

public class Leitor {

    private final Scanner teclado;

    public Leitor(Scanner teclado) {
        this.teclado = teclado;
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double leitura(String qual) {
        while (true) {
            System.out.println("Digite o " + qual + " número: ");
            String texto = teclado.nextLine().trim().replace(',', '.'); // aceita 3,5 e 3.5
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, tente novamente.");
            }
        }
    }
}
