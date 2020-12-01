package entities;

public class ATM {

	private boolean usuarioAutenticado;
	private int usuarioActual;
	private Pantalla pantalla;
	private Teclado teclado;
	private DispensadorEfectivo dispensadorEfectivo;
	private RanuraDeposito ranuraDeposito;
	private BDBanco bdBanco;	

	public ATM() {
		usuarioAutenticado = false;
		usuarioActual = 0;
		pantalla = new Pantalla();
		teclado = new Teclado();
		dispensadorEfectivo = new DispensadorEfectivo();
		ranuraDeposito = new RanuraDeposito();
		bdBanco = new BDBanco();
	}

	public void iniciar() {
	// Mientras true autenticamos al usuario y mostramos Opciones transaccion
		// Mientras NO este autenticado 
		// mostramos mensaje Bienvenida y lo Autenticamos --> autenticarUsuario()
	// menu principal, y transacciones
		// Transaccion transaccionActual = null;
		// boolean usuarioQuit = false;
		// Mientras usuario no se haya ido
			// mostramos menu --> mostrarMenu() retorna valor de transaccion
			// switch (valor transaccion)
				// case 1
					// transaccionActual = new SolicitudSaldo(numero de cuenta, pantalla, base banco)
				// case 2 
					// transaccionActual = new Retiro(numero cuenta, pantalla, base banco, teclado, dispensador) 
				// case 3
					// transaccionActual = new Deposito(numero cuenta, pantalla, base banco, teclado, ranura
				// case 4
					// se fue usuario
					// usuarioQuit = true;
				// default
					// opcion invalida
	}

	private int mostrarMenu() {
		// usando pantalla.mostrarMensaje()
		// "1 - Ver saldo disponible"
		// "2 - Retirar saldo"
		// "3 - Depositar saldo"
		// "4 - Salir"
		// retornar input teclado
		return 1;
	}

	private void autenticarUsuario() {
		// input de Numero de cuenta
		// input de PIN
		// usuarioAutenticado = bdBanco.autenticarUsuario(numCuenta, PIN)
		// si usuarioAutenticado
			// usuarioActual = Numero de cuenta
		// sino mensaje numero o pin invalido
	}

}
