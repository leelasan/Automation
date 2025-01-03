package RunTime_Exception_handling;

public class Exception_Handling_Methods extends ClassA_Inheri_ExceH{
	
	//assigning the reference to a class here but not creating the object and calling it's method to create null pointer exception
	public static Calling_ClassforExceptionHandling ccref;
	
	//declared str as string and getting it's length in a method without instantiation. Thus provides null pointer exception
	public static String str;

	public static void main(String args[]) 
	{
		method1();
		arithmetic_exce1();
		arithmetic_exce2();
		array_ind_outof_bound_exce();
		string_length();
		method2();
		
		//The method called from super class have exception built in it. 
		//So, if we execute, the execution stops here as the exception is not handled in the method.
		//ClassA_Inheri_ExceH obj1 = new ClassA_Inheri_ExceH();
		//obj1.testmethod();
		
		//testmethod() is overridden in this class. So, exception in super class for this method is also nullified.
		Exception_Handling_Methods obj = new Exception_Handling_Methods();
		obj.testmethod();
		
		//If the below statement for object creation is open, then you don't get null pointer exception
		//ccref = new Calling_ClassforExceptionHandling();
		
		//you get null pointer exception because the reference is not an class object.
		ccref.test1();
	}

	//if you don't handle the exception, the statements fall after your exception will not get executed.
	//Throwable is a super class which absorbs all the Errors and Exception.
	//To further narrow down to handle the exceptions, you can use the subclass of Exception. 
		//for example: "ArithmeticException" instead of "Exception" or "Throwable"
	//In a sequence, If you catch ArithmeticException, execution will not go further to Exception or to further Throwable to catch.
	//In a sequence, If you catch exception with Throwable, execution will not go further as Throwable absorbs all exceptions.

	public static void method1()
	{
		try {
				System.out.println("Executing Method1...");
			}catch(Throwable e) {};
	
	}

	public static void arithmetic_exce1() 
	{
		try {
				int i = 100 / 0;
				System.out.println(i);
			}catch(Exception e) 
			{
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}
	//This is same as above method, but the execution stopped at line where ArithmeticException is handled and did not went further.
	public static void arithmetic_exce2() 
	{
		try {
				int i = 100 / 0;
				System.out.println(i);
			}catch(ArithmeticException e) 
			{
				e.printStackTrace();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
	}
	
	public static void array_ind_outof_bound_exce() 
	{
		try {
			
			int[] arrInt = {1,2,3};
			System.out.println(arrInt[5]);
			
		}catch(ArrayIndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
		

	}
	
	public static void string_length()
	{
		try {
				System.out.println(str.length());
			}catch (NullPointerException e) {
			e.printStackTrace();

		}
	}

	public static void method2()
	{
		try {
				System.out.println("Executing Method2...");
			}catch(Exception e) {}
	}
	
	public void testmethod()
	{
		System.out.println("This is overriden method...");
	}
}