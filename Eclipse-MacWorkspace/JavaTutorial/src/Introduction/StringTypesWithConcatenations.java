package Introduction;

public class StringTypesWithConcatenations {
	
		
		public static void main(String[] args) {
			
			String s1 = "Leela";
			concat1(s1);
			System.out.println("String value out of scope of concat method: "+ s1);
			
			s1 = s1+" Prasad Vakati";
			System.out.println("String value within scope of main method where string is declared and modified: "+ s1);

			StringBuilder s2 = new StringBuilder("Leela");
			concat2(s2);
			System.out.println("StrinBuilder: "+s2);
			
			StringBuffer s3 = new StringBuffer("Leela");
			concat2(s3);
			System.out.println("StrinBuffer: "+s3);
			
		}
			
		//Concatenates to String
		public static void concat1(String s1) {
			s1 = s1+" Prasad Vakati";
			System.out.println("String value within scope of concat method: "+ s1);

		}
		
		//Concatenates to String Builder
		public static void concat2(StringBuilder s2) {
			s2.append(" Prasad Vakati");
		}
		
		//Concatenates to String Buffer
		public static void concat2(StringBuffer s3) {
			s3.append(" Prasad Vakati");
		}
				
}
