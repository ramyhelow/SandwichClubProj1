package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;

        try {
            JSONObject sandwichRoot = new JSONObject(json);
            JSONObject sandwichName = sandwichRoot.getJSONObject("name");

            String sandwichMainName = sandwichName.getString("mainName");

            JSONArray sandwichAKA = sandwichName.getJSONArray("alsoKnownAs");
            List<String> sandwichAKAArrayList = new ArrayList<>();
            for (int i=0; i<sandwichAKA.length(); i++){
                sandwichAKAArrayList.add(sandwichAKA.getString(i));
            }

            String sandwichPlaceOfOrigin = sandwichRoot.getString("placeOfOrigin");

            String sandwichDescription = sandwichRoot.getString("description");

            String sandwichImage = sandwichRoot.getString("image");

            JSONArray sandwichIngredients = sandwichRoot.getJSONArray("ingredients");
            List<String> sandwichIngredientsArrayList = new ArrayList<>();
            for (int i=0; i<sandwichIngredients.length(); i++){
                sandwichIngredientsArrayList.add(sandwichIngredients.getString(i));
            }

            sandwich = new Sandwich(sandwichMainName, sandwichAKAArrayList, sandwichPlaceOfOrigin, sandwichDescription, sandwichImage, sandwichIngredientsArrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
