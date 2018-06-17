package com.up.clinica.servico;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonConverter {

	private final Gson gson;

	public JsonConverter() {
		gson = new GsonBuilder().create();
	}
	public <T> String convertToJson(List<T> t,String key) {
		JsonArray jarray = gson.toJsonTree(t).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add(key, jarray);
		return jsonObject.toString();
	}
//	public String convertToJson(List<Animal> animais) {
//		JsonArray jarray = gson.toJsonTree(animais).getAsJsonArray();
//		JsonObject jsonObject = new JsonObject();
//		jsonObject.add("animais", jarray);
//		return jsonObject.toString();
//	}
}
