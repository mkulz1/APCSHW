
import java.util.Random;
import java.util.Scanner;

public class Game{

    // USER INPUT FOR DISTRIBUTION FOR STATS
    public static int getUserInt(int min,int max){
	Scanner in = new Scanner(System.in);
	int result;
	do{
	    System.out.println("Enter a non-negative integer less than "+ (max+1));
	    result = in.nextInt();
	}while(result < min || result > max);
	return result;
    }


    // ASSIGN BONUS STATS
    public static void assignBonusStats(Adventurer player,int bonusStats){
	System.out.println("\nYou have " + player.getSTR() + " STR," + player.getDEX() + " DEX, and " + player.getINT() + " INT");
	
	System.out.println("You have " + bonusStats + " points.\nHow many do you want to allocate to STR?");
	int STR = getUserInt(0,bonusStats);
	player.setSTR( player.getSTR() + STR );
	bonusStats = bonusStats - STR;
	
	if(bonusStats > 0){
	    System.out.println("You have " + bonusStats + " points to put into DEX/INT.\nHow many do you want to allocate to DEX?");
	    int DEX = getUserInt(0,bonusStats) ;
	    player.setDEX( player.getDEX() + DEX);
	    bonusStats = bonusStats - DEX;
	    
	    //leftover goes to int.
	    player.setINT( player.getINT() + bonusStats );
	}
    }
 
    // CREATING THEIR CHARACTER
    public static Adventurer userSelectClass(){
	Adventurer player = null;
	boolean done;
	Scanner choice = new Scanner(System.in);
       	Scanner namer =  new Scanner(System.in);
	done = false;	
	do{	  	
	    System.out.println("Choose the letter that represents your class:\n");
	    System.out.println("A : Warrior\nB : Wizard\nC : Rogue\nD : Martial Artist\n");
	    String theChoice = choice.nextLine();
	    if(theChoice.equals("A")){
		System.out.println("Please name your Warrior:");
		String name = namer.nextLine();
	        player = new Warrior(name);
		assignBonusStats(player,30);
		done = true;
	    }else if(theChoice.equals("B")){
		System.out.println("Please name your Wizard:");
		String name = namer.nextLine();
		player = new Wizard(name);
		assignBonusStats(player,30);
		done = true;
	    }else if(theChoice.equals("C")){
		System.out.println("Please name your Rogue:");
		String name = namer.nextLine();
	        player = new Rogue(name);
		assignBonusStats(player,30);
		done = true;
	    }else if(theChoice.equals("D")){
		System.out.println("Please name your Martial Artist:");
		String name = namer.nextLine();
	        player = new MartialArtist(name);
		assignBonusStats(player,30);
		done = true;
	    }else{
		System.out.println("Please choose again!");
	    }
	}while(!done);
	return player;
    }

    public static void createRandom(Adventurer[] group){
	group[0] = new Warrior("Timmot");
	group[1] = new Wizard("Hilliot");
	group[2] = new Rogue("Jo");
	group[3] = new MartialArtist("Olaf");
	System.out.println("\nYour players are:");
	System.out.println(group[0].getStats() + "\n" + group[1].getStats() + "\n" + group[2].getStats( ) + "\n" + group[3].getStats());
    }

    //CREATE AN ARRAY OF PLAYERS
    public static void userCreatePlayers(Adventurer[] group){
	System.out.println("Player 1:");
	group[0] = userSelectClass();
	System.out.println("Player 2:");
      	group[1] = userSelectClass();
	System.out.println("Player 3:");
       	group[2] = userSelectClass();
	System.out.println("Player 4:");
	group[3] = userSelectClass();	
	System.out.println("\nYour players are:");
	System.out.println(group[0].getStats() + "\n" + group[1].getStats() + "\n" + group[2].getStats( ) + "\n" + group[3].getStats());
    }
   
    // COMBAT METHODS
    
     public static boolean isAlive(Adventurer[] group){
	boolean[] stat = new boolean[4];
	for(int d = 0; d < group.length; d++){
	    stat[d] = (group[d].getHP() > 0);
	}
	return (stat[0] || stat[1] || stat[2] || stat[3]);
	}

    public static void opponentChoose(Adventurer[] group, Adventurer opponent){
	Random type = new Random();
	Random whom = new Random();
	int theType = type.nextInt(2);
	int theWho = whom.nextInt(4);
	if(group[theWho].getHP() < 0){
	    theWho = whom.nextInt(4);
	}
	if (theType == 0){
	    opponent.attack(group[theWho]);
	}else{
	    opponent.specialAttack(group[theWho]);
	}
    }

