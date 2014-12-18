public class Sorts{
   	
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
    
    // Needs toString
    public static String toString(int[] c){
	String result = "{ "; 
	for (int i = 0; i < c.length; i++){
	    result += c[i] + " ";
	}
	result += "}";
	return result;
    }
    
    public static void selection(int[] c){
	
    }  
    
    public static void main(String[] args){
	int[] data = new int[]{4,6,3,2,5,2};
	System.out.println(toString(data));
	//	bubble(data);
	insertion(data);
	System.out.println(toString(data));
    }
}
