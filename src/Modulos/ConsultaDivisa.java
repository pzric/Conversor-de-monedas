package Modulos;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public double buscaDivisa(String divisaOrigen, String divisaDestino){
        String apiKey = " ";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + divisaOrigen;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());

            JsonElement jsonElement = JsonParser.parseString(respuesta.body());
            JsonObject tasasDeConverson = jsonElement.getAsJsonObject().getAsJsonObject("conversion_rates");
            return tasasDeConverson.get(divisaDestino).getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
