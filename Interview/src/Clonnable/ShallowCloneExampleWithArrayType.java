package Clonnable;
public class ShallowCloneExampleWithArrayType implements Cloneable {
    private int value;
    private int[] array;

    public ShallowCloneExampleWithArrayType(int value, int[] array) {
        this.value = value;
        this.array = array;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] originalArray = {1, 2, 3};
        ShallowCloneExampleWithArrayType original = new ShallowCloneExampleWithArrayType(10, originalArray);

        ShallowCloneExampleWithArrayType shallowClone = (ShallowCloneExampleWithArrayType) original.clone();

        // Modify the array in the cloned object
        shallowClone.array[0] = 99;
        shallowClone.value=2;

        // Both the original and cloned objects are affected
        System.out.println(original.value);  // Output: 10
        System.out.println(original.array[0]);  // Output: 99
        System.out.println(shallowClone.value);  // Output: 10
        System.out.println(shallowClone.array[0]);  // Output: 99
    }
}
