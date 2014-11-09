/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

/**
 *
 * @author Holly
 */
public interface BodyComponent {
    public void add(BodyComponent component);
    public void remove(BodyComponent component);
    public BodyComponent getChild(int i);
}
