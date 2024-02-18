package com.example.MultiThread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*; 
import java.io.*;

public class Cats extends Thread {
	
	
	String cat
	;

	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public Cats(String cat) {
		super();
		this.cat = cat;
	}


	@SuppressWarnings("deprecation")
	public void run()
	{
		URL url;
		try {
			url = new URL("http://192.168.1.187:8089/testsvc");
			String query = "";
			URLConnection con = url.openConnection();
			//con.setRequestMethod("GET");
		    //con.setRequestProperty("Content-Type", "application/json");
		      //  con.setRequestProperty("Content-Language", "en-US"); 
		        //con.setInstanceFollowRedirects(true);
		    con.setAllowUserInteraction(false);
			con.setDoOutput(true);
			PrintStream ps = new PrintStream(con.getOutputStream());
			System.out.println(ps.toString());
	        //ps.print(query);
	        ps.close();
	        BufferedReader rd = new BufferedReader(new InputStreamReader(con
	                .getInputStream()));
			    //StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			    	System.out.println(line);
			    	cat= line.toString();
			      //response.append(line);
			      //response.append('\r');
			    }
			    rd.close();
			    //cat= response.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}
