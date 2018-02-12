import java.io.*;
import java.util.*;
public class Boss extends Enemy{
    private String name;
    private boolean heroHasItems;
    private boolean canFlee;
    public Boss(String n, int st, int sp){
        super();
        name = n;
        setStrength(st);
        setSpeed(sp);
        setHealth(getHealth() + sp * 15);
        heroHasItems = false;
    }
    
    public void interact(Hero h){
        //checks if hero has proper items
        if(isAlive() && heroHasItems){
            Scanner reads = new Scanner(System.in);
            String option;
            canFlee = false;
            while(!canFlee){
                System.out.println("You have run into the " + name + "!");
                System.out.println(toString());
                System.out.println("\nWhat do you want to do?(1 or 2)\n" 
                    + "1.  Fight\n2.  Flee");
                option = reads.next();
                while(!(option.equals("1") || option.equals("2"))){
                    System.out.println("\nOnly enter the digits 1 or 2.");
                    System.out.println("What do you want to do?\n" 
                        + "1.  Fight\n2.  Flee");
                    option = reads.next();
                }
                if(option.equals("1")){
                    fight(h);
                } else{
                    flee(h);
                }

                if(h.getHealth() <= 0){
                    System.out.println("\nThe " + name + " has killed you.");
                    canFlee = true;
                    break;
                } else if(getHealth() <= 0){
                    System.out.println("\nYou have succeeded in defeating the " + name + "!");
                    canFlee = true;
                    setAlive(false);
                    h.setKilledB(h.getKilledB()+1);
                    h.setXP(h.getXP() + getSpeed() * 5 );
                    //Hero gains gold(currency) of defeated bosses
                    //The # of gained gold is the getSpeed() x 2 so the Hero gains more gold for more difficulty
                    h.setGold(h.getGold() + getSpeed() * 2);
                    System.out.println("Hero has gained " + (getSpeed() * 2) + " hides, for a total of " + h.getHides());
                    break;
                }
            }
        }
    }
    
    public void fight(Hero h){
        h.setHealth(h.getHealth() - getStrength() * (1-h.getArmor().getDef()));
        System.out.println("The " + name + " attacked. Your health is now " + h.getHealth() + " xp.");
        if(getSpeed() == 4 ){
            if(Math.random() > 0.20){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The " + name +"'s health has been lowered.");
            } else {
                System.out.println("The " + name + " is too fast. You have missed");
            }
        } else if(getSpeed() == 5){
            if(Math.random() > 0.30){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The " + name +"'s health has been lowered.");
            } else {
                System.out.println("The " + name + " is too fast. You have missed");
            }
        } else if(getSpeed() == 6){
            if(Math.random() > 0.40){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The " + name +"'s health has been lowered.");
            } else {
                System.out.println("The " + name + " is too fast. You have missed");
            }
        }  else if(getSpeed() == 7){
            if(Math.random() > 0.50){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The " + name +"'s health has been lowered.");
            } else {
                System.out.println("The " + name + " is too fast. You have missed");
            }
        }
    }

    public void flee(Hero h){
        System.out.println("Hero has managed to avoid engaging in battle.");
        canFlee = true;
    }
    
    public void setName(String n){
        name = n;
    }
    public void setHeroHasItems(boolean h){
        heroHasItems = h;
    }
    public void setCanFlee(boolean cF){
        canFlee = cF;
    }
    
    public String getName(){
        return name;
    }
    public boolean getHeroHasItems(){
        return heroHasItems;
    }
    public boolean getCanFlee(){
        return canFlee;
    }
    
    public String toString(){
        return (name + " Health: " + getHealth() + ",\n" + name + " Strength: " + getStrength() + ",\n" + name + " Speed: " + getSpeed());
    }
}