import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Conversor {
    private String url = "https://v6.exchangerate-api.com/v6/b456f145367511ea9878e17c/pair/";
    private String[] pairConversion = new String[2];
    private float amount = 0;
    private float badge = 0;

    public Conversor(String[] pairConversion, float amount) {
        this.pairConversion = pairConversion;
        this.amount = amount;
    }

    Gson gson = new GsonBuilder().create();

    public void obtenerDivisa() {
        String stringPairConversion = pairConversion[0] + "/" + pairConversion[1];
        url += stringPairConversion;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ConversionRate conversionRate = gson.fromJson(json, ConversionRate.class);
            String valueConversionRate = conversionRate.conversion_rate();
            badge = amount * Float.parseFloat(valueConversionRate);
            String badgeMsg = "\nEl valor " + amount + " [" + pairConversion[0] + "]"
                    + " corresponde al valor final de ==> " + badge + " [" + pairConversion[1] + "]";
            System.out.println(badgeMsg);
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado.");
        }
    }
}
