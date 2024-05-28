package Modulos;

import java.util.ArrayList;

public class RegistroConsultas {
    ArrayList<Registro> listaRegistro = new ArrayList<>();

    public void almacenarConsulta (String resultado){
        listaRegistro.add(new Registro(resultado));
    }

    public void leerConsultas() {
        for (Registro registro : listaRegistro) {
            System.out.println(registro.consulta());
        }
    }

    record Registro(String consulta) { }
}

