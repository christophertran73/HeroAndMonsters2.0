/*import java.io.*;
import java.util.*;
public class Driver{
    //used to indicate which farmer is being interacted with
    public static int numF = 0;
    public static int numPHas = 0;
    public static void main(String args[]){
        System.out.println("** Hero & Monsters **\n");

        //create objects
        Hero hero = new Hero();

        ArrayList<Potion> potions = new ArrayList<Potion>();

        ArrayList<Monster> monsters = new ArrayList<Monster>();

        ArrayList<Farmer> farmers = new ArrayList<Farmer>();
        Farmer f1 = new Farmer();
        Farmer f2 = new Farmer();
        Farmer f3 = new Farmer();
        Farmer f4 = new Farmer();
        Farmer f5 = new Farmer();
        Farmer f6 = new Farmer();
        farmers.add(f1);
        farmers.add(f2);
        farmers.add(f3);
        farmers.add(f4);
        farmers.add(f5);
        farmers.add(f6);

        int worldSize = 15;

        //generate the maps (1 with objects, 1 with a String that we display)
        System.out.println("* The map has been generated *");
        Object map[][] = new Object[worldSize][worldSize];
        String printedMap[][] = new String[worldSize][worldSize];

        //fill map with objects
        map[hero.getY()][hero.getX()] = hero;
        printedMap[hero.getY()][hero.getX()] = "H  ";
        
        for(Farmer obj: farmers){
            while(map[obj.getX()][obj.getY()] != null){
                obj.setX((int)(Math.random() * worldSize));
                obj.setY((int)(Math.random() * worldSize)); 
            }
            map[obj.getX()][obj.getY()] = obj;
            printedMap[obj.getX()][obj.getY()] = "F  ";
        }
        System.out.println("The farmers have been generated.");

        //Storyline intro (add to this)
        System.out.println("Hero begins his journey");

        //prints map
        printMap(map, printedMap, worldSize, hero);

        //gameplay
        Scanner reads = new Scanner(System.in);
        String key;
        int oldX, oldY;
        Potion potionHeroIsCarrying = null;
        while(true){
            if(hero.getHealth() <= 0){
                //maybe have words
                System.out.println("** Game Over **");
                break;
                //FIX
            } else if(hero.getHealth() > 0 && hero.getKilledM() ==6){
                //maybe have words
                System.out.println("* Hero has defeated all the monsters *");
                System.out.println("** You win! **");
                break;
            }
            System.out.print("Enter direction (WASD): ");
            for(Potion obj: potions){
                if(obj.getInteracted() && !obj.getUsed()){
                    potionHeroIsCarrying = obj;
                    System.out.println("(To use your potion press P)");
                    break;
                }
            }

            key = reads.next();
            oldX = hero.getX();
            oldY = hero.getY();

            //check clicks of WASD to move
            //take input from the user
            if(key.equals("w")){
                if(hero.getY() - 1 < 0 || map[hero.getY() - 1][oldX] != null){
                    System.out.println("Hero cannot go there.");
                } else {
                    hero.setY(oldY - 1);
                }
            } else if(key.equals("s")){
                if(hero.getY() + 1 > 9 || map[hero.getY() + 1][oldX] != null){
                    System.out.println("Hero cannot go there.");
                } else {
                    hero.setY(oldY + 1);
                }
            } else if(key.equals("a")){
                if(hero.getX() - 1 < 0 || map[oldY][hero.getX() - 1] != null){
                    System.out.println("Hero cannot go there.");
                } else {
                    hero.setX(oldX - 1);
                }
            } else if(key.equals("d")){
                if(hero.getX() + 1 > 9 || map[oldY][hero.getX() + 1] != null){
                    System.out.println("Hero cannot go there.");
                } else {
                    hero.setX(oldX + 1);
                }
            } else if(key.equals("p")){
                if(potionHeroIsCarrying.getInteracted() && !potionHeroIsCarrying.getUsed()){
                    potionHeroIsCarrying.healHero(hero);
                    numPHas--;
                }
            }else {
                System.out.println("You've entered an incorrect key.");
            }

            map[oldY][oldX] = null;
            printedMap[oldY][oldX] = null;
            map[hero.getY()][hero.getX()] = hero;
            printedMap[hero.getY()][hero.getX()] = "H  ";
            ArrayList<Integer>touched = touching(map, printedMap, hero);

            //check if touching anything
            if(touched.size() != 0){
                differentiate(touching(map, printedMap, hero), map, printedMap, hero, worldSize);
            } else {
                printMap(map, printedMap, worldSize, hero);
            }

        }
    }

    public static void printMap(Object[][] map, String[][] printedMap, int worldSize, Hero h){
        int k;
        String str = "";
        Monster m;
        Farmer f;
        Potion p;
        for(int i=0; i< worldSize; i++){
            for(k=0; k< worldSize; k++){
                if(map[i][k] == null){
                    str += "–  ";
                } else {
                    if(printedMap[i][k] == "H  "){
                        str += printedMap[i][k];
                    }
                    if(printedMap[i][k] == "M  "){
                        m = (Monster)map[i][k];
                        if(m.getInteracted()){
                            str += printedMap[i][k];
                        } else {
                            str += "–  ";
                        }
                    } else if(printedMap[i][k] == "F  "){
                        f = (Farmer)map[i][k];
                        if(f.getInteracted() && h.getShowPpl()){
                            str += printedMap[i][k];
                        } else {
                            str += "–  ";
                        }
                    } else if(printedMap[i][k] == "P  "){
                        p = (Potion)map[i][k];
                        if(p.getInteracted()){
                            str += printedMap[i][k];
                        } else {
                            str += "–  ";
                        }
                    } 
                }
            }
            str += "\n";
        }
        System.out.println(str);
        System.out.println("Hero's Items: \n\tArmor: " + h.getArmor().getType()
            + "  Weapon: " + h.getWeapon().getType()
            + "  Potions: " + numPHas + "\n");

    }

    public static ArrayList<Integer> touching(Object[][] map, String[][] printedMap, Hero h){
        ArrayList<Integer> interactedPos = new ArrayList<Integer>();
        if(h.getY()+1 <= 9 && map[h.getY()+1][h.getX()] != null){
            interactedPos.add(h.getY()+1);
            interactedPos.add(h.getX());
        }

        if(h.getY()-1 >= 0 && map[h.getY()-1][h.getX()] != null){
            interactedPos.add(h.getY()-1);
            interactedPos.add(h.getX());
        }

        if(h.getX()+1 <= 9 && map[h.getY()][h.getX()+1] != null){
            interactedPos.add(h.getY());
            interactedPos.add(h.getX()+1);
        }

        if(h.getX()-1 >= 0 && map[h.getY()][h.getX()-1] != null){
            interactedPos.add(h.getY());
            interactedPos.add(h.getX()-1);
        }

        return interactedPos;
    }

    public static void differentiate(ArrayList<Integer> touchedPos, Object[][] map, String[][] printedMap, Hero h, int worldSize){
        //Scanner reads = new Scanner(System.in);
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        ArrayList<Potion> potions = new ArrayList<Potion>();
        ArrayList<Farmer> farmers = new ArrayList<Farmer>();
        //Monster m;
        Potion p;
        Farmer f;
        //monster on top of hero
        if(Math.random() <0.9 && h.getY() - 1 >= 0){
            Monster mT = new Monster(h.getX(), h.getY() - 1);
            mT.setInteracted(true);
            monsters.add(mT);
            map[mT.getX()][mT.getY()] = mT;
            printedMap[mT.getX()][mT.getY()] = "M  ";
        }
        //monster below hero
        if(Math.random() < 0.9 && h.getY() + 1 < 15){
            Monster mB = new Monster(h.getX(), h.getY() + 1);
            mB.setInteracted(true);
            monsters.add(mB);
            map[mB.getX()][mB.getY()] = mB;
            printedMap[mB.getX()][mB.getY()] = "M  ";
        }
        //monster to the left of hero
        if(Math.random() <0.9 && h.getX() - 1 >= 0){
            Monster mL = new Monster(h.getX() - 1, h.getY());
            mL.setInteracted(true);
            monsters.add(mL);
            map[mL.getX()][mL.getY()] = mL;
            printedMap[mL.getX()][mL.getY()] = "M  ";
        }
        //monster to the left of hero
        if(Math.random() <0.9 && h.getX() + 1 < 15){
            Monster mR = new Monster(h.getX() + 1, h.getY());
            mR.setInteracted(true);
            monsters.add(mR);
            map[mR.getX()][mR.getY()] = mR;
            printedMap[mR.getX()][mR.getY()] = "M  ";
        }
        for(int i=0; i < touchedPos.size(); i+=2){
            if(printedMap[(int)(touchedPos.get(i))][(int)(touchedPos.get(i+1))].equals("M  ")){
            m = (Monster)map[touchedPos.get(i)][touchedPos.get(i+1)];
            m.setInteracted(true);
            monsters.add(m);
            } else 
            if(printedMap[(int)(touchedPos.get(i))][(int)(touchedPos.get(i+1))].equals("P  ")){
                p = (Potion)map[touchedPos.get(i)][touchedPos.get(i+1)];
                p.setInteracted(true);
                potions.add(p);
            } else if(printedMap[(int)(touchedPos.get(i))][(int)(touchedPos.get(i+1))].equals("F  ")){
                f = (Farmer)map[touchedPos.get(i)][touchedPos.get(i+1)];
                f.setInteracted(true);
                farmers.add(f);
            }
        }
        //prints map
        printMap(map, printedMap, worldSize, h);
        interact(monsters, potions, farmers, h);
    }

    public static void interact(ArrayList<Monster> mo, ArrayList<Potion> po, ArrayList<Farmer> fa, Hero h){
        for(Potion p: po){
            p.interact();
            numPHas++;
        }

        for(Farmer f: fa){
            numF++;
            if(numF==1){
                f.setType(1);
            }
            f.interact(h);
        }

        for(Monster m: mo){
            m.interact(h);
        }
    }

    public boolean isMonster(int x, int y){
        if(Math.random() < 0.9){
            return true;
        } else {
            return false;
        }
    }
}*/



