package ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloService {

	@WebMethod
	public String getMessage(@WebParam(name = "name") String name) {
		return "Hello! " + name + "\n" + "Welcome to SOAP web services..";
	}

	@WebMethod
	public Date getCurrentDate() {
		return new Date();
	}
}
