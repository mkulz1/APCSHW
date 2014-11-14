import java.util.*;
public class ArrayListMethods{

    public static void collapseDuplicates( ArrayList<Integer> L ){
	for(int i = 0; i < L.size()-1; i++){	    
	    if(L.get(i)==L.get(i+1)){
		L.remove(i);
		i--;
	    }
	}
    }

    public static void randomize( ArrayList<Integer> L ){
	Random r = new Random();
	for(int i = L.size(); i > 0; i--){
	    L.add(L.remove(r.nextInt(i)));
	}
    }
    
    public static void main(String[]args){
	ArrayList<Integer> L;
	L = new ArrayList<Integer>();
	L.add(1);
	L.add(2);
	L.add(6);
	L.add(6);
	L.add(6);
	L.add(1);
	L.add(1);
	L.add(13);
	L.add(13);
	L.add(13);
	L.add(46);
	L.add(46);
	System.out.println("Original Array:");
	System.out.println(L); // See original array
	collapseDuplicates(L);
	System.out.println("New Collapsed Array:");
	System.out.println(L); // See new array
	System.out.println("Randomized Array:");
	randomize(L);
	System.out.println(L); // See randomized array
    }
}
