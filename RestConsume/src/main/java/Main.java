import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GetRequest();
    }

    public static void GetRequest() {
        HttpURLConnection connection = null;

        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");

            if(connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(connection.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();

                System.out.println(response);
                JSONArray jsonArray = new JSONArray(response);

                for (int indice = 0; indice < jsonArray.length(); indice++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(indice);

                    System.out.println(jsonObject.getString("id"));
                }
            } else {
                System.out.println("Falló");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
