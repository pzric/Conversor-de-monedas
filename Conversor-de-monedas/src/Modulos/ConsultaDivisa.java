package Modulos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public String buscaDivisa(String divisaOrigen){
        String direccion = "https://v6.exchangerate-api.com/v6/da76ca1e9689ed36f4618983/latest/" + divisaOrigen;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            return respuesta.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
