import java.io.*;
import java.util.*;

public class Farmer{
    private int xpos;
    private int ypos;
    private int type;
    private boolean interacted;
    
    public Farmer(){
        xpos = (int)(Math.random() * 15);
        ypos = (int)(Math.random() *15);
        type = 2;
        interacted = false;
    }
    
    public Farmer(int x, int y){
        xpos = x;
        ypos = y;
        type = 2;
        interacted = false;
    }
    
    public int getX(){
        return xpos;
    }
    public int getY(){
        return ypos;
    }
    public int getType(){
        return type;
    }
    public boolean getInteracted(){
        return interacted;
    }
    
    public void setX(int x){
        xpos = x;
    }
    public void setY(int y){
        ypos = y;
    }
    public void setType(int t){
        type = t;
    }
    public void setInteracted(boolean i){
        interacted = i;
    }
    
    public void interact(Hero h){
        System.out.println("You have run into a farmer!");
        if(type==1){
            System.out.println("Farmer:  Oh—hello. Here is a map with the location of all the townspeople.");
            System.out.println("*Map Generated*");
            h.setShowPpl(true);
        }else if(type >= 2 && type <=5){
            System.out.println("Farmer:  My whole family is gone! I have failed to protect them!! I don't deserve this Broad Sword.\n\tOnly a true hero who has killed 4 monsters and avenged my family's death will receive this.");
            if(h.getKilledM() >= 4){
                System.out.println("\tYou have done this! Thank you so very much! Here! Here! Take this Broad Sword. \n\tI hope it will help you in future battles.");
                h.setWeapon(new Weapon("Broad Sword"));
                System.out.println("* " + h.getWeapon().getType() + " has been equipped. *");
            }
        }else if(type==6){
            Scanner kbReader = new Scanner(System.in);
            
            System.out.println("Farmer: Would you like trade your hides for items?");
            System.out.println("I have potions, bombs, breastplate, a satchel, and leather sandals.(Y/N)");
            String choice = kbReader.next();
            if ( choice.equals("Y") ){
                System.out.println("What would you like?: (P:Potions, BO:Bombs, BR:Breastplate, S:Satchel, L:Leather Sandals)");
                String item = kbReader.next();
                if(item.equals("P")){
                    
                }else if(item.equals("BO")){
                    
                }else if(item.equals("BR")){
                    
                }else if(item.equals("S")){
                    
                }else if(item.equals("L")){
                    
                }else{
                    
                }
            }
        }
    }
}



