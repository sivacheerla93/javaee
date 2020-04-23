package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class BooksBean {
	private String category = "java", price = "";

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void process(ValueChangeEvent e) {
		category = e.getNewValue().toString();
		price = "";
	}

	public void calculatePrice(ValueChangeEvent e) {
		price = e.getNewValue().toString();
	}
}
