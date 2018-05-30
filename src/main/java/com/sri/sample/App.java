package com.sri.sample;

import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        File file= new File("C://Temp//sample.txt");
        try {
			if(file.createNewFile())
			{
				System.out.println("file Created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FileWriter f = new FileWriter(file);
        f.write("Hello World");
        f.close();
        
    }
}
