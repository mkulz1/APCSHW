public class Driver{
    public static void main(String[]args){
	Adventurer p1 = new Adventurer();
	Warrior p2 = new Warrior();
	Wizard p3 = new Wizard();
	Rogue p4 = new Rogue();
	System.out.println();
	System.out.println(p1.getStats());
	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();
	p1.attack(p2);
	p4.specialAttack(p3);
	System.out.println();
	System.out.println(p1.getStats());
	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();
    }
}
