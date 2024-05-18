import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList();
		 a.add(1);
		 a.add(21);
		 a.add(3);
		 a.add(4);
		 
		System.out.println( a.stream().mapToInt(b-> b).max());
			
		}
		
		
		
		// TODO Auto-generated method stub

	}


