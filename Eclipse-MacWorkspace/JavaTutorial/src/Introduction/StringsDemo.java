package Introduction;

public class StringsDemo {

	public static void main(String[] args) {
		//String literal -- String constant pool
		String str1 = "Hello";
		
		String str3 = "Hello";
		System.out.println("String 1: "+ str1 + "\nString 3: "+ str3);
		//String Object -- Heap
		String str2 = new String("Welcome");
		
		String str4 = new String("Welcome");
		System.out.println("String 2: "+ str2 + "\nString 4: "+ str4);
		//Strings
		str1 = "More Hello ";
		String stradd = str1+str2; 
		System.out.println("String added: "+ stradd);

	}

}
