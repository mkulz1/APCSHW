import java.util.Random;
public abstract class Adventurer{
    private String name;
    private int HP;
    private int STR;
    private int DEX;
    private int INT;

    // CONSTRUCTORS
    public Adventurer(String n,int HP){
	setName(n);
	this.HP = HP;
	setSTR(10);
	setDEX(10);
	setINT(10);
    }
    public Adventurer(String n){
	this(n,25);
    }
    public Adventurer(){
	this("Clay",25);
     }

    // GET METHODS
    public String getName(){
	return name;
    }
    public int getHP(){
	return HP;
    }
    public int  getSTR(){
	return STR;
    }
    public int getDEX(){
	return DEX;
    }
    public int getINT(){
	return INT;
    }

    // SET METHODS
    public void setHP(int h){
	HP = h;
    }
    public void setSTR(int s){
	STR = s;
    }
    public void setDEX(int d){
	DEX = d;
    }
    public void setINT(int i){
        INT = i;
    }
    public void setName(String name){
	this.name = name;
    }

    // TO STRING METHOD
    public String toString(){
	return getName();
    }
    public String getStats(){
	return toString() + " " +getHP()+"HP "+ getSTR()+"STR "+ getDEX()+"DEX "+ getINT()+"INT";
    }

    //ATTACK METHODS

    public boolean hit(Adventurer other){
	Random r = new Random();	
	double chance = 0.15 + .75*((double)getDEX() / other.getDEX() * 10)/(getDEX()+other.getDEX());
	//System.out.println(chance);
	return r.nextDouble()<chance;	  
    }
    public boolean hitMagic(Adventurer other){
	Random r = new Random();	
	double chance = 0.15 + .75*((double)getINT() / other.getINT() * 10)/(getINT()+other.getINT());
	//System.out.println(chance);
	return r.nextDouble()<chance;	  
    }
    
    public void attack(Adventurer other){
	Random h = new Random();
	int pain = 1 + h.nextInt(5);
	if(hit(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" successfully trips "+ other.getName() + ", taking "+ pain + " hit points.");
	}else{
	    System.out.println("\n*****" +getName() +" tries to punch "+ other.getName() + ", but misses.");	  
	}
    }
    public void specialAttack(Adventurer other){
	Random h = new Random();
	int pain = (3 + h.nextInt(5));
	if(hit(other)){
	    other.setHP(other.getHP() - pain);
	    System.out.println("\n*****" + getName() +" successfully punches "+ other.getName() + " and takes "+ pain + " hit points.");   
	}else{
	    System.out.println("\n*****" +"Special Attack Failed!");
	}
    }
 
}

	
    
