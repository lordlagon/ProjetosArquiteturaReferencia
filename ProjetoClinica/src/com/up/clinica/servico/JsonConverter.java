package com.up.clinica.servico;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.up.clinica.model.Animal;

public class JsonConverter {

	private final Gson gson;

	public JsonConverter() {
		gson = new GsonBuilder().create();
	}
	public String convertToJson(Animal animal) {
		 JsonObject jsonObject = new JsonObject();
		 jsonObject.add("animal", gson.toJsonTree(animal));
		 return jsonObject.toString();
		 }
	
	public String convertToJson(List<Animal> animais) {
		JsonArray jarray = gson.toJsonTree(animais).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("animais", jarray);
		return jsonObject.toString();
	}
}