package Introduction;

import java.util.regex.Pattern;

public class StringMethods 
{
	public static void main(String[] args) 
	{
	
		//String literal -- String constant pool
		String str = "This is the test string";
		int i =0 , j =6;
		
		//To find length of the string. parenthesis is required for length method.
		System.out.println("Length of the String Str is "+ str.length());
		
		//To find the character value at a given index of the string. index starts from 0
		System.out.println("Character at the Index "+ i + " of the String str is "+ str.charAt(i));
		
		
		//print the substring of the string. arguments are starting position and the count including starting index
		System.out.println("Substring of the String Str is "+ str.substring(i,j));
		
		//Appending one string to other with concatenation method
		System.out.println(str.concat(" This is appended string"));
		
		//Next print statement after concatenation. String is immutable
		System.out.println(str);
		
		//Checks for the specified character availability in a given string. It's case sensitive.
		System.out.println("Is S availavle in str: "+str.contains("S"));
		
		//results true or false bases on the string starting with the given argument
		System.out.println("Is str startsWith This is: "+str.startsWith("This is"));
		
		//results true or false bases on the string starting with the given argument
		System.out.println("Is str startsWith is: "+str.startsWith("is"));
		
		//results true or false bases on the string ending with the given argument
		System.out.println("Is str endsWtith string: "+str.endsWith("string"));
		
		
		String str1 = "Leela", str2 = "Prasad"; String str3 = "Leela";
		
		//Checks whether str1 and str2 are equal or not
		System.out.println("checkng equals as " +str1.equals(str2));
		
		//Check  whether str1 and str2 are equal or not
		System.out.println("compareTo when str1 is smaller and str2 is bigger for str1.compareTo(str2): "+str1.compareTo(str2));
		
		//Check  whether str1 and str2 are equal or not
		System.out.println("compareTo when str2 is bigger and str1 is smaller for str2.compareTo(str1): "+str2.compareTo(str1));
		
		//Check  whether str1 and str2 are equal or not
		System.out.println("compareTo when same Values: "+str1.compareTo(str3));
		
		//provides the index of the given character in the string. returns -1 if not available
		System.out.println("Index of q in str is: "+ str.indexOf("q"));
		
		//provides the index of the given character in the string.
		System.out.println("Index of i in str is: "+ str.indexOf("i"));
				
		//check if the string is empty or not
		System.out.println("Is str isEmpty?: "+str.isEmpty());
		
		//replaces the given characters in the string
		System.out.println("Replacing h with null value :"+str.replace("h",""));
		
		//replace first only one character - first occurrence
		System.out.println("Replacing the first occurance of i with u: "+ str.replaceFirst("i","u"));
		
		//replace first one word - first occurrence
		System.out.println("Replacing the first occurance of i with u: "+ str.replaceFirst("This","Maybe"));
		
		//Returns a string that is a substring of this string. 
		//The substring begins with the character at the specified index and extends to the end of this string.
		System.out.println("substring of 1 starts at index of 1 till end of string :"+str.substring(1));
		
		//Returns a string that is a substring of this string. 
		//The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
		//Thus the length of the substring is endIndex-beginIndex.
		System.out.println("substring starting index 1 and ending index 6 i.e. 6-1 = 5 character from index 1:"+str.substring(1, 6));
		
		//converts string to char array and prints the index number and its values
		char[] chararray = str.toCharArray();
		//length method is available for char array. parentheses are not required 
		for (int k = 0; k<chararray.length; k++) 
			System.out.print("Index[" + k + "]" + chararray[k]+" ");
				
		//Reversing the string after conversion to char array and reverse printing from last index to first
		char[] chararray1 = str.toCharArray();
		for (int k1 = chararray1.length-1; k1>=0; k1--) 
			System.out.print(chararray1[k1]);
				
		//Reversing the string with charAt: Reversing with the looping of index number in reverse
		for (int k2 = str.length()-1; k2>=0; k2--) 
			System.out.print(str.charAt(k2));
		
		//converts string to Lower Case
		System.out.println("\n"+str.toLowerCase());
		
		//converts string to upper case
		System.out.println(str.toUpperCase());
		
		//Convert String to StringBuffer
		//Reverse the string with String Buffer with the direct method of reverse() in StringBuffer Class
		//String Object -- Heap
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
		
		//Changed the value of string str but, you can't modify the existing value as it is mutable
		str = "Leela";
		System.out.println(str);
		
		//add two strings to one string
		String str4 = new String("Leela Prasad");
		String str5 = new String(" Vakati"); 
		String stradd = str4+str5; 
		System.out.println("String added: "+ stradd);
		String str6= "Good";
		String stradd1 = str6+str5; 
		System.out.println(stradd1);
		
		//Trim the leading and trailing spaces
		String str7 = "     Leela Prasad Vakati     ";
		System.out.println("Trim the leading and trailing spaces: " + str7.trim());
		
		String s1="     Leela Prasad Vakati   ";
		
		//LTRIM - ^ mean starting of the line, + mean one or more, \\ is backslash, s mean space
		String ltrim1 = s1.replaceAll("^\\s+","");
		System.out.println(ltrim1);
		
		//RTRIM - $ mean ending of the line, + mean one or more, \\ is backslash, s mean space
		String rtrim = s1.replaceAll("\\s+$","");
		System.out.println(rtrim);
		
		//calling ltrim method declared in this class
		String s2 = "     Leela";
		System.out.println(ltrim(s2));
		
	}
	    //Get to know what is Patterns
		private final static Pattern LTRIM = Pattern.compile("^\\s+");
        
		//Get to know what matcher does
		public static String ltrim(String s2) {
	    return LTRIM.matcher(s2).replaceAll("");
	}
}

