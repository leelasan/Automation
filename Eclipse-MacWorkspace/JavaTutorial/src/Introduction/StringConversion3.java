package Introduction;

	//Java program to demonstrate conversion from
	// StringBuffer to String and then StringBuilder.
public class StringConversion3 {
	
    public static void main(String[] args)
    {
        StringBuffer sbr = new StringBuffer("Geeks");
         
        // conversion from StringBuffer object to StringBuilder
        String str = sbr.toString();
        StringBuilder sbl = new StringBuilder(str);
         
        System.out.println(sbl.append("forgeeks"));
        System.out.println(str); 
    }
}
