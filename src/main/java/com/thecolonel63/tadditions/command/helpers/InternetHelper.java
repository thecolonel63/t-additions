package com.thecolonel63.tadditions.command.helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class InternetHelper {

    public static JsonObject getJsonFromUrl(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try (InputStream inputStream = entity.getContent()) {
                String string = new String(inputStream.readAllBytes());
                return JsonParser.parseString(string).getAsJsonObject();
            }
        }
        return null;
    }

    public static String getHTTPResponse(String urlToRead) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public static String decodeBase64(String b64) {
        byte[] decodedBytes = Base64.getDecoder().decode(b64);
        return new String(decodedBytes);
    }

    public static String encodeBase64(String raw) {
        byte[] encodedBytes = Base64.getEncoder().encode(raw.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes);
    }

    public static JsonObject getProfileFromName(String name) throws IOException {
        return JsonParser.parseString(getHTTPResponse("https://sessionserver.mojang.com/session/minecraft/profile/" + JsonParser.parseString(getHTTPResponse("https://api.mojang.com/users/profiles/minecraft/" + name)).getAsJsonObject().get("id").getAsString())).getAsJsonObject();
    }

    public static String getPlayerSkullFromUrl(String url) {
        String b64 = encodeBase64("{\"textures\":{\"SKIN\":{\"url\":\""+url+"\"}}}");
        return "/give @p minecraft:player_head{SkullOwner:{Id:[I;0,0,0,0],Properties:{textures:[{Value:\""+b64+"\"}]}}} 1";
    }

    public static String capeUrl(String name) throws IOException {
        String b64 = getProfileFromName(name).get("properties").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString();
        JsonObject profile = JsonParser.parseString(decodeBase64(b64)).getAsJsonObject();
        boolean hasCape = profile.get("textures").getAsJsonObject().has("CAPE");
        if (!hasCape) return "NONE";
        return profile.get("textures").getAsJsonObject().get("CAPE").getAsJsonObject().get("url").getAsString();
    }





}

