package problemsolving;

public class LongestPalindromicSubString {

	public static String longestPalindromicSubString(String s) {

		if(s == null || s.isEmpty()) {
			return s;
		}

		boolean isPalindrome[][] = new boolean[s.length()][s.length()];

		for( int i=0; i<s.length(); i++) {
			isPalindrome[i][i] = true;
		}

		int start, end;
		start = end = 0;

		for(int k = 2; k <= s.length(); k++) {

			for(int i = 0; i+k-1 < s.length(); i++) {

				if(k == 2) {
					if(s.charAt(i) == s.charAt(i+1)) {
						isPalindrome[i][i+k-1] = true;
					}
				}
				else {
					isPalindrome[i][i+k-1] = isPalindrome[i+1][i+k-2] == true ? s.charAt(i) == s.charAt(i+k-1) ? true : false : false;
				}
				
				if(isPalindrome[i][i+k-1])
				{
					start = i;
					end = i+k-1;
				}
			}
		}

		return s.substring(start, end+1);
	}

	public static void main(String args[]) {

		String s = "abcdedfg";

		System.out.println(longestPalindromicSubString(s));
	}
}
