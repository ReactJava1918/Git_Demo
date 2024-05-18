package Clonnable;
import java.util.Arrays;

public class DeepCloneExampleWithArrayType implements Cloneable {
    private int value;
    private int[] array;

    public DeepCloneExampleWithArrayType(int value, int[] array) {
        this.value = value;
        this.array = Arrays.copyOf(array, array.length);
    }

    public Object clone() throws CloneNotSupportedException {
    	DeepCloneExampleWithArrayType deepClone = (DeepCloneExampleWithArrayType) super.clone();
        deepClone.array = Arrays.copyOf(this.array, this.array.length);
        return deepClone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] originalArray = {1, 2, 3};
        DeepCloneExampleWithArrayType original = new DeepCloneExampleWithArrayType(10, originalArray);

        DeepCloneExampleWithArrayType deepClone = (DeepCloneExampleWithArrayType) original.clone();

        // Modify the array in the cloned object
        deepClone.array[0] = 99;
        deepClone.value=3;

        // Only the cloned object is affected, not the original
        System.out.println(original.value);  // Output: 10
        System.out.println(original.array[0]);  // Output: 1
        System.out.println(deepClone.value);  // Output: 10
        System.out.println(deepClone.array[0]);  // Output: 99
    }
}
