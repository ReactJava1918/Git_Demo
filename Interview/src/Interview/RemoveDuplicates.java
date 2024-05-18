package Interview;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
       // int[] array = {3, 3, 3, 5, 2, 8, 5, 7, 1, 2, 8, 9};
    	int [] array= {3,3,3};
        int size = array.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    // Duplicate found, remove it by shifting elements
                    for (int k = j; k < size - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    size--; // Decrease array size
                    j--; // Adjust index after removing duplicate
                }
            }
        }

        // Print the array without duplicates
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.print(Arrays.toString(array));

    }
}
