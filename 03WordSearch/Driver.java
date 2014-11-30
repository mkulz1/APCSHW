import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {
	WordGrid data = new WordGrid(10,10);
	System.out.println("WordGrid:");
	System.out.println(data);
	data.loadWordFile("WordList.txt");	
	
    }
}


