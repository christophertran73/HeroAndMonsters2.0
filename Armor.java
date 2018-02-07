public class Armor extends Item{
    private double defense;
    
    public Armor(){
        super();
        defense = 0;
    }
    
    public Armor(String t){
        super(t, 0);
        setDANDP(t);
    }
    
    public void setDANDP(String t){
        if ( t.equals("wood") ){
            defense = .20;
            setPrice(2);
        }else if ( t.equals("metal") ){
            defense = .50;
            setPrice(3);
        }else{
            defense = .10;
            setPrice(1);
        }
    }
    
    public double getDef(){
        return defense;
    }
}
