package serializationAndDeserialization;

import java.util.List;

public class demo1dataObject {
	
	String id;
	String name;
	List<Object> data;
	
	public String getid(){
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	
	public void getObjRecord()
	{
		System.out.println("Printing from here: "+this.name+" "+this.data);
	}
}
