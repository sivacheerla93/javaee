package json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateFullBook {

	public static void main(String[] args) {

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("title", "jQuery in action"); // simple property
		builder.add("price", 500);

		JsonArrayBuilder chapters = Json.createArrayBuilder();
		chapters.add("Introduction");
		chapters.add("Selectors");
		chapters.add("Ajax");
		JsonArray chpts = chapters.build();

		builder.add("chapters", chpts); // array

		JsonObject object = builder.build();
		System.out.println(object);

	}

}