package InterfacesDemo;

public class Implementation_class implements InterfaceC{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceC ref = new Implementation_class();
		ref.my_Amethod();
		ref.my_Bmethod();
		ref.my_Cmethod();
		
		//System.out.println(InterfaceC.a);
		System.out.println(InterfaceC.b);

	}

	
	@Override
	public void my_Amethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void my_Bmethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void my_Cmethod() {
		// TODO Auto-generated method stub
		
	}

}
