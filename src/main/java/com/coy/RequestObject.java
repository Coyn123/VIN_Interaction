package com.coy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestObject {

    String requestAVin(String vin) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(5))
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues/" + vin + "?format=json"))
                    //Govt API needs time, lowering this may cause false-negative timeouts
                    .timeout(Duration.ofSeconds(60))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            if (e instanceof HttpConnectTimeoutException) {
                System.err.println("Connection timed out:" + e);
            } else {
                System.err.println("Exception: " + e);
            }
            return null;
        }
    }
    String sanitize(String vin) {
        final String cleaned = vin.toUpperCase().trim();
        if (cleaned.length() != 17) {
            System.err.print("Invalid VIN length");
            return null;
        }
        if (cleaned.contains("I") || cleaned.contains("O") || cleaned.contains("Q")) {
            System.err.print("Invalid VIN - blacklisted character(s) present");
            return null;
        }
        final char c = cleaned.charAt(8);
        if (!((c >= '0' && c <= '9') || c == 'X')) {
            System.err.print("Invalid check digit");
            return null;
        }
        return cleaned;
    }
}