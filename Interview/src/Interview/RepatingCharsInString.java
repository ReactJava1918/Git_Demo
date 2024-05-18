package Interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepatingCharsInString {

    public static void main(String[] args) {
        String s = "siva Reddy";

        
        // Use Java streams to group repeating characters
        Map<String, List<String>> groupedData = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c -> c, Collectors.toList()));

        // Print the grouped data
       // groupedData.forEach((key, value) -> System.out.println(key + ": " + value));
        
        Map<Object, Long> groupedData1 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c -> c,()-> new LinkedHashMap(), Collectors.counting()));
        
        groupedData1.forEach((key, value) -> System.out.println(key + ": " + value));
        
        
       // Map<Object, Long> groupedData2 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
    }
}
