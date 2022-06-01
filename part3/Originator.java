package part3;

import q3.Swimmable;

/**
 * class Originator:
 * class Memento design pattern
 * 
 * @author Daniel Markov ,Anton Volkov
 */
public class Originator {

    private Swimmable s=null;
    private Immobile i=null;


    
    /** 
     * set the swimmable
     * @param s
     */
    public void setSwimmable(Swimmable s){
       this.s = s;
    }

    
    
    /** 
     * set the immobile
     * @param i
     */
    public void setImmobile(Immobile i){
        this.i = i;
     }
 
    
    /** 
     * get the swimmable
     * @return Swimmable
     */
    public Swimmable getSwimmable(){
       return s;
    }

    
    /** 
     * get the immobile
     * @return Immobile
     */
    public Immobile getImmobile(){
        return i;
     }
 
    
    /** 
     * save the swimmable to the memento (create new memento)
     * @return Memento
     */
    public Memento saveSwimmableToMemento(){
        return new Memento(s);
    }

    
    /** 
     * save the Immobile to the memento (create new memento)
     * @return Memento
     */
    public Memento saveImmobileToMemento(){
        return new Memento(i);
    }
 
    
    /** 
     * get the swimmable from the memento
     * @param memento
     */
    public void getSwimmableFromMemento(Memento memento){
        s = memento.getSwimmable();
    }

    
    /** 
     * get the swimmable from the memento
     * @param memento
     */
    public void getImmobileFromMemento(Memento memento){
        i = memento.getImmobile();
    }
    
}
