package projeto.conversor.parser;

import com.google.gson.Gson;
import projeto.conversor.entities.MoedaExchangeRateAPI;

import java.net.http.HttpResponse;

public class InternalJsonParser {

    public MoedaExchangeRateAPI convertResponseToJson(HttpResponse<String> response) {
        if (response == null || response.body() == null) {
            return null;
        }

        Gson gson = new Gson();
        return gson.fromJson(response.body(), MoedaExchangeRateAPI.class);
    }
}
