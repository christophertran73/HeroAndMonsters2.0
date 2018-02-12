import java.io.*;
import java.util.*;
public class Monster extends Enemy{
    private String direction;
    private boolean interacted;
    private boolean canFlee;
    public Monster(){
        super();
        direction = getDirection();
    }

    public Monster(int x, int y){
        super(x, y);
        direction = getDirection();
        interacted = true;
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
        direction = getDirection();
    }

    public void interact(Hero h){
        if(isAlive()){
            Scanner reads = new Scanner(System.in);
            String option;
            canFlee = false;
            while(!canFlee){
                System.out.println("You have run into a monster!");
                System.out.println(toString());
                System.out.println("\nWhat do you want to do?(1 or 2)\n" 
                    + "1.  Fight\n2.  Flee");
                option = reads.next();
                while(!(option.equals("1") || option.equals("2"))){
                    System.out.println("\nOnly enter the digits 1 or 2.");
                    System.out.println("What do you want to do?\n" 
                        + "1.  Fight\n2.  Flee");
                    option = reads.next();
                    /*while(option != 1 || option != 2){
                    System.out.println("Only enter 1 or 2");
                    }*/
                }
                if(option.equals("1")){
                    fight(h);
                } else{
                    //if monster is above hero
                    if (h.getX() == getX() && h.getY() == getY() + 1){
                        //100% flee
                        if ( direction.equals("north") ){
                            flee(h);
                            //0% flee
                        }else if ( direction.equals("south") ){
                            System.out.println("Hero cannot flee. He must fight the monster.");
                            fight(h);
                            /*depends on getSpeed() of monster and is 2x more
                             * likely to flee than old H&M*/
                        }else if ( direction.equals("east") || direction.equals("west")){
                            if(getSpeed() == 1 && Math.random() > 0.10){
                                flee(h);
                            } else if(getSpeed() == 2 && Math.random() > 0.30){
                                flee(h);
                            } else if(getSpeed() == 3 && Math.random() > 0.50){
                                flee(h);
                            }
                        }
                        //if monster is east of hero
                    }else if (h.getX() == getX() -1 && h.getY() == getY()){
                        //100% flee
                        if ( direction.equals("east") ){
                            flee(h);
                            //0% flee
                        }else if ( direction.equals("west") ){
                            System.out.println("Hero cannot flee. He must fight the monster.");
                            fight(h);
                            /*depends on getSpeed() of monster and is 2x more
                             * likely to flee than old H&M*/
                        }else if ( direction.equals("north") || direction.equals("south")){
                            if(getSpeed() == 1 && Math.random() > 0.10){
                                flee(h);
                            } else if(getSpeed() == 2 && Math.random() > 0.30){
                                flee(h);
                            } else if(getSpeed() == 3 && Math.random() > 0.50){
                                flee(h);
                            }
                        }
                        //if monster is above hero
                    }else if (h.getX() == getX() && h.getY() == getY() - 1){
                        //100% flee
                        if ( direction.equals("south") ){
                            flee(h);
                            //0% flee
                        }else if ( direction.equals("north") ){
                            System.out.println("Hero cannot flee. He must fight the monster.");
                            fight(h);
                            /*depends on getSpeed() of monster and is 2x more
                             * likely to flee than old H&M*/
                        }else if ( direction.equals("east") || direction.equals("west")){
                            if(getSpeed() == 1 && Math.random() > 0.10){
                                flee(h);
                            } else if(getSpeed() == 2 && Math.random() > 0.30){
                                flee(h);
                            } else if(getSpeed() == 3 && Math.random() > 0.50){
                                flee(h);
                            }
                        }
                        //if monster is west of hero
                    }else if (h.getX() == getX() + 1 && h.getY() == getY()){
                        //100% flee
                        if ( direction.equals("west") ){
                            flee(h);
                            //0% flee
                        }else if ( direction.equals("east") ){
                            System.out.println("Hero cannot flee. He must fight the monster.");
                            fight(h);
                            /*depends on getSpeed() of monster and is 2x more
                             * likely to flee than old H&M*/
                        }else if ( direction.equals("north") || direction.equals("south")){
                            if(getSpeed() == 1 && Math.random() > 0.10){
                                flee(h);
                            } else if(getSpeed() == 2 && Math.random() > 0.30){
                                flee(h);
                            } else if(getSpeed() == 3 && Math.random() > 0.50){
                                flee(h);
                            }
                        }
                    }   
                }

                if(h.getHealth() <= 0){
                    System.out.println("\nThe monster has killed you.");
                    canFlee = true;
                    break;
                } else if(getHealth() <= 0){
                    System.out.println("\nYou have succeeded in defeating the monster!");
                    canFlee = true;
                    setAlive(false);
                    h.setXP(h.getXP() + getSpeed() * 5 );
                    //Hero gains hides(currency) of defeated monsters
                    //The # of gained hides is the getSpeed() x 2 so the Hero gains more hides for more difficulty
                    h.setHides(h.getHides() + getSpeed() * 2);
                    System.out.println("Hero has gained " + (getSpeed() * 2) + " hides, for a total of " + h.getHides());
                    break;
                }
            }
        }
    }

    public void fight(Hero h){
        h.setHealth(h.getHealth() - getStrength() * (1-h.getArmor().getDef()));
        System.out.println("The monster attacked. Your health is now " + h.getHealth() + " xp.");
        if(getSpeed() == 1 ){
            setHealth((int)(getHealth() - h.getWeapon().getAtt()));
            System.out.println("You quickly use your " + h.getWeapon().getType() + ". The monster's health has been lowered.");
        } else if(getSpeed() == 2){
            if(Math.random() > 0.25){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The monster's health has been lowered.");
            } else {
                System.out.println("The monster is too fast. You have missed");
            }
        } else if(getSpeed() == 3){
            if(Math.random() > 0.50){
                setHealth((int)(getHealth() - h.getWeapon().getAtt()));
                System.out.println("You quickly use your " + h.getWeapon().getType() + ". The monster's health has been lowered.");
            } else {
                System.out.println("The monster is too fast. You have missed");
            }
        }
    }

    public void flee(Hero h){
        System.out.println("Hero has managed to avoid engaging in battle.");
        canFlee = true;
    }
    
    public void setDirection(String d){
        direction = d;
    }
    public void setInteracted(boolean i){
        interacted = i;
    }
    public boolean getCanFlee(){
        return canFlee;
    }

    public String getDirection(){
        String ret = "";
        int rand = (int)(Math.random() * 4);
        if (rand == 0 ){
            ret = "north";
        }else if ( rand == 1 ){
            ret = "east";
        }else if ( rand == 2 ){
            ret = "south";
        }else if ( rand == 3 ){
            ret = "west";
        }
        return ret;
    }
    public boolean getInteracted(){
        return interacted;
    }
    public void setCanFlee(boolean cF){
        canFlee = cF;
    }
    

    public String toString(){
        return ("Monster Health: " + getHealth() + ",\nMonster Strength: " + getStrength() + ",\nMonster Speed: " + getSpeed() + "\nMonster Direction: " + direction);
    }
}