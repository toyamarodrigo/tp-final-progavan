package entities;

public class Deposito extends Transaccion {

    private double monto;
    private RanuraDeposito ranuraDeposito;
    private Teclado teclado;

    public Deposito(int numCuenta, Pantalla pantalla, BDBanco bdBanco, RanuraDeposito ranuraDeposito, Teclado teclado) {
        super(numCuenta, pantalla, bdBanco);
        this.ranuraDeposito = ranuraDeposito;
        this.teclado = teclado;
    }

    @Override
    public void iniciar() {
        // Banco y pantalla referencia de transaccion;
        // BDBanco bdBanco = getBDBanco();
        // Pantalla pantalla = getPantalla();

        Pantalla pantalla = getPantalla();
        BDBanco bdBanco = getBDBanco();

        // saldo disponible y balance de una cuenta
        pantalla.mostrarMensaje("Ingrese el saldo que desea depositar: $");
        bdBanco.depositar(getNumCuenta(), teclado.getEntrada());
        montoSaldo = bdBanco.getSaldoDisponible(getNumCuenta());
        montoBalance = bdBanco.getTotalBalance(getNumCuenta());


        pantalla.mostrarMensaje("Saldo disponible: $" + montoSaldo);
        pantalla.mostrarMensaje("Balance total: $" + montoBalance);
        pantalla.mostrarMensaje("");

        // Mostrar pantalla, saldo y balance

        // input de monto a demositar

        // si monto es != 0
            // insertar sobre con el monto
            // boolean sobreRecibido = ranuraDeposito.recibeSobres();
            // si sobreRecibido
                // mostrar mensaje se recibio
                // agregar monto a banco de la cuenta --> bdBanco.depositar(numero cuenta, monto)
            // sino
                //mostrar no se inserto sobre
        // si monto = 0
            // mostar se cancelo deposito

    }

}
