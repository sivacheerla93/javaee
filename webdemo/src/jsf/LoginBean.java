package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String username, password, message;

	// Action Controller
	// Return value is page name
	public String login() {
		if (username.equals("admin") && password.equals("admin"))
			return "home";
		else {
			message = "Invalid Login!";
			return "login";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

}