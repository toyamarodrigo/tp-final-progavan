package entities;

public abstract class Transaccion {

	private int numCuenta;
	private Pantalla pantalla;
	private BDBanco bdBanco;

	public Transaccion(int numCuenta, Pantalla pantalla, BDBanco bdBanco) {
		this.numCuenta = numCuenta;
		this.pantalla = pantalla;
		this.bdBanco = bdBanco;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public BDBanco getBDBanco() {
		return bdBanco;
	}

	public abstract void iniciar();

}
