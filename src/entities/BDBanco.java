package entities;

import java.util.ArrayList;

public class BDBanco {

    private ArrayList<Cuenta> cuentas;

    public BDBanco() {
        cuentas = new ArrayList<Cuenta>(3);
        cuentas.add(new Cuenta(11111, 11111, 10000.00, 15000.00));
        cuentas.add(new Cuenta(22222, 22222, 500.00, 500.00));
        cuentas.add(new Cuenta(33333, 33333, 900.00, 1000.00));
    }

    // Obtener la cuenta autenticada
    private Cuenta getCuenta(int numCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumCuenta() == numCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean autenticarUsuario(int numCuentaUsuario, int usuarioPIN) {
        // Chequeamos si existe la cuenta
        Cuenta cuentaUsuario = getCuenta(numCuentaUsuario);

        // Si existe el usuario validamos el pin ingresado con el de la base de datos
        if (cuentaUsuario != null) {
            return cuentaUsuario.validarPIN(usuarioPIN);
        } else {
            return false;
        }
    }

    public double getSaldoDisponible(int numCuentaUsuario) {
        return getCuenta(numCuentaUsuario).getSaldoDisponible();
    }

    public double getTotalBalance(int numCuentaUsuario) {
        return getCuenta(numCuentaUsuario).getTotalBalance();
    }

    public void depositar(int numCuentaUsuario, double monto) {
        getCuenta(numCuentaUsuario).depositar(monto);
    }

    public void retirar(int numCuentaUsuario, double monto) {
        getCuenta(numCuentaUsuario).retirar(monto);
    }

}
