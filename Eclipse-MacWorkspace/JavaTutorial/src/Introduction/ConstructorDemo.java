package Introduction;

public class ConstructorDemo {
	public static void main(String[] args) {
		
		ConstructorCarClass c1 = new ConstructorCarClass();
		
		c1.setMake("BMW");
		System.out.println(c1.getMake());
		
		System.out.println(c1.speed);
		System.out.println(c1.gear);
		
		System.out.println("*********************");
		
		ConstructorCarClass c2 = new ConstructorCarClass(10, 1);
		System.out.println(c2.speed);
		System.out.println(c2.gear);
	}
}
