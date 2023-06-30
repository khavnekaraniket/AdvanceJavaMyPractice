package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableUpdatableDemo {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		//2. Establish the connection
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		System.out.println("connection established");
		
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		//scollable, updatable
		ResultSet rs = st.executeQuery("select * from emp11");
		//records in reverse
		rs.afterLast();
		while(rs.previous())
			System.out.println(rs.getInt(1));
		
		rs.absolute(8);
		System.out.println("emp at 8 th : "+rs.getInt(1));
		rs.relative(-1);
		System.out.println("emp 1 behind : "+rs.getInt(1));
		
		
		rs.updateFloat(6, 3333.00f);
		rs.updateRow();
		System.out.println("record updated");

		rs.close();
		st.close();
		con.close();
	}

}






