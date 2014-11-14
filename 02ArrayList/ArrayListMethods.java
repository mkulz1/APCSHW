imp ort java.util.*;
public class ArrayListMethods{
  
      public static void collapseDuplicates(ArrayList<Integer> L){
			for(int i = 0; i < L.size()-1; i++){	      
	  			 if(L.get(i)==L.get(i+1)){
		L.remove(i);
		i--;
	    }
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
	System.out.println("Original Array:");
	System.out.println(L); // See original array
	collapseDuplicates(L);
	System.out.println("New Collapsed Array:");
	System.out.println(L); // See new array
    }
}
