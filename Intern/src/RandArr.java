import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RandArr {
	private int lo;
	private int hi;
	private int size;
	private List <Integer> arr;
	
	public RandArr(int lo, int hi, int size) {
		super();
		this.lo = lo;
		this.hi = hi;
		this.size = size;
		this.arr = new ArrayList <Integer>();
		for(int i=1; i<=size; i++)
			arr.add((int) ((Math.random()*(hi-lo))+lo));
	}
	
	public int countEven() {
		Stream <Integer> temp1 = arr.stream().filter(a -> a%2 == 0);
		return (int) temp1.count();
	}
	
	public int countOdd() {
		Stream <Integer> temp2 = arr.stream().filter(a -> a%2 != 0);
		return (int) temp2.count();
	}
}
