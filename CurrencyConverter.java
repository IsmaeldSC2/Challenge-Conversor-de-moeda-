import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha uma das opções abaixo para conversão:");
        System.out.println("1 - Peso argentino para Real");
        System.out.println("2 - Boliviano para Real");
        System.out.println("3 - Real para Dólar");
        System.out.println("4 - Peso chileno para Real");
        System.out.println("5 - Peso colombiano para Real");
        System.out.println("6 - Dólar para Real");

        System.out.print("Digite a opção desejada: ");
        int option = scanner.nextInt();

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        // Definir as moedas com base na escolha do usuário
        String fromCurrency = "";
        String toCurrency = "BRL"; // Conversões para Real

        switch (option) {
            case 1 -> fromCurrency = "ARS";
            case 2 -> fromCurrency = "BOB";
            case 3 -> {
                fromCurrency = "BRL";
                toCurrency = "USD";
            }
            case 4 -> fromCurrency = "CLP";
            case 5 -> fromCurrency = "COP";
            case 6 -> fromCurrency = "USD";
            default -> {
                System.out.println("Opção inválida. Encerrando o programa.");
                return;
            }
        }

        // Obter taxa de câmbio e realizar conversão
        try {
            double rate = fetchExchangeRate(client, fromCurrency, toCurrency);
            double convertedAmount = amount * rate;

            System.out.printf("%.2f %s equivale a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão: " + e.getMessage());
        }
    }

    // Método para obter a taxa de câmbio da API
    private static double fetchExchangeRate(HttpClient client, String fromCurrency, String toCurrency) throws Exception {
        String apiKey = "ba13edf1905fb02f66f341de";
        String urlString = String.format("https://api.exchangerate-api.com/v4/latest/%s", fromCurrency);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: Código " + response.statusCode());
        }

        // Parse JSON usando GSON
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("rates");

        return rates.get(toCurrency).getAsDouble();
    }
}

