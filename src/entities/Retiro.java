package entities;

public class Retiro extends Transaccion {
    private double monto;
    private DispensadorEfectivo dispensadorEfectivo;
    private Teclado teclado;


    protected Retiro(int numCuenta, Pantalla pantalla, BDBanco bdBanco,
                     DispensadorEfectivo dispensadorEfectivo, Teclado teclado) {
        super(numCuenta, pantalla, bdBanco);
        this.dispensadorEfectivo = dispensadorEfectivo;
        this.teclado = teclado;
    }

    @Override
    public void iniciar() {
        boolean efectivoDispensado = false;

        Pantalla pantalla = getPantalla();
        BDBanco bdBanco = getBDBanco();

        // montos = [0,20,40,80,100,200,400]
        // int monto = 0;

        // hacer
            // mientras monto == 0
                // mostrar menu para retirar monto
                //  input del monto seleccionado
                // switch (input)
                    // case 1: 20
                    // case 2: 40
                    // case 3: 80
                    // case 4: 100
                    // case 5: 200
                    // case 6: 400
                        // guardamos en monto el montos[input]
                    // case 7:
                        // cancelar
                        // guardamos en monto el input
                    // default o 0:
                        // monto invalido

            // si monto != 7 (cancelado)
                // chequear balance disponible de la base banco del numero de cuenta
                // si el monto <= saldo disponible
                    // si el dispensador tiene la cantidad del monto requerido en billetes de 20
                        // retirar de la base del banco el monto de la cuenta
                        // dispensar efectivo
                        // mostrar efectivo dispensado, tomar el dinero.
                    // sino
                        // mostrar no hay suficiente dinero disponible en el cajero, proba con una cantidad menor.
                // sino
                    // mostrar tenes suficiente dinero en la cuenta, proba con una cantidad menor
            // sino
                // mostar transaccion cancelada
                // return a menu principal
        // mientras no se haya dispensado el efectivo
    }

}
