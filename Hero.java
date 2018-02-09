public class Hero{
    private int xpos;
    private int ypos;
    private double health;
    private Weapon sword;
    private int killedM;
    private Armor armor;
    private int hides;
    private int xp;
    private boolean showPpl;
    private int nofH = 0;
    private int nofF = 0;
    private int nofP = 0;
    private int numBombs = 0;

    public Hero(){
        xpos = 0;
        ypos = 14;
        health = 100;
        sword = new Weapon("dagger");
        killedM = 0;
        //armor = new Armor();
        hides = 0;
        xp = 0;
    }

    public Hero(int x, int y){
        xpos = x;
        ypos = y;
        health = 100;
        sword = new Weapon("dagger");
        killedM = 0;
        //armor = new Armor("trousers");
        hides = 0;
        xp = 0;
    }

    public int getX(){
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    public double getHealth(){
        return health;
    }

    public Weapon getWeapon(){
        return sword;
    }

    public int getKilledM(){
        return killedM;
    }

    public Armor getArmor(){
        return armor;
    }

    public int getHides(){
        return hides;
    }

    public int getXP(){
        return xp;
    }

    public boolean getShowPpl(){
        return showPpl;
    }

    public void setX(int x){
        xpos = x;
    }

    public void setY(int y){
        ypos = y;
    }

    public void setWeapon(Weapon s){
        sword = s;
    }

    public void setHealth(double h){
        health = h;
    }

    public void setKilledM(int kM){
        killedM = kM;
    }

    public void setArmor(Armor a){
        armor = a;
    }

    public void setHides(int h){
        hides = h;
    }

    public void setXP(int experience){
        xp = experience;
    }
    
    public void setShowPpl(boolean p){
        showPpl = p;
    }
    
    public void setNumP(String t, int amt){
        if ( t.equals("half") ){
            nofH += amt;
        }else if ( t.equals("full") ){
            nofF += amt;
        }else if ( t.equals("phoenix") ){
            nofP += amt;
        }
    } 
    
    public boolean hasPotion(String t){
        boolean ret = false;
        if ( t.equals("half") ){
            if ( nofH != 0 ){
                ret = true;
            }
        }else if ( t.equals("full") ){
            if ( nofF != 0 ){
                ret = true;
            }
        }else if ( t.equals("phoenix") ){
            if ( nofP != 0 ){
                ret = true;
            }
        }
        return ret;
    }
    
    public void setNumBo(int amt){
        numBombs += amt;
    }
    
    public boolean hasBomb(){
        boolean ret = false;
        if (numBombs != 0){
            ret = true;
        }
        return ret;
    }
    //when we add a display screen, we should add the # of hides we have on here
}

