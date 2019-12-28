package jdbc_oracle;

import java.io.FileWriter;
import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		OracleWebRowSet rs = new OracleWebRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs");
		rs.execute();

		FileWriter fw = new FileWriter("c:\\jobs.xml");
		rs.writeXml(fw);
		rs.close();
	}

}
