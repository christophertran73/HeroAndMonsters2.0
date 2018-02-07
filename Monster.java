import java.io.*;
import java.util.*;
public class Monster extends Enemy{
    //private String direction
    public Monster(){
        super();
    }
    
    public Monster(int x, int y){
        super(x, y);
    }
    
    public Monster(int x, int y, Hero h){
        super(x, y);
        //setStrength((int)(Math.random() * 30) + 1;);
        setStrength((int)(h.getXP()/2 + 5));
        //hero gains 5 XP for each lvl 1 monster 
        //hero gains 10 XP for each lvl 2 monster 
        //hero gains 15 XP for each lvl 3 monster 
        if(h.getXP()<20){
            setSpeed(1);
        } else if(h.getXP()<80){
            setSpeed(2);
        } else {
            setSpeed(3);
        }
    }
    
        public void interact(Hero h){
        if(isAlive()){
            Scanner reads = new Scanner(System.in);
            int option;
            while(true){
                System.out.println("You have run into a monster!");
                System.out.println(toString());
                System.out.println("\nWhat do you want to do?(1 or 2)\n" 
                                    + "1.  Fight\n2.  Flee");
                option = reads.nextInt();
                while(!(option == 1 || option == 2)){
                    System.out.println("\nOnly enter the digits 1 or 2.");
                    System.out.println("What do you want to do?\n" 
                                    + "1.  Fight\n2.  Flee");
                    option = reads.nextInt();
                    /*while(option != 1 || option != 2){
                        System.out.println("Only enter 1 or 2");
                    }*/
                }
                if(option == 1){
                    fight(h);
                } else{
                    if(getSpeed() == 0 && Math.random() > 0.25){
                        flee(h);
                        break;
                    } else if(getSpeed() == 1 && Math.random() > 0.5){
                        flee(h);
                        break;
                    } else if(getSpeed() == 2 && Math.random() < 0.25){
                        flee(h);
                        break;
                    } else {
                        System.out.println("Hero cannot flee. He must fight the monster.");
                        fight(h);
                    }
                }
                
                if(h.getHealth() <= 0){
                    System.out.println("\nThe monster has killed you.");
                    break;
                } else if(getHealth() <= 0){
                    System.out.println("\nYou have succeeded in defeating the monster!");
                    setAlive(false);
                    h.setKilledM(h.getKilledM()+1);
                    h.setXP(h.getXP() + getSpeed() * 5);
                    //Hero gains hides(currency) of defeated monsters
                    //The # of gained hides is the speed x 2 so the Hero gains more hides for more difficulty
                    h.setHides(h.getHides() + getSpeed() * 2);
                    System.out.println("Hero has gained " + (getSpeed() * 2) + " hides, for a total of " + h.getHides());
                    break;
                }
            }
        }
    }
    
    public void fight(Hero h){
        h.setHealth(h.getHealth() - getStrength() * (1-h.getArmor().getDefense()));
        System.out.println("The monster attacked. Your health is now " + h.getHealth() + " xp.");
        setHealth((int)(getHealth() - Math.random() * (h.getWeapon().getHigh() - h.getWeapon().getLow()) + h.getWeapon().getLow()));
        System.out.println("You quickly use your " + h.getWeapon().getType() + ". The monster's health has been lowered.");
    }
    
    public void flee(Hero h){
        System.out.println("Hero has managed to avoid engaging in battle.");
    }
    
    public String toString(){
        return ("Monster Health: " + getHealth() + ",\nMonster Strength: " + getStrength() + ",\nMonster Speed: " + getSpeed());
    }
}