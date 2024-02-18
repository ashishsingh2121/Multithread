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

public class Fish extends Thread{
	
	
	String fish;

	public String getFish() {
		return fish;
	}

	public void setFish(String fish) {
		this.fish = fish;
	}

	public Fish(String fish) {
		super();
		this.fish = fish;
	}
	
	public Fish() {
		super();
	}

	public void run()
	{
			try {
				 String url = "jdbc:mysql://localhost:3306/fishes";
				 String username = "root";
				 String password = "Password123!";

				 System.out.println("Connecting database ...");

				 try (Connection connection = DriverManager.getConnection(url, username, password)) {
					 Statement stmt = connection.createStatement();
					 ResultSet rs = stmt.executeQuery("SELECT info from fish");
					 while (rs.next()) {
						    this.fish = rs.getString("info");
						}
				     System.out.println("Database connected!"+fish);
				 } catch (SQLException e) {
				     throw new IllegalStateException("Cannot connect the database!", e);
				 }
		
	}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
