package json.gson;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CreateProduct {

	public static void main(String[] args) {
		Product p = new Product(1, "Abc", 5000);

		Gson gson = new Gson();
		System.out.println(gson.toJson(p));

		ArrayList<Product> prods = new ArrayList<>();
		prods.add(new Product(1, "iPhone7", 60000));
		prods.add(new Product(2, "Dell Laptop", 50000));
		prods.add(new Product(3, "Google Pixel", 55000));

		System.out.println(gson.toJson(prods));

	}

}