package pl.smart4aviation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class containing the main method of the application. This is the starting point when
 * the application is run.
 * 
 * @author Pankaj Singh Nirmal
 */

@SpringBootApplication
public class Smart4AviationWebAppApplication 
{
	/**
	 * Main method of the application. This is the starting point when
	 * the application is run.
	 * 
	 * @param args used for passing arguments at run time
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(Smart4AviationWebAppApplication.class, args);
	}

}
