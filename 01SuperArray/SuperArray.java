public class SuperArray{
    Object[] data;
    int currentLength;

    public SuperArray(){
	data = new Object[10];
    }
    public SuperArray(int size){
	data = new Object[size];
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
    }

    public void add(Object o) {
        data[currentLength]=o;
        currentLength ++;
        if (currentLength==data.length)
            resize(data.length*2);
    }
    
    public void add(int index, Object o){
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

    public Object set(int index, Object o){
        if ( index < currentLength && index >= 0){
	    Object oldValue = data[index];
	    data[index] = o;
	    return oldValue;
	}else{
	    return this.get(index);
	}
    }

    private void resize(int s) {
        Object[] newData = new Object[s];
        for (int i = 0; i < s; i++)
            newData[i] = data[i];
        data=newData;
	//	newData.currentLength = 0;
    }
    
    public Object get(int index) {
        if (index >= currentLength || index < 0){
            throw new IndexOutOfBoundsException();
      	}else{
	    return data[index];  
	}
    }
    
    public Object remove(int index) {
        if (index >= currentLength || index < 0){
	    throw new IndexOutOfBoundsException();
        }else{
	    Object oldValue = data[index];
	    for (int i = index; i < currentLength - 1; i++) {
		if (i == data.length)
		    resize(data.length + 10);
		data[i] = data[i+1];
	    } 
	    data[currentLength - 1] = null;
	    currentLength --;
	    if(currentLength <= (data.length/4))
	       resize(currentLength*2);
	    return oldValue;
	}
    }
    
    public static void main(String[]args){
	SuperArray tester = new SuperArray(5); 
	tester.add(2);
	tester.add(3);
	tester.add(4);
	tester.add(5);
	//	tester.add(6);
	//	tester.get(8);
	tester.set(0,44);
	//	tester.set(14,9);
	System.out.println(tester);
	tester.remove(0);
	System.out.println(tester);
	tester.clear();
	System.out.println(tester);
	System.out.println(tester.currentLength);
    }
}
