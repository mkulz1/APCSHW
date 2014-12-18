import java.util.*;
public class Sorts{

    public static String name(){
	return "Kulyk, Mariya";
    }

    public static int period(){
	return 6;
    }
    
    public static void bubble(int[] c){
	int holder;
	for(int x = c.length - 1; x > 0; x--){
	    for(int i = 0; i < x; i++){
		if(c[i] > c[i+1]){
		    holder = c[i];
		    c[i] = c[i+1];
		    c[i+1] = holder;
		}
	    }
	}
    }

  public static void selection(int[] c){
	for(int i = 0; i < c.length-1; i++){
	    int min = i;
	    for(int x = i+ 1; x < c.length; x++){
		if(c[x] < c[min])
		    min = x;
	    }
	    int temp = c[i];
	    c[i] = c[min];
	    c[min] = temp;
	}
    }
    
    public static void insertion(int[] c){
	for(int i = 0; i < c.length; i++){
		int n = c[i];
		int x = i;
		while( x > 0 && c[x - 1] > n){
		    c[x] = c[x - 1];
		    x--;
		}
		c[x] = n;
	}  
    }
    
    public static void radix(int[] c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>(10);
	int digit = 0;
	for(int i = 0; i < c.length; i ++){

	    digit = c[i] % 10;

	}
    }
    
   // Needs toString
    public static String toString(int[] c){
	String result = "{ "; 
	for (int i = 0; i < c.length; i++){
	    result += c[i] + " ";
	}
	result += "}";
	return result;
    }  
    
    public static void main(String[] args){
	int[] data_bub = new int[]{4,6,3,2,5,2};
	int[] data_sel = new int[]{13,25,-9,64,3};
	int[] data_ins = new int[]{21,-97,-4,23,6}; 
	
	System.out.println("Un-Sorted:");
	System.out.println(toString(data_bub));
	System.out.println(toString(data_sel));
	System.out.println(toString(data_ins));
	
	bubble(data_bub);
	insertion(data_sel);
	selection(data_ins);
	
	System.out.println("Sorted:");
	System.out.println(toString(data_bub));
	System.out.println(toString(data_sel));
	System.out.println(toString(data_ins));
    }
}
