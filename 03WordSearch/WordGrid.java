import java.util.Random;
public class WordGrid{
    private char[][]data;
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    public WordGrid(){
	this(6,6);       // Default makes a 6x6 grid
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = ' ';
	    }
	}
    }
    private void fill(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		result += data[rows][columns] + " ";
	    }
	    result += "\n";
	}
	return result;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */

    private boolean addWordHorizontal(String word,int row, int col){
	int column = col; // To keep in check with the grid spaces.
	//Makes sure the word will fit.
	for(int i = 0; i < word.length(); i++){  
	    if(data[row][column] != ' ' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    column++;
	}
	//Actually puts the word in.
	column = col; // To fill in each column space.
	for(int i = 0; i < word.length(); i++){
	    data[row][column] = word.charAt(i);
	    column++;
	}
	return true;
    }

    private boolean addWordVertical(String word,int row, int col){
	int row_ = row; // To keep in check with the grid spaces.
	//Makes sure the word will fit.
	for(int i = 0; i < word.length(); i++){  
	    if(data[row_][col] != ' ' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row_++;
	}
	//Actually puts the word in.
	row_ = row; // To fill in each row space.
	for(int i = 0; i < word.length(); i++){
	    data[row_][col] = word.charAt(i);
	    row_++;
	}
	return true;
    }


    private boolean addWordDiagonal(String word,int row, int col){
	int row_ = row;
	int column = col; // To keep in check with the grid spaces.
	//Makes sure the word will fit.
	for(int i = 0; i < word.length(); i++){  
	    if(data[row_][column] != ' ' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row_++;
	    column++;
	}
	//Actually puts the word in.
	row_ = row;
	column = col; // To fill in each row space.
	for(int i = 0; i < word.length(); i++){
	    data[row_][column] = word.charAt(i);
	    row_++;
	    column++;
	}
	return true;   
    }

    public void fillUp(){
	Random r = new Random();
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
	        if(data[rows][columns] == ' '){
		    data[rows][columns] = alphabet.charAt(r.nextInt(26));
		}
	    }
	}
    }

    // MAIN METHOD ----- TESTING
    public static void main(String[] args) {
	WordGrid data = new WordGrid(6,6);
	System.out.println("WordGrid:");
	System.out.println(data);
	//	data.fill();
	//      System.out.println(data);
	data.addWordHorizontal("yoyo",0,0);
	System.out.println(data);
	data.addWordHorizontal("github",1,0);
	data.addWordHorizontal("fire",2,0);
	data.addWordHorizontal("cookie",3,0);
	data.addWordHorizontal("sun",4,0);
	data.addWordHorizontal("bunny",5,0);
	System.out.println(data);
	data.fillUp();
	System.out.println(data);
    }
}

