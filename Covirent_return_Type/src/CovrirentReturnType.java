

 class Animal 
 {
	 
	 public Animal getSound()
	 {
		 System.out.println("from animal class");
		   
		 
		 return new Animal();
	 
	 
	 }
	 
	 
 }
 
 
 class Dog extends Animal
 {

	@Override
	public Dog getSound() {
		return new Dog();
	}

	 
	 
 }
public class CovrirentReturnType {
	//int,float,double,byte,short,long
	//Integer,Float,Double,SHORT,Long----object
	
	//ArrayList,Linkedlist,hashmap,treemap
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
