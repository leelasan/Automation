package SuperClassDemo;

public class ClassC_GChild extends ClassB_Child{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassC_GChild ref = new ClassC_GChild();
		ref.displayNum();
		

	}
	
	public void displayNum()
	{
		super.displayNum();
		System.out.println("This is from Class C");
	}


}
