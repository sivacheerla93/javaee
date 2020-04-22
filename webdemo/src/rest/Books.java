package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/books")
public class Books {
	List<Book> books = new ArrayList<>();

	public Books() {
		books.add(new Book("C Language For Beginners", 99));
		books.add(new Book("Oracle Database 12c for Beginners", 149));
		books.add(new Book("Java SE Course Material", 149));
		books.add(new Book("Java EE Course Material", 149));
	}

	@GET
	@Produces("application/json")
	public String getBooks() {
		return new Gson().toJson(books);
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getOneBook(@PathParam("id") int id) {
		return new Gson().toJson(books.get(id));
	}
}
