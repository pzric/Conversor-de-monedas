import Modulos.ConsultaDivisa;
import Modulos.Mensajes;
import Modulos.Menu;
import Modulos.RegistroConsultas;

import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        ConsultaDivisa consultaDivisa = new ConsultaDivisa();
        Menu menu = new Menu();
        Mensajes mensaje = new Mensajes();
        RegistroConsultas registroConsultas = new RegistroConsultas();
        int opcion = 0;

        while (opcion != 3) {
            mensaje.bienvenida();
            mensaje.menuOpciones();
            try {
                opcion = menu.opcion();
                switch (opcion) {
                    case 1:
                        mensaje.cabecerasDivisas();
                        menu.menu();
                        mensaje.divisaInicial();

                        String divisaOrigen = menu.obtenerCodigoMoneda();
                        mensaje.divisaFinal();
                        String divisaDestino = menu.obtenerCodigoMoneda();
                        double monto = menu.monto();

                        double tasaDeConversion = consultaDivisa.buscaDivisa(divisaOrigen, divisaDestino);
                        mensaje.cabeceraResultado();
                        String resultado = mensaje.resultadoMensaje(divisaOrigen, divisaDestino, tasaDeConversion, monto);
                        System.out.println(resultado);

                        registroConsultas.almacenarConsulta(resultado);

                        mensaje.opcionesContinuar();
                        menu.menuContinuar();
                        break;
                    case 2:
                        mensaje.cabeceraHistorial();
                        registroConsultas.leerConsultas();

                        mensaje.opcionesContinuar();
                        menu.menuContinuar();
                        break;
                    case 3:
                        mensaje.salir();
                        break;
                    default:
                        mensaje.opcionNoValida();
                        break;
                }
            }catch (InputMismatchException e){
                mensaje.opcionNoValida();
                menu.limpiarLectura();
            }
        }
        menu.cerrarLectura();
    }
}
