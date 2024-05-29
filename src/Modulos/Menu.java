package Modulos;

import java.util.Scanner;

public class Menu {
    Scanner lectura = new Scanner(System.in);
    Mensajes mensaje = new Mensajes();

    OpcionesMenu[] opciones = {
            new OpcionesMenu(1, "Peso mexicano", "MXN", "Mexico"),
            new OpcionesMenu(2, "Peso argentino", "ARS", "Argentina"),
            new OpcionesMenu(3, "Boliviano boliviano", "BOB", "Bolivia"),
            new OpcionesMenu(4, "Real brasileño", "BRL", "Brasil"),
            new OpcionesMenu(5, "Peso chileno", "BRL", "Chile"),
            new OpcionesMenu(6, "Peso colombiano", "COP", "Colombia"),
            new OpcionesMenu(7, "Dolar estadounidense", "USD", "Estados unidos"),
    };
    
    public void menu(){
        System.out.printf("%-4s%-8s%-15s%-22s%n", "", "CODIGO", "PAIS","NOMBRE DE LA MONEDA");
        for (OpcionesMenu opcion : opciones) {
            System.out.printf("%-4d%-8s%-15s%-22s%n",
                    opcion.id(),
                    opcion.codigoMoneda(),
                    opcion.nombrePais(),
                    opcion.nombreMoneda()
                    );
        }
    }
    
    public String obtenerCodigoMoneda(){
        int opcionSeleccionada;
        String nombreDivisa = "";
        boolean opcionValida;
        do {
            opcionValida = false;
            opcionSeleccionada = lectura.nextInt();
            for (OpcionesMenu opcion : opciones) {
                if (opcion.id() == opcionSeleccionada){
                    nombreDivisa = opcion.codigoMoneda();
                    opcionValida = true;
                    break;
                }
            }
            if (!opcionValida) {
                mensaje.opcionNoValida();
            }
        } while (!opcionValida);
        return nombreDivisa;
    }

    public double monto(){
        mensaje.ingresaLaCantidad();
        return lectura.nextDouble();
    }

    public int opcion(){
        return lectura.nextInt();
    }

    public void menuContinuar (){
        int opcionContinuar = lectura.nextInt();
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
    }

    public void limpiarLectura(){
        lectura.next();
    }

    public void cerrarLectura(){
        lectura.close();
    }

    record OpcionesMenu(int id, String nombreMoneda, String codigoMoneda, String nombrePais) { }
}
