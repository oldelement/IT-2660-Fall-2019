package Final;

public class Listing{
	
    private int value;
    private boolean pushed;

    Listing(int l){
    	
        value = l;
    }
    
    void visit(){
    	
        System.out.println(this);
    }
    
    public String toString(){
    	
        return ("Vertex: " + value + "\n" );
    }

    Listing deepCopy(){
    	
        return new Listing(value);
    }
    
    boolean getPush(){
    	
        return !pushed;
    }
    
    void setPush(boolean value){
    	
        pushed = value;
    }
    
}