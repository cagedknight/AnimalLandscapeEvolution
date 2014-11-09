/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalWorld;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board<T extends Organism>{
    
    private List<T> animalList;
    private Organism[][] board;
    
    
    public Board(){
        animalList = new LinkedList<T>();
        board = new Organism[500][500];
    }
    
    public void addActor(T org){
        try{
            int[] tempLoc = nearestClosest(null, org.getX(), org.getY());
            board[tempLoc[0]][tempLoc[1]] = org;
            animalList.add(org);
        }
        catch(BadLocationException e){
            System.out.println("Bad Location Exception:" + e.getMessage());
        }
    }
    
    public int[] nearestClosest(T org, int x, int y) throws BadLocationException{
        if(board[x][y] == org)
            return new int[]{x,y};
        for(int i = 1; i <= 100; i++){
            if(x <= i){
                if(y <= i){            
                    if(board[x + i][y] == org)
                        return new int[]{x + i,y};
                    
                    else if(board[x + i][y + i] == org)
                        return new int[]{x + i,y + i};
                    
                    else if(board[x][y + i] == org)
                        return new int[]{x,y+i};
                }
                
                else if(y >= (board[0].length-i)){
                    if(board[x][y - i] == org)
                        return new int[]{x,y-i};
        
                    else if(board[x + i][y] == org)
                        return new int[]{x + i,y};
                    
                    else if(board[x + i][y - i] == org)
                        return new int[]{x + i, y - i};
                    
                }
                
                else{
                    if(board[x][y-i] == org)
                        return new int[]{x,y-i};
                    
                    if(board[x+i][y-i] == org)
                        return new int[]{x+i,y-i};
                    
                    if(board[x+i][y] == org)
                        return new int[]{x+i,y};
                    
                    if(board[x][y+i] == org)
                        return new int[]{x,y+i};
                    
                    if(board[x+i][y+i] == org)
                        return new int[]{x+i,y+i};
                }
            }
            
            else if(y <= i){
                if(x >= (board.length-i)){
                    if(board[x-i][y] == org)
                        return new int[]{x-i,y};
        
                    else if(board[x][y+i] == org)
                        return new int[]{x,y+i};
                    
                    else if(board[x - i][y + i] == org)
                        return new int[]{x - i, y + i};
                }
                
                else{
                    if(board[x - i][y] == org)
                        return new int[]{x - i,y};
                    
                    if(board[x-i][y+i] == org)
                        return new int[]{x-i,y+i};
                    
                    if(board[x+i][y] == org)
                        return new int[]{x+i,y};
                    
                    if(board[x][y+i] == org)
                        return new int[]{x,y+i};
                    
                    if(board[x+i][y+i] == org)
                        return new int[]{x+i,y+i};
                }
            }
            
            else if(x >= (board.length - i)){
                if(y >= (board[0].length - i)){
                    if(board[x-i][y] == org)
                        return new int[]{x-i,y};
                    
                    else if(board[x-i][y-i] == org)
                        return new int[]{x-i,y-i};
                    
                    else if(board[x][y-i] == org)
                        return new int[]{x,y-i};
                    
                }
                
                else{
                    if(board[x][y+i] == org)
                        return new int[]{x,y+i};
                    else if(board[x-i][y+i] == org)
                        return new int[]{x-i,y+i};
                    else if(board[x-i][y] == org)
                        return new int[]{x-i,y};
                    else if(board[x-i][y-i] == org)
                        return new int[]{x-i,y-i};
                    else if(board[x][y-i] == org)
                        return new int[]{x,y-i};
                }
            }
            
            else if(y >= (board[0].length - i)){
                if(board[x+i][y] == org)
                    return new int[]{x+i,y};
                else if(board[x+i][y-i] == org)
                    return new int[]{x+i,y-i};
                else if(board[x][y-i] == org)
                    return new int[]{x,y-i};
                else if(board[x-i][y-i] == org)
                    return new int[]{x-i,y-i};
                else if(board[x-i][y] == org)
                    return new int[]{x-i,y};
            }
            else{
                if(board[x][y+i] == org)
                    return new int[]{x,y+i};
                else if(board[x-i][y+i] == org)
                    return new int[]{x-i,y+i};
                else if(board[x-i][y] == org)
                    return new int[]{x-i,y};
                else if(board[x-i][y-i] == org)
                    return new int[]{x-i,y};
                else if(board[x][y-i] == org)
                    return new int[]{x,y-i};
                else if(board[x+i][y-i] == org)
                    return new int[]{x+i,y-i};
                else if(board[x+i][y] == org)
                    return new int[]{x+i,y};
                else if(board[x+i][y+i] == org)
                    return new int[]{x+i,y+i};
            }
        }
        throw new BadLocationException("Your animal is bad and should feel bad");
    }
    
    public Iterator<T> aniListIterator(){
        return new AnimalIterator(animalList.iterator());
    }
    
    protected static class AnimalIterator<S> implements Iterator{
        private Iterator<S> aniList;
        
        private AnimalIterator(Iterator<S> iter){
            aniList = iter;
        }
        
        @Override
        public boolean hasNext(){
            if(aniList.hasNext())
                return true;
            else
                return false;
        }
        
        @Override
        public S next(){
            if(aniList.hasNext()){
                return aniList.next();
            }
            else
                throw new NoSuchElementException();
        }
        
        @Override
        public void remove(){
            throw new UnsupportedOperationException("No Admittance");
        }
    }
}
