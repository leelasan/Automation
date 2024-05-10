package Introduction;

public class StringMethods {
	public static void main(String[] args) {
	
		String str = "This is the test string";
		int i =0 , j =6;
		System.out.println("Length of the String Str is "+ str.length());
		System.out.println("Character at the Index "+ i + " of the String Str is "+ str.charAt(i));
		System.out.println("Substring of the String Str is "+ str.substring(i,j));
		System.out.println(str.concat(" This is appended string"));
		System.out.println(str.contains("S"));
		System.out.println(str.startsWith("This is"));
		System.out.println(str.startsWith("is"));
		System.out.println(str.endsWith("string"));
		
		String str1 = "Leela", str2 = "Prasad";
		System.out.println("checkng equals as " +str1.equals(str2));
		System.out.println(str.indexOf("q"));
		System.out.println(str.isEmpty());
		System.out.println(str.replace("h",""));
		System.out.println(str.substring(1));
		System.out.println(str.substring(1, 6));
		
		char[] chararray = str.toCharArray();
		for (int k = 0; k<chararray.length; k++) {
			System.out.println("Index" + k + chararray[k]);
		}
		
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
	}
}