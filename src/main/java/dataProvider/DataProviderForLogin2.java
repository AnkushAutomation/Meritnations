package dataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

import utility.ExcelHandler;

public class DataProviderForLogin2 {
	
	@DataProvider(name = "Credentials")
	public Object[][] passCredentials() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme","root","urreborns1");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM credentials");
		Object [][] data = new Object[2][3];
		int i = 0;
		while(rs.next()) {
			String userName = rs.getString("userName");
			String email = rs.getString("email");
			String pass = rs.getString("password");
			data[i][0] = userName;
			data[i][1] = email;
			data[i][2] = pass;	
			i++;
		}
		return data;
	}

}
