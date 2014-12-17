public class Sorts{
   	
	public static void bubble(int[] c){
	    int holder;
	    for(int i = 0; i < c.length; i++){
		if(c[i] > c[i+1]){
		    holder = c[i];
		    c[i] = c[i+1];
		    c[i+1] = holder;
		}
	    }
	}
	
	public static void insertion(int[] c){
	    
	}
	
    /*	public static void selection(int[] c){
	    int small;
	    int holder;
	    for(int i = 0; i < size(); i++){
		if( c[i] < c[i+1]){

		}
	    }
	    } */   
    
    public static void main(String[] args){
	int[] data = new int[5];
	for (int i = 5; i > 0; i --){
	    data[5 - i] = i;
	}
	System.out.println(data);
    }
}
