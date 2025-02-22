package compileTime_exception_handling;

import java.io.FileReader;
import java.io.IOException;

public class compileTime_Exceptions {

	//Methods which performs IO operations are used, it force the user to add throws declaration while method declaration and method calling.	
	public static void main(String[] args) throws IOException {
		
		fileReaderMethod();
		
	}
	//Even though throws is forced to add, still you need to add try catch block to catch and handle the exception and also allow further execution.
	public static void fileReaderMethod() throws IOException
	{
		try {
			FileReader file = new FileReader("/Users/leelasan/git/Automation/Eclipse-MacWorkspace/JavaTutorial/src/compileTime_exception_handling/test.txt");
			
			char[] a = new char[100];
			file.read(a);
			
			System.out.println(a);
			
			file.close();
			
			}catch (Exception e){
				e.printStackTrace();
			}
		
	}

}
