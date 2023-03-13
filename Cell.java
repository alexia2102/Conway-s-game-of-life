package conway.s.game.of.life;

//import org.junit.Test;
//import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cell {
   private boolean live;
   private int vecini;
    private int x;
    private int y;


    public Cell(boolean live, int vecini, int x, int y) {
        this.live = live;
        this.vecini = vecini;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(live) + " ";
    }

    public int getVecini() {
        return vecini;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive() {
        this.live = true;
    }

    public void setDeath() {
        this.live =  false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static List updateVecini(List<Cell> list){

        List<Cell> l2 = new ArrayList<>();
        for(Cell c: list) {
            Cell copy = new Cell(c.live, 0, c.x, c.y);
            for(Cell c2:list)
                if(Math.abs(c.x-c2.x)<=1 && Math.abs(c.y-c2.y)<=1&& c2.live==true &&!(c.equals(c2)))
                    copy.vecini+=1;
            l2.add(copy);
        }
        
        
        
       return l2;
    }
}