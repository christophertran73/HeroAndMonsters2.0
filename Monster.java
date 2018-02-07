import java.io.*;
import java.util.*;
public class Monster extends Enemy{
    private String direction;
    public Monster(){
        super();
        direction = getDirection();
    }

    public Monster(int x, int y){
        super(x, y);
        direction = getDirection();
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
                            if(getSpeed() == 0 && Math.random() > 0.125){
                                flee(h);
                                break;
                            } else if(getSpeed() == 1 && Math.random() > 0.25){
                                flee(h);
                                break;
                            } else if(getSpeed() == 2 && Math.random() /*< 0.25*/ > 0.375){
                                flee(h);
                                break;
                            } else if(getSpeed() == 3 && Math.random() < 0.50){
                                flee(h);
                                break;
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
                            if(getSpeed() == 0 && Math.random() > 0.125){
                                flee(h);
                                break;
                            } else if(getSpeed() == 1 && Math.random() > 0.25){
                                flee(h);
                                break;
                            } else if(getSpeed() == 2 && Math.random() /*< 0.25*/ > 0.375){
                                flee(h);
                                break;
                            } else if(getSpeed() == 3 && Math.random() < 0.50){
                                flee(h);
                                break;
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
                            if(getSpeed() == 0 && Math.random() > 0.125){
                                flee(h);
                                break;
                            } else if(getSpeed() == 1 && Math.random() > 0.25){
                                flee(h);
                                break;
                            } else if(getSpeed() == 2 && Math.random() /*< 0.25*/ > 0.375){
                                flee(h);
                                break;
                            } else if(getSpeed() == 3 && Math.random() < 0.50){
                                flee(h);
                                break;
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
                            if(getSpeed() == 0 && Math.random() > 0.125){
                                flee(h);
                                break;
                            } else if(getSpeed() == 1 && Math.random() > 0.25){
                                flee(h);
                                break;
                            } else if(getSpeed() == 2 && Math.random() /*< 0.25*/ > 0.375){
                                flee(h);
                                break;
                            } else if(getSpeed() == 3 && Math.random() < 0.50){
                                flee(h);
                                break;
                            }
                        }
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
        setHealth((int)(getHealth() - h.getWeapon().getAtt()));
        System.out.println("You quickly use your " + h.getWeapon().getType() + ". The monster's health has been lowered.");
    }

    public void flee(Hero h){
        System.out.println("Hero has managed to avoid engaging in battle.");
    }
    
      public String getDirection(){
        String ret = "";
        int rand = (int)(Math.random() * 4);
        if ( rand == 0 ){
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


    public String toString(){
        return ("Monster Health: " + getHealth() + ",\nMonster Strength: " + getStrength() + ",\nMonster Speed: " + getSpeed());
    }
}