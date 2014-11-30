import java.util.Random;
public class WordGrid{
    private char[][]data;
    Random r = new Random();
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
	this(10,10);       // Default makes a 10x10 grid
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = ' ';
	    }
	}
    }

    // Fills it with a random character - For testing purposes.
    private void fill(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toStrisng.
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

    private boolean addWord(String word,int row, int col, int dx, int dy){
	if (wordFits(word, row, col, dx, dy)){
	    for(int i = 0; i < word.length(); i++){
		data[row][col] = word.charAt(i);
		col += dx;
		row += dy;
	    }
	    return true;
	}else{
	    return false;
	}
    }

    /**
     *Checks to see whether the word fits at the specified position
     *@param word is the word to be added to WordGrid
     *@param row is the vertical location of the first letter of the word
     *@param col is the horizontal location of the first letter of the word
     *@param dx is an integer between (-1,1) that shows the horizontal direction of the next letter
     *@param dy is an integer between (-1,1) that shows the vertical direction of the next letter
     *@return true if the word fits, false if it does not
     */
    private boolean wordFits(String word, int row, int col, int dx, int dy){
	if ((dx==0 && dy==0) ||
	    row < 0 || col < 0 ||
	    col + dx*word.length() > data[0].length ||
	    col + dy*word.length() > data.length){
	    return false;
	}
	for (int i = 0; i < word.length(); i++){
	    if (data[row][col] != ' ' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row += dy;
	    col += dx;
	}
	return true;
    }
    
    public boolean addWordRandomly(String word){
	int tries = 10;
	boolean success;
	do{
	    success = addWord(word, r.nextInt(data.length),  r.nextInt(data[0].length), r.nextInt(3)-1, r.nextInt(3)-1);
	    tries--;
	}while(!success && tries>0);
	    return tries != 0;
    }

    public void addWordFile(String file){
	try{
	    File WordList = new File(file);
	    Scanner in = new Scanner(file);
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


    public void fillUp(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
	        if(data[rows][columns] == ' '){
		    data[rows][columns] = alphabet.charAt(r.nextInt(26));
		}
	    }
	}
    }
}

