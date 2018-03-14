package com.PostGresUtilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGresqlUtilities {
	public static Connection getDBConnection() {
		//Connection conn = PostGresqlUtilities.connectLoginlinux();
	   Connection conn = PostGresqlUtilities.connectionDBWindows();
	      
	    return conn;
		
	}
	
	//this is for windows office
	public static Connection connectLoginlinux() {
		Connection con = null;
		try {
		      Driver driver = (Driver)
		      Class.forName("org.postgresql.Driver").newInstance();
		      DriverManager.registerDriver(driver);
		      String url = "jdbc:postgresql:firsttest"; 
		      con = DriverManager.getConnection(url, "dodomdos", "dell1234"); 
		      System.out.println("Connected to database firsttest on linux");;

		    } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) { 
		 
		      System.out.println("Exception!"); 
		      System.out.println(e.toString()); 
		      con = null;
		  }
		return con;
	}
	
	//this is for linux
	public static Connection connectionDBWindows() {
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "dell1234");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         //System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return c;
	}
}
