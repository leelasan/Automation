package CollectionsPackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Interface_Demo {

	public static void main(String[] args) {
		
		set_operations();
	}

	public static void set_operations()
	{
		//with the below statement we imported java.util.set and java.util.HashSet packages
		Set<Object> set= new HashSet<Object>();
		
		set.add("Leela");
		set.add(123);
		set.add('V');
		set.add(null);
		set.add(1.23);
		set.add("Leela");
		set.add(true);
		
		//It eliminates the duplicates in the print console
		//It won't print to console in the same sequence of the values added
		//for each is one method to iterate the values of set
		for(Object s:set)
		{
			System.out.println(s);
		}
		
		//the other process to iterate values is with iterator
		//Iterator interface has no implemented class for iteration, so we take iterator method of Set Interface
		Iterator<Object> itr = set.iterator();
		while(itr.hasNext())
		{
			System.out.println("Iteration through iterator: "+itr.next());
		}
	}
}