package entities;

public class ATM {

    private boolean usuarioAutenticado;
    private int usuarioActual;
    private BDBanco bdBanco;
    private Teclado teclado;
    private Pantalla pantalla;
    private RanuraDeposito ranuraDeposito;
    private DispensadorEfectivo dispensadorEfectivo;

    // Inicializar ATM sin parametros
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
        // Mientras true autenticamos al usuario y mostramos Opciones de transaccion
        while (true) {
            // Mientras NO este autenticado
            while (!usuarioAutenticado) {
                // mostramos mensaje Bienvenida y
                pantalla.mostrarMensaje("Bienvenido");
                // lo Autenticamos --> autenticarUsuario()
                autenticarUsuario();
            }
            // menu principal, y transacciones
            Transaccion transaccionActual = null;
            boolean usuarioQuit = false;

            // Mientras usuario no se haya ido
            while (!usuarioQuit) {
                // Mostramos el menu con 4 opciones
                int opcion = mostrarMenu();
                switch (opcion) {
                    case 1:
                        // Solicitud de Saldo
                        transaccionActual = new SolicitudSaldo(usuarioActual, pantalla, bdBanco);
                        transaccionActual.iniciar();
                        break;
                    case 2:
                        // Retiro
                        transaccionActual = new Retiro(usuarioActual, pantalla, bdBanco, dispensadorEfectivo, teclado);
                        transaccionActual.iniciar();
                        break;
                    case 3:
                        // Deposito
                        transaccionActual = new Deposito(usuarioActual, pantalla, bdBanco, ranuraDeposito, teclado);
                        transaccionActual.iniciar();
                        break;
                    case 4:
                        // Quit
                        usuarioQuit = true;
                        break;
                    default:
                        // Opcion invalida
                        pantalla.mostrarMensaje(opcion + " es una opcion invalida\n");
                        break;
                }
            }

            // Se deslogea el usuario y reseteamos los valores
            usuarioAutenticado = false;
            usuarioActual = 0;
            pantalla.mostrarMensaje("Gracias por utilizar ATM, Adios!");

        }
    }

    private int mostrarMenu() {

        // Mostramos por pantalla
        pantalla.mostrarMensaje("************************");
        pantalla.mostrarMensaje("1) Ver saldo disponible");
        pantalla.mostrarMensaje("2) Retirar saldo");
        pantalla.mostrarMensaje("3) Depositar saldo");
        pantalla.mostrarMensaje("4) Salir");
        pantalla.mostrarMensaje("************************");

        // retornar input teclado
        return teclado.getEntrada();
    }

    private void autenticarUsuario() {

        // input de Numero de cuenta
        pantalla.mostrarMensaje("Ingrese numero de cuenta: ");
        int numCuenta = teclado.getEntrada();

        // input de PIN
        pantalla.mostrarMensaje("Ingrese PIN: ");
        int pin = teclado.getEntrada();

        // chequeamos si existe la cuenta en la BBDD de Banco
        usuarioAutenticado = bdBanco.autenticarUsuario(numCuenta, pin);

        // si esta usuarioAutenticado
        if (usuarioAutenticado) {
            // usuarioActual setteamos Numero de cuenta ingresado
            usuarioActual = numCuenta;
            pantalla.mostrarMensaje("Bienvenido usuario: " + usuarioActual + "!\n");
        } else {
            // sino mensaje numero o pin invalido
            pantalla.mostrarMensaje("Numero de cuenta o Pin invalido");

        }
    }

}
