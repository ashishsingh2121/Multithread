package com.example.MultiThread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Importing input output thread class 
import java.io.*; 
//Importing Thread class from java.util package 
import java.util.*; 

public class Dogs extends Thread{

	String dogs;
	
	

	public Dogs(String dogs) {
		this.dogs = dogs;
	}
	
	public Dogs() {
	}



	public String getDogs() {
		return dogs;
	}



	public void setDogs(String dogs) {
		this.dogs = dogs;
	}



	public void run()
	{
		
		try {
			 String url = "jdbc:mysql://localhost:3306/dogs";
			 String username = "root";
			 String password = "Password123!";

			 System.out.println("Connecting database ...");

			 try (Connection connection = DriverManager.getConnection(url, username, password)) {
				 Statement stmt = connection.createStatement();
				 ResultSet rs = stmt.executeQuery("SELECT info from dog");
				 while (rs.next()) {
					    this.dogs = rs.getString("info");
					    setDogs(rs.getString("info"));
					}
			     System.out.println("Database connected!"+dogs);
			 } catch (SQLException e) {
			     throw new IllegalStateException("Cannot connect the database!", e);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
