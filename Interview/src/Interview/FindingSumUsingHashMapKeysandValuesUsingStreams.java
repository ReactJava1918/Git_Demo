package Interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindingSumUsingHashMapKeysandValuesUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hsmap = new HashMap();
		hsmap.put(1,1);
		hsmap.put(2,1);
		hsmap.put(3,1);
		hsmap.put(4,1);
		hsmap.put(5,1);
		
		
		int optionalIntValues =hsmap.values().stream().mapToInt(a->a).sum();
		System.out.println(optionalIntValues);
		int optionalIntKeys=hsmap.keySet().stream().mapToInt(b->b).sum();
		System.out.println(optionalIntKeys);
		hsmap.forEach((key,value)->System.out.println(key+"            "+value));
		
		//Normal HashMap Program
		
		Set s=hsmap.entrySet();
		Iterator i=s.iterator();
		
		while(i.hasNext())
		{
			Map.Entry<Integer, Integer> data =(Map.Entry<Integer, Integer>)i.next();
			System.out.println(data.getKey());
			System.out.println(data.getValue());
		}
	}

}
