package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberToLetters {

	public static Map<Character,ArrayList<String>> numberStrings = new HashMap<Character,ArrayList<String>>(){
		{
			put('1', new ArrayList<String>() {{
				add("");
			}});
			put('2',new ArrayList<String>() {{
				add("a");
				add("b");
				add("c");
			}});
			put('3',new ArrayList<String>() {{
				add("d");
				add("e");
				add("f");
			}});
			put('4',new ArrayList<String>() {{
				add("g");
				add("h");
				add("i");
			}});
			put('5',new ArrayList<String>() {{
				add("j");
				add("k");
				add("l");
			}});
			put('6',new ArrayList<String>() {{
				add("m");
				add("n");
				add("o");
			}});
			put('7',new ArrayList<String>() {{
				add("p");
				add("q");
				add("r");
				add("s");
			}});
			put('8',new ArrayList<String>() {{
				add("t");
				add("u");
				add("v");
			}});
			put('9',new ArrayList<String>() {{
				add("w");
				add("x");
				add("y");
				add("z");
			}});
		}
	};

	public static List<String> getStrings(String numbers, int start)
	{
		if(start == numbers.length()-1)
		{
			return numberStrings.get(numbers.charAt(start));
		}

		List<String> strings = getStrings(numbers, start+1);

		List<String> newStrings = new ArrayList<String>();

		for(String s : numberStrings.get(numbers.charAt(start))) {

			for(String s1 : strings) {
				newStrings.add(s+s1);
			}

		}
		return newStrings;
	}
	public static void main(String args[]) {
		int A[] = {1,2};
		List<String> strings = getStrings("23",0);
		for(String s : strings)
		{
			System.out.println(s);
		}
	}

}
