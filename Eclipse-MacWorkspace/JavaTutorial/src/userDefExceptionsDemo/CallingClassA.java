package userDefExceptionsDemo;

public class CallingClassA {

	public static void main(String[] args) throws ClassA {
		CallingClassA cca = new CallingClassA();
		cca.ageCalc(10);
		cca.ageCalc(-1);

	}
	
	public void ageCalc(int age) throws ClassA
	{
		if (age==-1) {
			throw new ClassA("Invalid age exception.....");
			
	}else {
		System.out.println("age is greater than 1");
	}
		
	

	}
}