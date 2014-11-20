import java.util.Random;
public class MartialArtist extends Adventurer{
    private int qi;

    //CONSTRUCTORS
    public MartialArtist(String n,int HP){
	super(n,HP);
	qi = 25;
    }
    public MartialArtist(String n){
	this(n,25);
    }
    public MartialArtist(){
	this("",25);
    }

    // SET & GET ENDURANCE
    public int getQi(){
	return qi;
    }
    public void setQi(int q){
        qi = q;
    }

    // GET STATS
    public String getStats(){
	return super.getStats() + " " + getQi() + "QI";
    }
    
    // ATTACK METHODS
    public void attack(Adventurer other){
	Random h = new Random();
	int pain = 1 + h.nextInt(5);
	if(hit(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" karate chops "+ other.getName() + " and wins, taking "+ pain + " hit points.");
	}else{
	    System.out.println("\n*****" + getName() +" tries to karate chop "+ other.getName() + ", but misses.");	  
	}
    }
    
    public void specialAttack(Adventurer other){
	Random h = new Random();
	int pain =  5 + h.nextInt(5);
	if(qi>10){
	    if(hit(other)){
		other.setHP(other.getHP() - pain);
		System.out.println("\n*****" + getName() +" successfully joint locks "+ other.getName() + " and takes "+ pain + " hit points.");
		qi -= 10;
	    }else{
		System.out.println("\n*****" + getName() +"tries to joint lock "+ other.getName() + ", but fails.");
		qi -= 10;
	    }
	}else{
	    System.out.println("\n*****" + "You're too tired to perform a special attack!");
	}
    }    
}
