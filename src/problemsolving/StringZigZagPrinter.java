package problemsolving;

import java.util.ArrayList;
import java.util.List;

public class StringZigZagPrinter {

	public static String convert(String s, int numRows) {

		if(numRows == 0)
			return null;
		if(numRows == 1)
			return s;

		int row = 0;

		List<StringBuilder> stringsPerRow = new ArrayList<StringBuilder>(); 

		for(int i = 0; i < numRows; i++) {
			stringsPerRow.add(new StringBuilder());
		}

		StringBuilder result = new StringBuilder();

		int rowIncrementor = 1;

		for(int i = 0; i < s.length(); i++) {

			stringsPerRow.get(row).append(s.charAt(i));
			if(row == 0) {
				rowIncrementor = 1;
			} else if (row == numRows -1) {
				rowIncrementor = -1;
			}
			row = row + rowIncrementor;
		}

		for(int i = 0; i < numRows ; i++)
		{
			result.append(stringsPerRow.get(i));
		}

		return result.toString();
	}
	public static void main(String args[]) {
		String s = "PAYPALISHIRING";

		System.out.println(convert(s, 4));

	}

}
