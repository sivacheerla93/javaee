package json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateBookByAPI {

	public static void main(String[] args) {

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("title", "jQuery in action");
		builder.add("price", 500);
		JsonObject object = builder.build();
		System.out.println(object);

	}

}