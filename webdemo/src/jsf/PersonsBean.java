package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PersonsBean {
	public List<Person> getPersons() {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person("Mr. John Resig", 32));
		persons.add(new Person("Mr. Joe Stanger", 42));
		persons.add(new Person("Mr. Scott Mitchell", 38));
		persons.add(new Person("Mr. Rod Johnson", 41));
		return persons;
	}
}
