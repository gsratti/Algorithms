package problemsolving;

public class AtoI {

	public static int aToI(String s) {

		int i = 0;
		int num = 0;
		int sign = 1;
		if(s == null || s.isEmpty()) 
			return num;
		while(s.charAt(i) == ' ' && i < s.length()) {
			i++;
		}
		if(s.charAt(i) == '-') 
		{
			sign = -1;
			i++;
		} else if (s.charAt(i) == '+')
			i++;

		while(i < s.length())
		{
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
			{	
				if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 0)
				{
					if(sign == 1) return Integer.MAX_VALUE;
					else return Integer.MIN_VALUE;
				}
				num = num * 10 + (s.charAt(i) - '0');
			    i++;
			    System.out.print("Now ;"+ num);
			}
			
			else break;
		}
		num = num*sign;
		System.out.println(num);
		if(num <= -1*Math.pow(2, 31)) {
			num = (int) (-1*Math.pow(2, 31));
		}
		else if (num >= Math.pow(2, 31) -1 ) {
			num = (int) (Math.pow(2, 31) -1);
		}
		return num;
	}

	public static void main(String args[]) {
		String s = "+1";
	//	System.out.print(Integer.MAX_VALUE);
		System.out.print(aToI(s));
		
		int a = 912834723;
		int a10 = a*10;
		int b = (a*10)+3;
	//	System.out.println("b" + b);
	}

}
