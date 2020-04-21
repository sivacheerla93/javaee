package ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.jws.*;
import servlets.DBUtilOracle;

@WebService(serviceName = "EmployeeService")
public class EmployeeService {
	@WebMethod
	public ArrayList<Employee> getEmployees() {
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from employees");
				ResultSet rs = ps.executeQuery();) {

			ArrayList<Employee> el = new ArrayList();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("employee_id"));
				e.setName(rs.getString("first_name"));
				e.setSalary(rs.getDouble("salary"));
				el.add(e);
			}
			return el;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@WebMethod
	public Employee getDetails(@WebParam(name = "empid") String empid) {
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from employees where employee_id=?");) {

			ps.setString(1, empid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("employee_id"));
				e.setName(rs.getString("first_name"));
				e.setSalary(rs.getDouble("salary"));
				rs.close();
				return e;
			} else {
				rs.close();
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}