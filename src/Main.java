
import java.util.Scanner;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            new Menu(teclado).iniciar();
            teclado.close();
        }
    }
}