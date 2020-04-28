package jsf;

import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "directoryBean")
@RequestScoped
public class DirectoryBean {
	private TreeMap<String, String> directory = new TreeMap<String, String>();
	private String name, phone, email;

	public DirectoryBean() {
		directory.put("Resig", "9000099999:resig@yahoo.com");
		directory.put("John", "9000011111:john@yahoo.com");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void search(ActionEvent evt) {
		String details = directory.get(name);
		if (details == null) {
			phone = "Sorry! Name not found";
			email = "";
		} else {
			String parts[] = details.split(":");
			phone = parts[0];
			email = parts[1];
		}
	}

}
