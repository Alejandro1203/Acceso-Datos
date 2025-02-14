package com.iesbelen.dam.acdat.spring.examen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static int menu() {
            int opcion;

            System.out.println("""
                    1. Consultar
                    2. Guardar
                    3. Eliminar
                    4. Actualizar
                    5. Salir""");

            opcion = fileManager.ScannerEntry.pedirEntero("Elija una opción: ");

            return opcion;
        }

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();

            switch (opcion) {
                case 1 -> GetRequest();
                case 2 -> PostRequest();
                case 3 -> DeleteRequest("7499");
                case 4 -> UpdateRequest("1234");
            }
        } while(opcion < 1 || opcion > 5);
    }

    public static void GetRequest() {
        HttpURLConnection con = null;

        try {
            URL url = new URL("http://localhost:8080/" + "api-rest/departamentos");

            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept", "application/json");

            if(con.getResponseCode() == 200) {
                Scanner sc = new Scanner(con.getInputStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();

                JSONArray jsonArray = new JSONArray(response);

                for (int index = 0; index < jsonArray.length(); index++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(index);

                    System.out.println(jsonObject.getString("id") + ": " + jsonObject.getString("nombre"));
                }

            } else {
                System.out.println("Error: " + con.getResponseCode());
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static void PostRequest() {
        HttpURLConnection con = null;
        try {
            String jsonInputString = new JSONObject()
                    .put("id", 1234)
                    .put("nombre", "Francisco")
                    .put("puesto", "Dependiente")
                    .put("departamento", new JSONObject()
                            .put("id", 20)
                            .put("nombre", "Marketing")
                            .put("ubicacion", "Barcelona")
                            .toString()).toString();

            URL url = new URL("http://localhost:8080/api-rest/empleados");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (con.getResponseCode() == 200) {
                System.out.println("Empleado insertado");
            } else {
                System.out.println("Error: " + con.getResponseCode());

                Scanner sc = new Scanner(con.getErrorStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();

                JSONObject jsonObject = new JSONObject(response)
                        .getJSONArray("errors")
                        .getJSONObject(0) ;

                System.out.println(jsonObject.getString("message"));
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static void DeleteRequest(String codeDelete) {
        HttpURLConnection con = null;

        try {
            URL url = new URL("http://localhost:8080/api-rest/empleados/" + codeDelete);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            if (con.getResponseCode() == 200) {
                System.out.println("Empleado eliminado");
            } else {
                System.out.println("Error: " + con.getResponseCode());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static void UpdateRequest(String codeUpdate) {
        HttpURLConnection con = null;

        try {
            String jsonInputString = new JSONObject()
                    .put("id", codeUpdate)
                    .put("nombre", "El Dios")
                    .put("puesto", "Dependiente")
                    .put("departamento", new JSONObject()
                            .put("id", 20)
                            .put("nombre", "Marketing")
                            .put("ubicacion", "Barcelona")
                            .toString()).toString();

            URL url = new URL("http://localhost:8080/api-rest/empleados/" + codeUpdate);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            if (con.getResponseCode() == 200) {
                System.out.println("Empleado insertado");
            } else {
                System.out.println("Error: " + con.getResponseCode());

                Scanner sc = new Scanner(con.getErrorStream());
                String response = sc.useDelimiter("\\Z").next();
                sc.close();

                JSONObject jsonObject = new JSONObject(response)
                        .getJSONArray("errors")
                        .getJSONObject(0) ;

                System.out.println(jsonObject.getString("message"));
            }


        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}