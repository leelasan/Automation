package resources;

public enum BasePatheNumClasses {

	putDataBasePathURL("/objects"),
	postDataBasePathURL("/objects");

	private String resource;

	BasePatheNumClasses(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}

/*
 
   To achieve the value of base path url's in the main code
   --------------------------------------------------------- 
   First of all declare all the methods just with the string path. 
   no braces and no code required. And that should be first in the class. 
   also use comma for all methods to separate and the last method will get the semicolon
  
   Secondly, you will instantiate the class with an object in the calling class with the input of the variable
   that variable will contain either putDataBasePathURL or postDataBasePathURL.
   when this class in instantiated, the constructor gets the call with that variable
   the constructor then assign the value of that variable with the help of 'this' key to to the local variable resource
   
   After the instantiation of this class in the calling class (example obj as class object name), 
   you call the method obj.getResource()
   that's it, it will return the string within that method name of those enum classes whichever the name called by the variable.
   
   For instantiation, you don't use 'new' keyword. and use valueOf to the class constructor like below
   	BasePatheNumClasses obj = BasePatheNumClasses.valueOf("postDataBasePathURL");
   	and then with that object, you call the getResource methods as below,
   	obj.getResource() 
   	this will return the string value based on the resource you called in the constructor
   	


 */