public class SuperArray{
    String[] data;
    int currentLength;

    public SuperArray(){
	this(10);
    }
    public SuperArray(int size){
	data = new String[size];
	currentLength = 0;
    }

    public int size(){
	return currentLength;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < currentLength; i++) {
            result += data[i] + " ";
        }
        return result;
    }

    public void clear(){
	for(int i = 0; i < data.length; i++){
	    data[i] = null;
	}
	//	currentLength = 0; // If its there, then it doesn't print "null"
    }

    public void add(String o) {
        data[currentLength]=o;
        currentLength ++;
        if (currentLength==data.length)
            resize(data.length*2);
    }
    
    public void add(int index, String o){
	if (index < 0 || index > data.length){
	    throw new IndexOutOfBoundsException();
	}else if (index >= currentLength){
	    this.add(o);
	}else{ 
	    if (index < currentLength) {
                for (int i = currentLength-1; i>index; i--) {
                    if (i==data.length)
                        resize(data.length*2);
                    data[i]=data[i-1];
                }
                data[index] = o;
                currentLength ++;
	    }
	}
    }

    public String set(int index, String o){
        if ( index > currentLength || index < 0){
	    throw new IndexOutOfBoundsException();
	}else{
	    String oldValue = data[index];
	    data[index] = o;
	    return oldValue;
	}
    }

    private void resize(int s) {
        String[] newData = new String[s];
        for (int i = 0; i < s; i++)
            newData[i] = data[i];
        data=newData;
    }
    
    public String get(int index) {
        if (index >= currentLength || index < 0){
            throw new IndexOutOfBoundsException();
      	}else{
	    return data[index];  
	}
    }
    
    public String remove(int index) {
        if (index >= currentLength || index < 0){
	    throw new IndexOutOfBoundsException();
        }else{
	    String oldValue = data[index];
	    for (int i = index; i < currentLength - 1; i++) {
		if (i == data.length)
		    resize(data.length + 10);
		data[i] = data[i+1];
	    } 
	    data[currentLength - 1] = null;
	    currentLength --;
	    if(currentLength <= (data.length/4))
	       resize(currentLength/2);
	    return oldValue;
	}
    }

    public void insertionSort(){
	String temp = "";
	for( int i = 1; i < size(); i++ ){
	    temp = data[i];
	    int j = i - 1;
	    while (j >= 0){
		if (temp.compareTo(data[j]) > 0){
		    break;
		}
		data[j + 1] = data[j];
		j--;
	    }
	    data[j + 1] = temp;
	}
    }
   

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    
    public int find(String target){
	int index = 0;
	int i = 0;
	while(index == 0 && i < size()){
	    if(data[i].equals(target))
		index = i;
	    i++;
	}
	return index;
    }

    public String getSmallest(int startIndex){
	String smallest = data[startIndex];
	for(int i = startIndex+1;i < size(); i++){
	    if (smallest.compareTo(data[i]) > 0)
		smallest = data[i];
	}
	return smallest;
    }
    
    public void selectionSort(){
	int small;
	String holder;
	for(int i = 0; i < size(); i++){
	    small = this.find(this.getSmallest(i));
	    holder = data[i];
	    data[i] = data[small];
	    data[small] = holder;
	}
    }    
    
}
