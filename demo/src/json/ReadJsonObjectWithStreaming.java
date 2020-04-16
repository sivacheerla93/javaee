package json;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class ReadJsonObjectWithStreaming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonParser parser = Json.createParser(new StringReader("{\"qty\" : 20, \"price\" : 1000}"));
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next();
			switch (event) {
			case KEY_NAME:
				System.out.println(parser.getString() + " : ");
				break;
			case VALUE_NUMBER:
				System.out.println(parser.getInt());
				break;
			}
		}
	}

}
