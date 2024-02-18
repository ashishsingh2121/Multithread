package com.example.MultiThread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallAnimal {
// This is the controller class
	@GetMapping("/animals")
	public String getCat() throws InterruptedException
	{
		String animal="animals";
		
		Cats ct= new Cats("Black cat");
		Dogs dg= new Dogs();
		Fish fs= new Fish();
		ct.start();
		dg.start();
		fs.start();
		TimeUnit.SECONDS.sleep(30);
		animal=ct.getCat()+dg.getDogs()+fs.getFish();
		System.out.println("Output: "+dg.getDogs()+fs.getFish());
		
		return animal;
	}
	
}
