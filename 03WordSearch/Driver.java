import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {
	WordGrid data = new WordGrid(10,10);
	System.out.println("WordGrid:");
	System.out.println(data);

	try{
	    File WordList = new File("WordList.txt");
	    Scanner in = new Scanner(WordList);
	    ArrayList<String> wordBank = new ArrayList<String>();
	    Random r = new Random();
	    while(in.hasNext()){
		wordBank.add(in.next());
	    }
	    for(int i = 0; i < wordBank.size(); i++){
		String word = wordBank.remove(r.nextInt(wordBank.size()));
		data.addWordRandomly(word);
	    }
	    System.out.println(data);
	}catch(FileNotFoundException e){
	    System.out.println("No such file exists");
	}
    }
}


