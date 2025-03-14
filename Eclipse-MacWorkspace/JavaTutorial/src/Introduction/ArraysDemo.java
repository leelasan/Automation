package Introduction;
import java.util.*;

public class ArraysDemo {
	
	public static void main(String[] args) {
		
		int[] myIntArray1 = {100, 90};
		
		char[] charArray= {'a','b','c'};
		
		System.out.println("0 index: " + charArray[0]);
		System.out.println("1st index: " + charArray[1]);
		System.out.println("2nd index: " + charArray[2]);
		
		int[] myIntArray5 = new int[2];
		
		myIntArray5[0] = 100;
		myIntArray5[1] = 90;
		
		Object[] obj = {10,"Leela", 'L'};
		
		System.out.println("0 index: " + obj[0]);
		System.out.println("1st index: " + obj[1]);
		System.out.println("2nd index: " + obj[2]);
		
		
		System.out.println("0 index: " + myIntArray1[0]);
		System.out.println("1st index: " + myIntArray1[1]);
		//System.out.println("2nd index: " + myIntArray1[2]);
		
		String[] myStringArray1 = {"bmw", "audi", "honda"};
		System.out.println("0 index: " + myStringArray1[0]);
		System.out.println("1st index: " + myStringArray1[1]);
		System.out.println("2nd index: " + myStringArray1[2]);
		
		int len1 = myIntArray1.length;
		int len2 = myStringArray1.length;
		
		System.out.println("Int array length: " + len1);
		System.out.println("String array length: " + len2);
		
		for (int i = 0; i < len1; i++){
			System.out.println(myIntArray1[i]);
		}
		
		//method to sort the values within the array
		Arrays.sort(myIntArray1);
		
		for (int i = 0; i < len1; i++){
			System.out.println(myIntArray1[i]);
		}
		
		//System.arraycopy(src, srcPos, dest, destPos, length);
		
		String str= "Leela Prasad Vakati";
		String[] splitStr = str.split(" ");
		
		System.out.println(splitStr[0]);
		System.out.println(splitStr[1]);
		System.out.println(splitStr[2]);
		
		//Integer is a wrapper class
		Integer in = new Integer(1);
		System.out.println(in);
		
		
	}

}
