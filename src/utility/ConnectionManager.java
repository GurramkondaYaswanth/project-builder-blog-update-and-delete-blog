package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	
	public static Connection getConnection() {
		//establising connection
		Connection con = null;
		 
		try {
		Properties	properties = loadPropertiesFile() ;  //properties
		
		//required properties out of properties object
	    String driver = properties.getProperty("driver");
	    String url = properties.getProperty("url");
	    String username = properties.getProperty("username");
	    String password = properties.getProperty("password");
		//load the driver
		Class.forName(driver);
		//get the connection
		con = DriverManager.getConnection(url, username, password);
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
//		if(con != null)
//			System.out.println("connection established");
		
		return con;
		
	}
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}




