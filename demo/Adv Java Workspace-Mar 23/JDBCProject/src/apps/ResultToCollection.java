package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import entities.Emp;

public class ResultToCollection {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		//2. Establish the connection
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		System.out.println("connection established");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from emp11");
		
		//sorted on salary
		Set<Emp> emps = new TreeSet<>();
		while(rs.next())
		{
			Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),
                            rs.getFloat(6),rs.getInt(8));
			emps.add(e);
		}
		
		rs.close();
		st.close();
		con.close();
		
		for(Emp e : emps)
			System.out.println(e);
		

	}

}





