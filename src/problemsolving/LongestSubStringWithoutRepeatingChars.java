package problemsolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {

	/*
	 * Sliding window Linear time ( O(2n) )
	 */
	public static int lenghtOfLongestSubstring1(String s) {

		Set<Character> chars = new HashSet<Character>();
		int max = 0;
		int i,j;
		i= j = 0;

		while( i < s.length() && j < s.length()) {
			if(!chars.contains(s.charAt(j))) {
				chars.add(s.charAt(j));
				j++;
				if(j-i > max) {
					max = j-i;
				}
			}
			else {
				chars.remove(s.charAt(i));
				i++;
			}
		}

		return max;

	}
	 

	public static int lenghtOfLongestSubstring2(String s) {
		
		int max = 0;
		int i,j;
		i = j = 0;
		
		Map<Character, Integer> charIndices = new HashMap<>();
		
		while( i < s.length() && j < s.length()) {
			
			if(charIndices.containsKey(s.charAt(j))) {
				i = Math.max(charIndices.get(s.charAt(j)) + 1, i);
				
			}
			charIndices.put(s.charAt(j), j);
			if( j-i+1 > max)
			{
				max = j-i+1;
			}
			j++;
			
		}
		return max;
		

	}

	/*
	 * Brute Force Approach (O(n2))
	 */
	public static int lengthOfLongestSubstring(String s) {

		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++ ) 
			{
				if(!hasRepeatingChar(s, i, j)) {
					if( j-i+1 > max) {
						max = j-i+1;
					}
				}

			}
		}
		return max;
	}

	private static boolean hasRepeatingChar(String s, int l, int m) {

		Set<Character> chars = new HashSet<Character>();

		for(int i =l; i <= m; i++) {
			if(chars.contains(s.charAt(i))){
				return true;
			}
			chars.add(s.charAt(i));
		}
		return false;
	}

	public static void main(String args[]) {
		String s = "abcabcbb";
		System.out.println(lenghtOfLongestSubstring2(s));
	}
}
