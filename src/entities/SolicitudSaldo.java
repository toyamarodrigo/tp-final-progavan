package entities;

public class SolicitudSaldo extends Transaccion {

    public SolicitudSaldo(int numCuenta, Pantalla pantalla, BDBanco bdBanco) {
        super(numCuenta, pantalla, bdBanco);
    }

    @Override
    public void iniciar() {

        // Banco y pantalla referencia desde transaccion;
        Pantalla pantalla = getPantalla();
        BDBanco bdBanco = getBDBanco();

        // saldo disponible y balance de una cuenta
        double saldoDisponible = bdBanco.getSaldoDisponible(getNumCuenta());
        double totalBalance = bdBanco.getTotalBalance(getNumCuenta());

        // Mostrar pantalla, saldo y balance
        pantalla.mostrarMensaje("Saldo disponible: " + saldoDisponible);
        pantalla.mostrarMensaje("Balance total: " + totalBalance);
        pantalla.mostrarMensaje("");
    }

}
