package DefaultInterfaces;
public interface InterfaceA {
    default void myDefaultMethod() {
        System.out.println("Default method in InterfaceA");
    }
}

