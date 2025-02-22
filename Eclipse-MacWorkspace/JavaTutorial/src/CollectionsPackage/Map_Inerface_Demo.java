package CollectionsPackage;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Map_Inerface_Demo {

	public static void main(String[] args) {
		
		//map_key_value_operations();
		//map_samekey_diffval_operations();
		//map_diffkey_nullanddupvalue();
		//map_diffkey_diffva();
		//map_getkey_getval();
		//map_sort_check();
		map_iterator();
	}
	
	//Map Interface and implementing classes are HashMap, HashTable...
	//Map consists Key Value pairs
	//Map sorts on key value. Value data don't get sorted
	
	public static void map_key_value_operations()
	{
		//declaration
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1,"Leela");
		map.put(2, "Prasad");
		map.put(3, "Vakati");
		
		//Map index starts from 1 whereas Arrays, List and Set starts with 0
		//I did not given braces for "for" loop, but it executed only the first statement with the help of for loop till the condition is met
		//and then went to the next statement
		
		for(int i=1; i<=map.size(); i++)
			System.out.println(map.get(i));
			
		System.out.println("**************");
		
		//Output
		//Leela
		//Prasad
		//Vakati
		//**************
		
	}
	
	public static void map_samekey_diffval_operations()
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1,"AP");
		map.put(1,"TS");
		map.put(1,"TN");
		
		map.put(2,"PA");
		map.put(2,"GA");
		map.put(2,"NJ");
		
		//Same/duplicate key will override the previous value and print the last key value pair
		for (int i=1; i<=map.size(); i++)
		{
			System.out.println("Keys are same so, first two are ovverriden "+map.get(i));
		}
		
		//Output
		//Keys are same so, first two are ovverriden TN
		//Keys are same so, first two are ovverriden NJ
	}
	
	public static void map_diffkey_nullanddupvalue()
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// accepts null and duplicate values
		map.put(1,"Leela");
		map.put(2,null);
		map.put(3,"Leela");
		
		for (int i=1;i<=map.size();i++)
			System.out.println(map.get(i));
		
		//output
		//Leela
		//null
		//Leela
	}
	
	public static void map_diffkey_diffva()
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// accepts null and duplicate values
		map.put(0,"Leela");  // loop we started with key value 1. So, output is null
		map.put(2,null);     // actual value for the key value 2 is null printed to console
		map.put(55,"Leela"); // for key value 3 in the loop, there is no value. So output will be null
		
		for (int i=1;i<=map.size();i++)
			System.out.println(map.get(i));
		
		System.out.println(map.get(55)); // output will be leela
		//meaning that, we have to pass the data of the key to get the value of that pair

		
	}
	
	public static void map_getkey_getval()
	{
		Map<Integer, String> map = new HashMap<Integer,String>();
		
		map.put(123,"AP");
		map.put(234,"TS");
		map.put(345,"TN");
		map.put(456,"PA");
		map.put(567,"GA");
		map.put(678,"NJ");
		
		//we are using for each so all values get iterated
		//print all keys
		//we are not providing key data to get the value data
		for (Object key:map.keySet())
			System.out.println(key);
			
		//print all values
		for (Object val:map.values())
			System.out.println(val);
			
		}
	
	public static void map_sort_check()
	{
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("A","AP");
		map.put("C","TS");
		map.put("B","TN");
		map.put("F","PA");
		map.put("D","GA");
		map.put("E","NJ");
		
		//we are using for each so all values get iterated
		//print all keys
		//we are not providing key data to get the value data
		for (Object key:map.keySet())
			System.out.println(key);
			
		//print all values
		for (Object val:map.values())
			System.out.println(val);
			
		}
	
	public static void map_iterator()
	{
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("A","AP");
		map.put("C","TS");
		map.put("B","TN");
		map.put("F","PA");
		map.put("D","GA");
		map.put("E","NJ");
		
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		Iterator itr1 = map.values().iterator();
		while(itr1.hasNext())
			System.out.println(itr1.next());
			
		}
	
		
}
