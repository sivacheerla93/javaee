package ws;

public class EmpClient {

	public static void main(String[] args) throws Exception {

		EmployeeServiceProxy proxy = new EmployeeServiceProxy();
		Employee e = proxy.getDetails("100");
		System.out.println(e.getName());

		Employee[] el = proxy.getEmployees();

		for (Employee emp : el)
			System.out.println(emp.getId() + " : " + emp.getName() + " : " + emp.getSalary());
	}

}