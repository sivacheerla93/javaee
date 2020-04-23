package jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {
	private String uname, password, message;

	@Size(min = 4, max = 10, message = "Username must be 4 to 10 chars")
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Size(min = 1, message = "Password is required!")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String login() {
		if (uname.equals("admin") && password.equals("admin")) {
			return "home";
		} else {
			message = "Sorry! Invalid Login!";
			return "login2";
		}
	}

}
