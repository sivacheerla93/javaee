package jsf;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class WishBean {
	private String name, message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String wish() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		message = name + ", ";

		if (hour < 12) {
			message += "Good Morning";
		} else if (hour < 17) {
			message += "Good Afternoon";
		} else {
			message += "Good Evening";
		}

		return null;
	}
}
