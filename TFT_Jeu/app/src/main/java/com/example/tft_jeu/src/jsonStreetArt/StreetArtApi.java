package com.example.tft_jeu.src.model
import com.example.tft_jeu.src.models.Geocoordinates;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreetArtApi {

    public List<StreetArt> getStreetArt() throws IOException {
        List<StreetArt> streetArts = new ArrayList<StreetArt>();

        FileInputStream fis = new FileInputStream("app/src/main/res/data.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder builder = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        reader.close();
        fis.close();


        Gson gson = new Gson();

        JsonArray array = JsonParser.parseString(builder.toString()).getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            String json = array.get(i).getAsJsonObject().toString();
            StreetArt streetArt = gson.fromJson(json, StreetArt.class);
            System.out.println(streetArt);
            streetArts.add(streetArt);
        }

        return streetArts;
    }
}