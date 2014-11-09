/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.util.ArrayList;

/**
 *
 * @author Holly
 */
public abstract class CompositeComponent implements BodyComponent{
    protected ArrayList<BodyComponent> children;
    
    public CompositeComponent(){
        children = new ArrayList<BodyComponent>();
    }
    
    public void add(BodyComponent component){
        children.add(component);
    }
    
    public void remove(BodyComponent component){
        children.remove(component);
    }
    
    public BodyComponent getChild(int i){
        return children.get(i);
    }
}
