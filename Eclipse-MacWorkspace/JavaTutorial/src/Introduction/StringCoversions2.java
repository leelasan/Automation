package Introduction;

public class StringCoversions2 {
	
	// Java program to demonstrate conversion from
	// String to StringBuffer and StringBuilder.
	public static void main(String[] args){
		
		StringBuffer sbr = new StringBuffer("Geeks");
	         
	    // conversion from StringBuffer object to String
	    String str = sbr.toString();
	    System.out.println(str);
	         
	    // conversion from StringBuilder object to String
	    String str1 = sbr.toString();
	    System.out.println(str1);
	         
	    // changing StringBuffer object sbr
	    // but String object(str) doesn't change
	    sbr.append("ForGeeks");
	    System.out.println(sbr);
	    System.out.println(str);
	         
	}
}
