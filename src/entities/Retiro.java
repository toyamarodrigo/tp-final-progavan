package entities;

public class Retiro extends Transaccion {
    private int montoIngresado = 0;
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

        do {
            // Ingresar saldo a retirar
            pantalla.mostrarMensaje("Ingrese el saldo que desea retirar (0 para cancelar): $");
            montoIngresado = teclado.getEntrada();
            // Monto ingresado distinto de 0 y multiplo de 20
            if (montoIngresado != 0) {
                if (montoIngresado % 20 == 0) {
                    // Chequear balance/saldo disponible de la base banco del numero de cuenta
                    montoBalance = bdBanco.getTotalBalance(getNumCuenta());
                    montoSaldo = bdBanco.getSaldoDisponible(getNumCuenta());
                    if (montoIngresado <= montoBalance) {
                        // Si el dispensador tiene la cantidad del monto requerido en billetes de 20
                        if (dispensadorEfectivo.efectivoDisponible(montoIngresado)) {

                            // Se retira del banco el monto ingresado
                            bdBanco.retirar(getNumCuenta(), montoIngresado);

                            // Se dispensa el efectivo del dispensador
                            dispensadorEfectivo.dispensarEfectivo(montoIngresado);
                            efectivoDispensado = true;

                            pantalla.mostrarMensaje("Saldo disponible: $" + bdBanco.getSaldoDisponible(getNumCuenta()));
                            pantalla.mostrarMensaje("Balance total: $" + bdBanco.getTotalBalance(getNumCuenta()));
                            pantalla.mostrarMensaje("");

                            pantalla.mostrarMensaje("Efectivo dispensado");
                            pantalla.mostrarMensaje("");

                        } else {
                            pantalla.mostrarMensaje("No hay suficiente efectivo en el cajero");
                            pantalla.mostrarMensaje("Intenta con un monto menor");
                            pantalla.mostrarMensaje("");
                        }
                    } else {
                        pantalla.mostrarMensaje("No hay suficiente balance");
                        pantalla.mostrarMensaje("Intenta con un monto menor");
                        pantalla.mostrarMensaje("");
                    }
                } else {
                    pantalla.mostrarMensaje("Solo puede retirar un monto multiplo de 20.");
                    pantalla.mostrarMensaje("");
                }
            } else {
                pantalla.mostrarMensaje("Retiro cancelado.");
                pantalla.mostrarMensaje("");
                efectivoDispensado = true;
            }
        }
        while (!efectivoDispensado);



    }

}
