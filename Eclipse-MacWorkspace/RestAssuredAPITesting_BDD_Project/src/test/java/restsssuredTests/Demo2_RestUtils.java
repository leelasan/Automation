package restsssuredTests;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Demo2_RestUtils {

	public static String getName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		//System.out.println("Apple MacBook Pro " + generatedString);
		return ("Apple MacBook Pro " + generatedString);		
	}
	
	public static int getYear()
	{
		Random rnd = new Random();
		int start = 2000;
		int end = 2024;
		int res = rnd.nextInt(end - start)+start;
		//System.out.println(res);
		return res;
	}
	
	/* In case the numerics also received as string, then we can use the below method
	public static String getYear()
	{
		String year = RandomStringUtils.randomNumeric(4);
		return year;
	}*/
	
	public static double getPrice()
	{
		Random r = new Random();
		float min = 1000.00f;
		float max = 1500.00f;
		float price = r.nextFloat()*(max-min)+min;
		//System.out.println(((Math.floor(price*100))/100));
		return (((Math.floor(price*100))/100));
	}
	
	public static String getModel()
	{
		Random rnd = new Random();
		int start = 1;
		int end = 10;
		int res = rnd.nextInt(end - start)+start;
		//System.out.println("Intel Core i"+ res);
		return ("Intel Core i"+ res);
	}
	
	public static String getSize()
	{
		Random rnd = new Random();
		int start = 1;
		int end = 10;
		int res = rnd.nextInt(end - start)+start;
		//System.out.println(res+"TB");
		return (res+"TB");
	}	
}