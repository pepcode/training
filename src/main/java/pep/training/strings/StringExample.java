package pep.training.strings;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StringExample {
	
	static String[] words = {"testing ", "praveen ", "what ", "this " };
	
	public static void main(String args[]) {
		
		System.out.println(joinStrArray(words));
		
		long stime = System.nanoTime();
		hasAllUniqueWords("testing praveen what this test praveen");
		System.out.println(System.nanoTime() - stime);
		
		
		 stime = System.nanoTime();
		hasAllUniqueWords("testing praveen what this test asfdas");
		System.out.println(System.nanoTime() - stime);

		//System.out.println(hasAllUniqueWords("testing praveen what this test praveen"));
		
	}
	
	//String builder examnple
	static String joinStrArray(String[] words) {
		//use StringBuilder for any string concatenation, to avoid the unwanted string object creations
		StringBuilder build = new StringBuilder();
		for(String word: words) {
			build.append(word);
		}
		return build.toString();
	}

	static boolean hasAllUniqueWords(String sentences) {
		
		String[] words = sentences.split(" ");
		Set<String> s= new TreeSet<>();
		for(String word : words) {
			s.add(word);
		}
		return (s.size() == words.length);
	}

	
	
}
