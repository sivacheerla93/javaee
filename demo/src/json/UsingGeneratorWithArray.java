package json;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class UsingGeneratorWithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartObject().write("name", "Siva Cheerla").write("mobile", "1234").writeStartArray("emails")
				.write("test@email.com").write("test2@email.com").writeEnd().writeEnd();

		gen.close();
		System.out.println(sw.toString());
	}

}
