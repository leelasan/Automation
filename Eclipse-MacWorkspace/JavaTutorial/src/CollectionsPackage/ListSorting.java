package CollectionsPackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ListSorting {

	public static void main(String[] args) {
		List_Sorting();
	}

	public static void List_Sorting()
	{
		//Declaration of List argument
		List<String> str1 = new ArrayList<String>();
		
		str1.add("Vakati");
		str1.add("Leela");
		str1.add("Prasad");
		
		for(String s:str1)
		{
			System.out.println("Before Sorting: "+s);
		}
		
		//The below statement just sort the List values with the help of collections class
		Collections.sort(str1);
		
		for(String s:str1)
		{
			System.out.println("After Sorting: "+s);
		}
	}
}
