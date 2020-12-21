package entities;

public class Cuenta {
    private int numCuenta;
    private int pin;
    private double saldoDisponible;
    private double totalBalance;

    // Inicializacion de Cuenta
    public Cuenta(int numCuenta, int pin, double saldoDisponible, double totalBalance) {
        this.numCuenta = numCuenta;
        this.pin = pin;
        this.saldoDisponible = saldoDisponible;
        this.totalBalance = totalBalance;
    }

    // Validacion de PIN de la cuenta
    public boolean validarPIN(int usuarioPIN) {
        if (usuarioPIN == pin) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void depositar(double monto) {
        saldoDisponible += monto;
        totalBalance += monto;
    }

    public void retirar(double monto) {
        saldoDisponible -= monto;
        totalBalance -= monto;
    }

}
