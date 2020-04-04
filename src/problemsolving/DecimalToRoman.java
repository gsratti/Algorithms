package problemsolving;

public class DecimalToRoman {

	public static String getRoman(int n) {

		int knowns[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String romans[] = {"I", "IV", "V", "IX", "X","XL","L","XC","C","CD","D","CM","M"};
		
		

		String roman = "";

		int quotient;

		for(int i = knowns.length-1; n != 0; i--) {
			if(knowns[i] <= n) {
				quotient = n/knowns[i];
				n = n%knowns[i];
				while(quotient != 0) {
					roman = roman + romans[i];
					quotient--;
				}
			}

		}
		return roman;
	}

	public static String getRoman1(int n) {

		String roman = "";

		int knowns[] = {1,4,5,9,10};
		String romans[] = {"I", "IV", "V", "IX", "X"};

		int curr,zeroes;
		zeroes = 0;
		int currKnown;

		while(n != 0) {
			curr = n % 10;
			for(int i = 0; i < zeroes; i++) {
				curr = curr * 10;
			}
			for(int i = knowns.length-1; i >= 0; i--) {
				if(knowns[i] <= curr) {
					currKnown = i;
					roman = romans[currKnown] + roman;
					curr = curr - knowns[currKnown];
					while(curr != 0) {
						for(int j = knowns.length-1; j >= 0; j--) {
							if(knowns[j] <= curr) {
								roman = roman + romans[j];
								curr = curr - knowns[j];
								break;
							}
						}

					}
					break;
				}
			}
			n = n/10;
			zeroes++;
		}
		return roman;
	}

	public static void main(String args[]) {
		System.out.print(getRoman(3567));
	}

}
