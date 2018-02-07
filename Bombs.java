public class Bombs extends Item{
    private boolean used;
    
    public Bombs(){
        super();
        used = false;
    }
    
    public Bombs(String t){
        super(t, 3);
        used = false;
    }
    
    public boolean getUsed(){
        return used;
    }
    
    public void setUsed(boolean u){
        used = u;
    }
}