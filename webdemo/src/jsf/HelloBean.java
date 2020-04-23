package jsf;

import javax.faces.bean.ManagedBean;

//  name helloBean 
@ManagedBean
public class HelloBean {

	// property message
	public String getMessage() {
		return "Hello JSF!";
	}

}