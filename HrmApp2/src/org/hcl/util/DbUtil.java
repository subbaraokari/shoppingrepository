package org.hcl.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.hcl.model.DataSource;

public class DbUtil {
	public static Connection getConnection(String driver,String url,String userName,String password)
	{
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static DataSource getDataSource() {
		DataSource ds=null;
		try {
			Properties properties=new Properties();
			FileInputStream fis=new FileInputStream("E:\\spring projects\\HrmApp2\\resources\\database.properties");
			properties.load(fis);
			ds=new DataSource();
			ds.setDriver(properties.getProperty("driver"));
			ds.setUrl(properties.getProperty("url"));
			ds.setUsername(properties.getProperty("username"));
			ds.setPassword(properties.getProperty("password"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
