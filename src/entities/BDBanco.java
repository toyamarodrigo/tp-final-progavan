package entities;

public class BDBanco {

	private Cuenta[] cuentas;

	public BDBanco() {
		cuentas = new Cuenta[3];
		cuentas[0] = new Cuenta(11111, 22222, 10000.00, 15000.00);
		cuentas[1] = new Cuenta(22222, 33333, 500.00, 500.00);
		cuentas[3] = new Cuenta(33333, 00000, 900.00, 1000.00);
	}

	private Cuenta getCuenta(int numCuenta) {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNumCuenta() == numCuenta) {
				return cuenta;
			}
		}
		return null;
	}

	public boolean autenticarUsuario(int numCuentaUsuario, int usuarioPIN) {
		// chequeamos si existe la cuenta
		Cuenta cuentaUsuario = getCuenta(numCuentaUsuario);

		if (cuentaUsuario != null) {
			return cuentaUsuario.validarPIN(usuarioPIN);
		} else {
			return false;
		}
	}

	public double getSaldoDisponible(int numCuentaUsuario) {
		return getCuenta(numCuentaUsuario).getTotalBalance();
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
