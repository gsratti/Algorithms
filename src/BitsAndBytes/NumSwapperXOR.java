package BitsAndBytes;

class Integers {

	int a,b;

	public Integers(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class NumSwapperXOR {

	public static void swap(Integers integers) {

		if(integers == null || integers.a == integers.b) {

			return;
		}
		integers.a = integers.a^integers.b;    // a = a^b
		integers.b = integers.b ^integers.a;   // b = b^a^b = a
		integers.a = integers.b ^integers.a;   // a = b^a = a^a^b = b

	}

	public static void main(String args[]) {

		Integers integers = new Integers(10,5);

		System.out.println("Before swap, a = " + integers.a + ", b = " + integers.b);

		swap(integers);

		System.out.println("After swap, a = " + integers.a + ", b = " + integers.b);
	}

}
