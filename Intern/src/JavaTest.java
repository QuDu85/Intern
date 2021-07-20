
public class JavaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountEven even = new CountEven(1,100);
		int first = even.count();
		System.out.println("Ex 1: "+first);
		DivBy3 by3 = new DivBy3(1,100);
		int second = by3.count();
		System.out.println("Ex 2: "+second);
		RandArr rand = new RandArr(1,100,100);
		int third1 = rand.countEven();
		int third2 = rand.countOdd();
		System.out.println("Ex 3: ");
		System.out.println("Number of even: " + third1);
		System.out.println("Number of odd: " + third2);
		MultiThread bigRand = new MultiThread(100000);
		long fifth = bigRand.count();
		System.out.println("Ex 5: "+fifth);
		
	}

}
