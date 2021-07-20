import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThread {
	private int size;
	private ExecutorService executor = Executors.newFixedThreadPool(5);
	private List <Integer> arr;
	
	public MultiThread(int size) {
		super();
		this.size = size;
		this.arr = new ArrayList <Integer>();
		Random random = new Random();
		for(int i=1;i<=size;i++)
			arr.add((int) random.nextInt());
	}
	
	public long count() {
		long res=0;
		Callable<Long> groupSum1 = () -> {
			long sum=0;
			for(int i=0; i<= size/5 -1;i++) {
				sum+=arr.get(i);
			}
			return sum;
		};
		
		Callable<Long> groupSum2 = () -> {
			long sum=0;
			for(int i = size/5; i< size*2/5;i++) {
				sum+=arr.get(i);
			}
			return sum;
		};
		
		Callable<Long> groupSum3 = () -> {
			long sum=0;
			for(int i = size*2/5; i< size*3/5;i++) {
				sum+=arr.get(i);
			}
			return sum;
		};
		
		Callable<Long> groupSum4 = () -> {
			long sum=0;
			for(int i = size*3/5; i< size*4/5;i++) {
				sum+=arr.get(i);
			}
			return sum;
		};
		
		Callable<Long> groupSum5 = () -> {
			long sum=0;
			for(int i = size*4/5; i< size;i++) {
				sum+=arr.get(i);
			}
			return sum;
		};
		
		List <Callable<Long>> totalSum = new ArrayList<>();
		totalSum.add(groupSum1);
		totalSum.add(groupSum2);
		totalSum.add(groupSum3);
		totalSum.add(groupSum4);
		totalSum.add(groupSum5);
		
		List <Future <Long>> sums = new ArrayList();
		
		try {
			sums = executor.invokeAll(totalSum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		try {
			if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			} 
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		
		try {
			for(int i=0; i< sums.size();i++)
				res += sums.get(i).get();
		}catch(ExecutionException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}
	
}
