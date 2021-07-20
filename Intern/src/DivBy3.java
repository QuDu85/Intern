import java.util.stream.IntStream;

public class DivBy3 {
	private int lo;
	private int hi;
	
	public DivBy3(int lo, int hi) {
		super();
		this.lo = lo;
		this.hi =hi;
	}
	
	public int count() {
		IntStream intstream = IntStream.rangeClosed(lo, hi).filter(a -> a%3 == 0);
		return (int) intstream.count();
	}
}
