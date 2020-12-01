package entities;

public class Retiro extends Transaccion {
	private double monto;
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
		
		// cosas
		
	}

}
