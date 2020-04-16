package json;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadJsonObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonReader reader = Json.createReader(new StringReader("{\"qty\" : 20, \"price\" : 1000}"));
		JsonObject sale = reader.readObject();
		System.out.println("Qty : " + sale.getInt("qty"));
		System.out.println("Price : " + sale.getInt("price"));
	}

}
