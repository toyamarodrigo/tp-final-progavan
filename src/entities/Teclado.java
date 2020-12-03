package entities;

import java.util.Scanner;

public class Teclado {

    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    public int getEntrada() {
        return sc.nextInt();
    }

}
