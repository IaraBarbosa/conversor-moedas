package projeto.conversor.clients;

import projeto.conversor.entities.MoedaExchangeRateAPI;
import projeto.conversor.parser.InternalJsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class ExchangeRateAPIClient {

    public InternalJsonParser internalJsonParser = new InternalJsonParser();
    private String pairConversionURL = "https://v6.exchangerate-api.com/v6/96c88d179f0d37a324d081db/pair/";

     public MoedaExchangeRateAPI pairConversionCall(String moeda1, String moeda2, double amount) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(pairConversionURL + moeda1 + "/" + moeda2 + "/" + String.format(Locale.US, "%.2f", amount)))
                    .build();

            return internalJsonParser.convertResponseToJson(client
                    .send(request, HttpResponse.BodyHandlers.ofString()));

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
     }
}
