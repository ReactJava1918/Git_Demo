package Interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Annagaram {

	public static void main(String[] args) {
		String s1="care";
		String s2="acrne";
		String s1aftersorting=Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());
		String s2aftersorting=Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());
		
		if(s1aftersorting.equalsIgnoreCase(s2aftersorting))
		{
			System.out.println("Given two strings are anagrams");
		}
		
		else
		{
			System.out.println("Given two strings are  not -----------anagrams");
		}

	}

}
