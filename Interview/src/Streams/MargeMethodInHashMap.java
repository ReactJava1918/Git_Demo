package Streams;

import java.util.HashMap;
import java.util.Map;

public class MargeMethodInHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize a HashMap
		Map<String, Integer> wordCountMap = new HashMap<>();

		// Count occurrences of words in a text
		String[] words = {"a", "b", "p", "o", "b", "a"};
		for (String word : words) {
		    // Using merge to update word count
		    wordCountMap.merge(word, 1, Integer::sum);
		}

		// Print word counts
		wordCountMap.forEach((word, count) -> System.out.println(word + ": " + count));


	}

}
