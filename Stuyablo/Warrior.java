import java.util.Random;
public class Warrior extends Adventurer{
    private int rage;
    private String warcry;
    
    public Warrior(String n,int HP){
	super(n,HP);
	rage = 25;
    }
    public Warrior(String n){
	this(n,25);
    }
    public Warrior(){
	this("Lester");
    }

    // GET & SET METHODS
    public int getRage(){
	return rage;
    }
    public void setRage(int r){
	rage = r;
    }

    // GET STATS
    public String getStats(){
	return super.getStats() + " " + getRage() + "RAGE";
    }
    
    // ATTACK METHODS
    public void attack(Adventurer other){
	Random h = new Random();
	int pain = 1 + h.nextInt(6);
	if(hit(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" launches a roundhouse kick at "+ other.getName() + ", taking "+ pain + " hit points.");
	}else{
	    System.out.println("\n*****" + getName() +" launches a roundhouse kick at "+ other.getName() + ", but misses.");	  
	}
    }
    public void specialAttack(Adventurer other){
	Random h = new Random();
	int pain =  (7 + h.nextInt(5));
	if(rage>10){
	    if(hit(other)){
		other.setHP(other.getHP() - pain);
		System.out.println("\n*****" + getName() +" headbutts "+ other.getName() + ", dealing "+ pain + " hit points.");
		rage-= 10;
	    }else{
		System.out.println("\n*****" + getName() +" tries to headbutt "+ other.getName() + ", but misses.");
	    }
	}else{
	    System.out.println("\n*****" + getName() + " is not angry enough to perform this attack!");
	}
    }
}

    
