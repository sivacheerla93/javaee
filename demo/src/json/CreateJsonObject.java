package json;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class CreateJsonObject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("name", "Siva Cheerla");
		builder.add("occupation", "Developer");
		builder.add("company", "Wipro Technologies");

		JsonObject person = builder.build();
		System.out.println(person);

		FileWriter fw = new FileWriter("d:\\person.txt");
		JsonWriter fjw = Json.createWriter(fw);
		fjw.writeObject(person);
		fjw.close();
		fw.close();
	}

}
