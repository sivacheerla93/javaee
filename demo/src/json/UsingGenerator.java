package json;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class UsingGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		JsonGenerator gen = Json.createGenerator(sw);

		gen.writeStartObject().write("name", "Siva Cheerla").write("email", "test@email.com").write("mobile", "1234")
				.writeEnd();

		gen.close();
		System.out.println(sw.toString());
	}

}
