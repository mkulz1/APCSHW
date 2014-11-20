import java.util.Random;
public class Rogue extends Adventurer{
    private int endurance;

    //CONSTRUCTORS
    public Rogue(String n,int HP){
	super(n,HP);
	endurance = 25;
    }
    public Rogue(String n){
	this(n,25);
    }
    public Rogue(){
	this("Chip",25);
    }

    // SET & GET ENDURANCE
    public int getEndurance(){
	return endurance;
    }
    public void setEndurance(int e){
	endurance = e;
    }

    // GET STATS
    public String getStats(){
	return super.getStats() + " " + getEndurance() + "ENDURANCE";
    }
    
    // ATTACK METHODS
    public void attack(Adventurer other){
	super.attack(other);
    }
    public void specialAttack(Adventurer other){
	Random h = new Random();
	int pain =  5 + h.nextInt(5);
	if(endurance>10){
	    if(hit(other)){
		other.setHP(other.getHP() - pain);
		System.out.println("\n*****" + getName() +" successfully sneaks up on "+ other.getName() + " and takes "+ pain + " hit points.");
		endurance-= 10;
	    }else{
		System.out.println("\n*****" + getName() +"tries to sneak up on "+ other.getName() + " but slips and falls.");
	    }
	}else{
	    System.out.println("\n*****" + "You're too tired to perform a special attack!");
	}
    }    
}
