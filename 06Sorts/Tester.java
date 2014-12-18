import java.util.Random;
import java.util.Arrays;

public class Tester{

    public static void main(String[] args){
	Random r = new Random();
	long startTime,endTime;
	int data = new int[10000];

	for(int i = 0; i < data.length; i++){
	    data[i] = r.nextInt(Integer.MAX_VALUE);
	}

	System.out.println("Bubble Sort:");
	int[] data_bub = Arrays.copyOf(data, data.length); 
	startTime = System.currentTimeMillis();
	Sorts.bubble(data_bub);
	endTime = System.currentTimeMillis();
	System.out.println("Bubble Time: " + (endTime - startTime));

    }
}
