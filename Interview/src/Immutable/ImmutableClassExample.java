package Immutable;
import java.util.ArrayList;
import java.util.HashMap;

public class ImmutableClassExample {
	
	public static void main(String [] args)
	{
		ArrayList<String> a= new ArrayList<String>();
				a.add("dat1");
		
		HashMap h=new HashMap<String, String>();
		h.put("a","A");
		
		
		A k= new A(2,"siva",a,h);
		
	System.out.println(k.getI()+"   "+k.getName()+"  "+k.getStringList()+"    "+k.getHashmapData());
		
		
		k.getStringList().add("data2");
		k.getStringList().add("data3");
		k.getStringList().add("data4");
		k.getHashmapData().put("b","B");
		k.getHashmapData().put("c","C");
		k.getHashmapData().put("d","D");
		
		System.out.println(k.getI()+"   "+k.getName()+"  "+k.getStringList()+"    "+k.getHashmapData());
	}

}
