package entities;

public class Deposito extends Transaccion {

    private double montoIngresado;
    private RanuraDeposito ranuraDeposito;
    private Teclado teclado;

    public Deposito(int numCuenta, Pantalla pantalla, BDBanco bdBanco, RanuraDeposito ranuraDeposito, Teclado teclado) {
        super(numCuenta, pantalla, bdBanco);
        this.ranuraDeposito = ranuraDeposito;
        this.teclado = teclado;
    }

    @Override
    public void iniciar() {
        Pantalla pantalla = getPantalla();
        BDBanco bdBanco = getBDBanco();

        // Ingreso de monto a depositar
        pantalla.mostrarMensaje("Ingrese el saldo que desea depositar: $");
        montoIngresado = teclado.getEntrada();

        if (montoIngresado != 0) {
            boolean recibeSobre = ranuraDeposito.recibeSobres();
            // Si recibe los sobres deposita en la cuenta del banco del usuario
            if (recibeSobre) {
                bdBanco.depositar(getNumCuenta(), montoIngresado);
                montoSaldo = bdBanco.getSaldoDisponible(getNumCuenta());
                montoBalance = bdBanco.getTotalBalance(getNumCuenta());
                pantalla.mostrarMensaje("Saldo disponible: $" + montoSaldo);
                pantalla.mostrarMensaje("Balance total: $" + montoBalance);
                pantalla.mostrarMensaje("");
            }
        } else {
            pantalla.mostrarMensaje("Deposito cancelado");
            pantalla.mostrarMensaje("");
        }

    }

}
