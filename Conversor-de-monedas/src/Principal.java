import Modulos.ConsultaDivisa;
import Modulos.Mensajes;
import Modulos.Menu;
import com.google.gson.*;

import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        ConsultaDivisa consultaDivisa = new ConsultaDivisa();
        Menu menu = new Menu();
        Mensajes mensaje = new Mensajes();
        int opcion = 0;

        while (opcion != 3) {
            mensaje.bienvenida();
            mensaje.menuOpciones();
            try {
                mensaje.seleccionaUnaOpcion();
                opcion = menu.opcion();
                System.out.println(mensaje.seleccionasteLaOpcion(opcion));
                switch (opcion) {
                    case 1:
                        mensaje.cabecerasDivisas();
                        menu.menu();
                        mensaje.divisaInicial();
                        String divisaOrigen = menu.obtenerCodigoMoneda();
                        mensaje.divisaFinal();
                        String divisaDestino = menu.obtenerCodigoMoneda();
                        double monto = menu.monto();
                        String divisaResultado = consultaDivisa.buscaDivisa(divisaOrigen);


                        JsonElement jsonElement = JsonParser.parseString(divisaResultado);
                        JsonObject obtenerConversiones = jsonElement.getAsJsonObject().getAsJsonObject("conversion_rates");
                        double tasaDeConversion = obtenerConversiones.get(divisaDestino).getAsDouble();

                        mensaje.cabeceraResultado();
                        System.out.println(mensaje.resultadoMensaje(divisaOrigen, divisaDestino, tasaDeConversion, monto));

                        mensaje.realizaOtraConversion();
                        mensaje.seleccionaUnaOpcion();

                        int opcionContinuar = menu.opcion();
                        switch (opcionContinuar){
                            case 1:
                                break;
                            case 2:
                                mensaje.salir();
                                break;
                            default:
                                mensaje.opcionNoValida();
                                break;
                        }

                        break;
                    case 2:
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
