public class Hero{
    private int xpos;
    private int ypos;
    private double health;
    private Weapon sword;
    private int killedB;
    private Armor armor;
    private int hides;
    private int xp;
<<<<<<< HEAD
    private int gold;
    private boolean showPpl;
    private int NOH;
    private int NOF;
    private int NOP;
    private int numBo;
    private int numAR;
    private int numB;
    private int numLS;
    private boolean hasBP;
    
=======
    private boolean showPpl;
    private int nofH = 0;
    private int nofF = 0;
    private int nofP = 0;
    private int numBombs = 0;

>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
    public Hero(){
        xpos = 0;
        ypos = 14;
        health = 100;
        sword = new Weapon("dagger");
<<<<<<< HEAD
        killedB = 0;
        armor = new Armor("trousers");
=======
        killedM = 0;
        //armor = new Armor();
>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
        hides = 0;
        xp = 0;
        gold = 0;
    }

    public Hero(int x, int y){
        xpos = x;
        ypos = y;
        health = 100;
        sword = new Weapon("dagger");
<<<<<<< HEAD
        killedB = 0;
        armor = new Armor("trousers");
=======
        killedM = 0;
        //armor = new Armor("trousers");
>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
        hides = 0;
        xp = 0;
        gold = 0;
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
<<<<<<< HEAD
    public int getKilledB(){
        return killedB;
=======

    public int getKilledM(){
        return killedM;
>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
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
<<<<<<< HEAD
    public int getGold(){
        return gold;
    }
        public boolean getShowPpl(){
        return showPpl;
    }
    public int getBO(){
        return numBo;
    }
    public boolean getNOA(){
        return hasBP;
    }
    
=======

    public boolean getShowPpl(){
        return showPpl;
    }

>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
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
<<<<<<< HEAD
    public void setKilledB(int kB){
        killedB = kB;
=======

    public void setKilledM(int kM){
        killedM = kM;
>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
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
<<<<<<< HEAD
    public void setGold(int g){
        gold = g;
    }
    public void setShowPpl(boolean p){
        showPpl = p;
    }
    public void setBO(int amt){
        numBo += amt;
    }
    public void setBP(boolean b){
        hasBP = b;
    }

    
    public void setNOPot(String t, int amt){
        if ( t.equals("half") ){
            NOH += amt;
        }else if ( t.equals("full") ){
            NOF += amt;
        }else{
            NOP += amt;
        }
    }
    
    public int getNOPot(String t){
        if ( t.equals("half") ){
            return NOH;
        }else if ( t.equals("full") ){
            return NOF;
        }else{
            return NOP;
        }
    }
    
    
    
    
    
    public void setNOA(String t, int amt){
        if ( t.equals("trousers")||t.equals("satchel")){
            numB += amt;
        }else{
            numLS += amt;
        }
    }
    
    public int getNOA(String t, int amt){
        if ( t.equals("trousers")||t.equals("satchel")){
            return numB;
        }else{
            return numLS;
        }
    }
    
    
    
    

    
=======
    
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
>>>>>>> d6349c8451da8ae554c3392913a1a88a8b8d7a63
    //when we add a display screen, we should add the # of hides we have on here
}

