package DefaultInterfaces;
public interface InterfaceB {
    default void myDefaultMethod() {
        System.out.println("Default method in InterfaceB");
    }
}

