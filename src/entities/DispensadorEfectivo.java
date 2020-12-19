package entities;

public class DispensadorEfectivo {
    private int count;

    public DispensadorEfectivo() {
        count = 500;
    }

    public void dispensarEfectivo(int cantidad) {
        int efectivoRequerido = cantidad / 20;
        count -= efectivoRequerido;
    }

    public boolean efectivoDisponible(int cantidad) {
        int efectivoDisponible = cantidad / 20;

        if (count >= efectivoDisponible) {
            return true;
        } else {
            return false;
        }
    }
}
