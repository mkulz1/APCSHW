import java.util.Random;
public class Wizard extends Adventurer{
    private int mana;

    public Wizard(String n,int HP,int ma){
	super(n,HP);
    	mana = ma;
    }
    public Wizard(String n,int HP){
	super(n,HP);
    	mana = 25;
    }
    public Wizard(String n){
	this(n,25);
    }
    public Wizard(){
	this("Logan");
    }

    // SET & GET METHODS
    public void setMana(int m){
	mana  = m;
    }
    public int getMana(){
	return mana;
    } 

    // GET STATS
    public String getStats(){
	return super.getStats() + " " + getMana() + "MANA";
    }
    
    // ATTACK METHODS
    public void attack(Adventurer other){
	Random h = new Random();
	int pain = 1 + h.nextInt(3);
	if(hitMagic(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" gets into a catfight with "+ other.getName() + " and wins, taking "+ pain + " hit points.");
	}else{
	    System.out.println("\n*****" + getName() +" gets into a catfight with "+ other.getName() + ", but loses.");	  
	    }
    }
    
    public void specialAttack(Adventurer other){
	Random h = new Random();
	int pain = (7 + h.nextInt(7));
	if(mana>10){
	    if(hitMagic(other)){
		System.out.println("\n*****" + getName() +" blasts a large ball of fire at "+ other.getName() + " "+ pain + " hit points.");
		other.setHP(other.getHP() - pain);
		mana-= 10;
	    }else{
		System.out.println("\n*****" + getName() +" shoots a large ball of fire at "+ other.getName() + ", but misses.");
	    }
	}else{
	    System.out.println("\n*****" + "You don't have enough power to perform a special attack!");
	}
    }
    public void attackO(Adventurer other){
	Random h = new Random();
	int pain = 10 + h.nextInt(3);
	if(hitMagic(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" gets into a catfight with "+ other.getName() + " and wins, taking "+ pain + " hit points.");
	}else{
	    System.out.println("\n*****" + getName() +" gets into a catfight with "+ other.getName() + ", but loses.");	  
	    }
    }
    
    public void specialAttackO(Adventurer other){
	Random h = new Random();
	int pain = (13 + h.nextInt(7));
	if(mana>10){
	    if(hitMagic(other)){
		System.out.println("\n*****" + getName() +" blasts a large ball of fire at "+ other.getName() + " "+ pain + " hit points.");
		other.setHP(other.getHP() - pain);
		mana-= 10;
	    }else{
		System.out.println("\n*****" + getName() +" shoots a large ball of fire at "+ other.getName() + ", but misses.");
		mana -= 10;
	    }
	}else{
	    System.out.println("\n*****" + "You don't have enough power to perform a special attack!");
	}
    }
}

