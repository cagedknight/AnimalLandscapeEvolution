/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AnimalWorld;

/**
 *
 * @author davidbenoit
 */
public abstract class LeafComponent implements BodyComponent {
    
    public LeafComponent(){
        
    }
    
    public void add(BodyComponent component){}
    public void remove(BodyComponent component){}
    public BodyComponent getChild(int i){
        throw new LeafComponentException(String str);
    }      
}