    public static void combat(Adventurer[] group, Adventurer other){

	while(other.getHP() > 0 && isAlive(group)){
	    Scanner here = new Scanner(System.in);
	    for(int e = 0; e < group.length; e++){
		if (group[e].getHP() > 0){
		    System.out.println("What would you like " + group[e].getName() + " to do?");
		    System.out.println("A : Attack");
		    System.out.println("S : Special Attack");
		    System.out.println("R : Run Away");
		    String theHere = here.nextLine();
		    if(theHere.equals("A")){
			group[e].attack(other);
		    }
		    if(theHere.equals("S")){
			group[e].specialAttack(other);
		    }
		    if(theHere.equals("R")){
			System.out.println("\n*****" + group[e].getName() + " has given up on his team! That coward.");
			group[e].setHP(0);
		    }
		    System.out.println("\nYour Team:\n" + group[0].getStats() + "\n" + group[1].getStats() + "\n" + group[2].getStats( ) + "\n" + group[3].getStats() + "\n");
		    System.out.println("Your Opponent:\n" + other.getStats() + "\n");
		}else{
		}
	    }
	    if(other.getHP() < 0){
		System.out.println(" ***** YOUR PLAYERS ARE VICTORIOUS ***** ");
		break;
	    }else if(!(isAlive(group))){
		System.out.println(" ***** YOU PLAYERS HAVE BEEN DEFEATED ***** ");
		break;
	    }else{
	    opponentChoose(group,other);
 System.out.println("\nYour Team:\n" + group[0].getStats() + "\n" + group[1].getStats() + "\n" + group[2].getStats( ) + "\n" + group[3].getStats() + "\n");
		    System.out.println("Your Opponent:\n" + other.getStats() + "\n");
	    }
	}

    }
    
    public static void combat(Adventurer player, Adventurer opponent){
	
	// ATTACKING
	while(player.getHP()>0 && opponent.getHP()>0){
	    Scanner decision = new Scanner(System.in);
	    System.out.println(opponent.getName() + ":");
	    System.out.println(opponent.getStats());
	    System.out.println(player.getName() + ":");
	    System.out.println(player.getStats());
	    System.out.println("Please choose an action:");
	    System.out.println("A : Attack");
	    System.out.println("S : Special Attack");
	    System.out.println("G : Give Up");
	    
	    String theDecision = decision.nextLine();
	    if(theDecision.equals("A")){
		player.attack(opponent);
		opponent.attack(player);
	    }
	    if(theDecision.equals("S")){
		player.specialAttack(opponent);
		opponent.specialAttack(player);
	    }
	    if(theDecision.equals("G")){
		System.out.println("\nYou have surrendered to " + opponent.getName()+".");
		player.setHP(0);
	    }
	}
	if(player.getHP()<=0){
	    System.out.println("\n**********  " + player.getName()+" has lost the battle to " + opponent.getName() + "  **********\n");
	}else{
	    if(opponent.getHP()<=0){
		System.out.println("\n**********  " + player.getName()+" is victorious over " + opponent.getName() + "  **********\n");
	    }
	}
    }
    


    //MAIN METHOD********************************************

    public static void main(String[]args){

	System.out.println("Welcome to Stuyablo 2");

	Scanner start = new Scanner(System.in);
	boolean check = false;
	do{
	    System.out.println("For a Single Player Game, Press: Q\nFor a Group Players Game, Press: W");
	    String theStart = start.nextLine();

	    if(theStart.equals("Q")){
		// Single Opponent Battle
		Adventurer player = userSelectClass();
		Adventurer opponent = new Wizard("Dude",25);
		check = true;
		combat(player, opponent);
	    }else if (theStart.equals("W")){
		Adventurer[] people;
		people = new Adventurer[4];
		Adventurer opponent2 = new Wizard("Dumbledore",55,35);
		Scanner option = new Scanner(System.in);

		boolean checker = false;
		do{
		    System.out.println("Do you want to create your own party?\nYes: Y  or   No: N");
		    String theOption = option.nextLine();
		    if(theOption.equals("Y")){
			userCreatePlayers(people);
			checker = true;
		    }else if(theOption.equals("N")){
			createRandom(people);
			checker = true;
		    }else{
			System.out.println("Please Choose Again!");
		    }
		}while(!checker);

		System.out.println("\nYour opponent is:\n" + opponent2.getStats() + "\n");
		check = true;
		combat(people,opponent2);
	    }else{
		System.out.println("Please Choose Again!");
	    }
	}while(!check);		    
    }
}




