package CollectionsPackage;

import java.util.ArrayList;
import java.util.List;

public class List_Interface_Demo {

	//Here <Integer> is a wrapper class like wise we have Boolean, Character, Byte, Short, Long, Float, and Double
	//With the below statement we made to import java.util.ArrayList and java.util.List packages
	//ArrayList also index based and starts from 0
	//List will store sequence of values
	//Drop down list box implementation in Selenium we need List interface
	//List can contain or store duplicate values
			
	public static void main(String[] args) {
		
		list_operations();

	}

	public static void list_operations()
	{
		
		//create object with List Interface and ArrayList Class
		List<Integer> list = new ArrayList<Integer>();
		
		//adding elements into List
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		list.add(600);
		list.add(700);
		list.add(700);
		list.add(900);
		
		//System.out.println(list.get(0));
		
		//list.remove will remove the value of the list at the specified index
		list.remove(8);

		//using for each method to print the list values to the console
		for(Integer i:list)
		{
			System.out.println(i);
			i++;
		}
		
		//we can use size() method of list to get the size of List and use "for" loop to print to console
		for (int j=0; j<list.size(); j++)
		{
			System.out.println(list.get(j));
		}
		
		List<Integer> Newlist = new ArrayList<Integer>();
		Newlist.add(1);
		Newlist.add(2);
		Newlist.add(3);
		Newlist.add(4);
		Newlist.add(5);
		Newlist.add(6);
		Newlist.add(7);
		Newlist.add(8);
		Newlist.add(9);
		
		//adding "Newlist" values to "list" values at the end
		list.addAll(Newlist);
		
		//printing the list to the console after addAll
		for(Integer i:list)
		{
			System.out.println(i);
			i++;
		}
		
		List<Integer> Clist1 = new ArrayList<Integer>();
		Clist1.add(1);
		Clist1.add(2);
		Clist1.add(3);
		Clist1.add(4);
		Clist1.add(5);
		
		List<Integer> CList2 = new ArrayList<Integer>();
		CList2.add(2);
		CList2.add(1);
		CList2.add(3);
		CList2.add(4);
		CList2.add(5);
		
		//containsAll check whether all the values of one list is present in other list. Sequence may vary.
		System.out.println(CList2.containsAll(Clist1));
		
		//contains checks for a given value is present in the list or not
		System.out.println(CList2.contains(4));
		
		//equals checks if the list1 and list2 are same or not. sequence also should match
		System.out.println(CList2.equals(Clist1));
		
		
	}
	
	
}
