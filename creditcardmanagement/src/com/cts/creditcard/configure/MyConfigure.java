package com.cts.creditcard.configure;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class MyConfigure {
	public static Connection getConnection() {
        Properties props = new Properties();
        //FileInputStream fis = null;
        Connection con = null;
        try {
          //  fis = new FileInputStream("src/db.properties");
             
             
             InputStream fis = MyConfigure.class.getClassLoader().getResourceAsStream("/db.properties");
            props.load(fis);
            
            Class.forName(props.getProperty("JDBC.driver"));

   
            con = DriverManager.getConnection(props.getProperty("JDBC.url"),
                      props.getProperty("JDBC.username"),
                      props.getProperty("JDBC.password"));
   //   } catch (IOException | ClassNotFoundException | SQLException e) {
        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
   }
}
