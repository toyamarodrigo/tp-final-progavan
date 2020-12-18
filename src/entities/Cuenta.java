package entities;

public class Cuenta {
    private int numCuenta;
    private int pin;
    private double saldoDisponible;
    private double totalBalance;

    public Cuenta(int numCuenta, int pin, double saldoDisponible, double totalBalance) {
        this.numCuenta = numCuenta;
        this.pin = pin;
        this.saldoDisponible = saldoDisponible;
        this.totalBalance = totalBalance;
    }

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
        totalBalance += monto;
    }

    public void retirar(double monto) {
        if(monto % 20 == 0) {
            if (monto < saldoDisponible+1) {
                saldoDisponible -= monto;
                totalBalance -= monto;
            }else {
                System.out.println("Error, no puede retirar más que su saldo.");
            }
        }else {
            System.out.println("Solo puede retirar un monto divisible por 20.");
        }
    }

}
