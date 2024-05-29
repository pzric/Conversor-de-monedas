package Modulos;

public class Mensajes {
    Fecha fecha = new Fecha();

    public void ingresaLaCantidad(){
        System.out.println("Ingresa la cantidad a convertir.");
    }

    public void divisaInicial(){
        System.out.println("Selecciona una divisa para iniciar.");
    }

    public void divisaFinal(){
        System.out.println("Selecciona otra divisa.");
    }

    public void opcionNoValida(){
        System.out.println("Opcion no valida, Seleccione una opcion valida.");
    }

    public void menuOpciones(){
        String menuPrincipal = """
               1. Conversor de divisas.
               2. Historial.
               3. Salir.
               ------------------------------------------------
               Selecciona una opcion para continuar.""";
        System.out.println(menuPrincipal);
    }

    public void bienvenida(){
        String bienvenida = """
                ------------------------------------------------
                 BIENVENID@ AL SISTEMA DE CONVERSION DE DIVISAS
                ------------------------------------------------""";
        System.out.println(bienvenida);
    }

    public void cabecerasDivisas(){
        String cabeceraDivisas = """
                --------------------------------------------------
                                LISTA DE DIVISAS
                --------------------------------------------------""";
        System.out.println(cabeceraDivisas);
    }

    public void cabeceraResultado(){
        String resultadoCabecera = """
                --------------------------------------------------
                                     RESULTADO
                --------------------------------------------------""";
        System.out.println(resultadoCabecera);
    }

    public void cabeceraHistorial(){
        String cabeceraHistorial = """
                --------------------------------------------------
                                    HISTORIAL
                --------------------------------------------------""";
        System.out.println(cabeceraHistorial);
    }

    public String resultadoMensaje(String divisaOrigen, String divisaDestino, double tasaDeConversion, double monto ){
        String resultadoDeLaConversion = String.format("%." + 3 + "f", (tasaDeConversion*monto));
        return fecha.obtenerFechaYHora() + ": " + monto + " "+ divisaOrigen + " es igual a: " + resultadoDeLaConversion + " " + divisaDestino;
    }

    public void opcionesContinuar(){
        String opciones = """
                \n1. Regresar al menu
                2. Salir
                --------------------------------------------------
                Selecciona una opcion para continuar.""";
        System.out.println(opciones);
    }

    public void salir(){
        System.out.println("Finalizando el programa.");
        System.exit(0);
    }
}
