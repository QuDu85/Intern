import java.util.stream.IntStream;

public class CountEven {
	private int lo;
	private int hi;
	
	public CountEven(int lo, int hi) {
		super();
		this.lo = lo;
		this.hi = hi;
	}
	
	public int count() {
		IntStream intstream = IntStream.rangeClosed(lo, hi).filter(a -> a%2 == 0);
		return intstream.sum();
	}
}
