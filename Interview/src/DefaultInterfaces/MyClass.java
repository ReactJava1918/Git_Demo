package DefaultInterfaces;
public class MyClass implements InterfaceA, InterfaceB {
    
     @Override
    public void myDefaultMethod() {
        InterfaceA.super.myDefaultMethod(); // Explicitly choose InterfaceA's implementation
     }
    
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myDefaultMethod(); // Ambiguous call, requires resolution
    }
}
