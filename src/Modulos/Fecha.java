package Modulos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {
    public String obtenerFechaYHora(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHoraActual.format(formato);
    }
}
