package Modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensajes {
    public void salir(){
        System.out.println("Finalizando el programa.");
        System.exit(0);
    }

    public void opcionNoValida(){
        System.out.println("Opcion no valida, Seleccione una opcion valida.");
    }

    public void ingresaLaCantidad(){
        System.out.println("Ingresa la cantidad a convertir.");
    }

    public void divisaInicial(){
        System.out.println("Selecciona una divisa para iniciar.");
    }

    public void divisaFinal(){
        System.out.println("Selecciona otra divisa.");
    }

    public void seleccionaUnaOpcion(){
        System.out.println("Selecciona una opcion para continuar.");
    }

    public void menuOpciones(){
        String menuPrincipal = """
               1. Conversor de divisas.
               2. Historial.
               3. Salir.
               """;
        System.out.println(menuPrincipal);
    }

    public void bienvenida(){
        String bienvenida = """
                ------------------------------------------------
                 BIENVENID@ AL SISTEMA DE CONVERSION DE DIVISAS
                ------------------------------------------------
                """;
        System.out.println(bienvenida);
    }

    public void cabecerasDivisas(){
        String cabeceraDivisas = """
                --------------------------------------------------
                                LISTA DE DIVISAS
                --------------------------------------------------
                """;
        System.out.println(cabeceraDivisas);
    }

    public void cabeceraResultado(){
        String resultadoCabecera = """
                --------------------------------------------------
                                     RESULTADO
                --------------------------------------------------
                """;
        System.out.println(resultadoCabecera);
    }
    
    public String resultadoMensaje(String divisaOrigen, String divisaDestino, double tasaDeConversion, double monto ){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);
        String resultadoDeLaConversion = String.format("%." + 3 + "f", (tasaDeConversion*monto));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Consulta consulta = new Consulta(fechaHoraFormateada, monto, divisaOrigen, resultadoDeLaConversion, divisaDestino);
        try {
            FileWriter escritura = new FileWriter("consultas.json");
            escritura.write(gson.toJson(consulta));
            escritura.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return fechaHoraFormateada + "\n" + monto + " "+ divisaOrigen + " es igual a: " + resultadoDeLaConversion + " " + divisaDestino + "\n";
    }

    public String seleccionasteLaOpcion(int opcion){
        return "Seleccionaste la opcion: " + opcion;
    }

    public void realizaOtraConversion(){
        String opciones = """
                1. Regresar al menu
                2. Salir
                """;
        System.out.println(opciones);
    }
}
