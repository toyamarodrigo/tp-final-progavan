package entities;

public class SolicitudSaldo extends Transaccion {

    public SolicitudSaldo(int numCuenta, Pantalla pantalla, BDBanco bdBanco) {
        super(numCuenta, pantalla, bdBanco);
    }

    @Override
    public void iniciar() {

        // Banco y pantalla referencia desde transaccion;
        // Pantalla pantalla = getPantalla();
        // BDBanco bdBanco = getBDBanco();

        // saldo y total de una cuenta
        // saldoDisponible getSaldoDisponible(get numero de cuenta);
        // totalBalance gettotalBalance(get numero de cuenta);

        // mostrar pantalla
        // saldoDisponible
        // balance total;

    }

}
