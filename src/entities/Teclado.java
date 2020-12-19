package entities;

import java.util.Scanner;

public class Teclado {

    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    public int getEntrada() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            return Integer.parseInt("Debe ingresar obligatoriamente un número entero.");
        }
    }

}
