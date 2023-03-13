package conway.s.game.of.life;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\Conway's game of life\\src\\conway\\s\\game\\of\\life\\input"));
        String line = reader.readLine();
        List <Cell> initial = new ArrayList();
        for(int i = 0; i < 5; i ++)
            for(int j = 0; j < 5; j++) {
                if(line == null) {
                    System.out.println("Inputul nu e ok");
                    return ;
                }
                String [] info = line.split(" ");
                initial.add(new Cell(Boolean.valueOf(info[0]), Integer.parseInt(info[1]), i, j));
                line = reader.readLine();
            }

        reader.close();
        initial = Cell.updateVecini(initial);
        for(int i = 0; i < initial.size(); i++){
            System.out.print(initial.get(i).toString() + " ");
            if((i + 1) % 5 == 0) System.out.println();;
        }
        System.out.println("A 2 a incercare");
        Predicate<Cell> liveOrIisus = cell -> (cell.getVecini() == 3 && cell.isLive() == false)
                || (cell.getVecini() == 2 && cell.isLive() == true) ||
                (cell.getVecini() == 3 && cell.isLive() == true);
        Predicate<Cell> killCell = cell -> cell.isLive() == true && (cell.getVecini() < 2 || cell.getVecini() > 3 );
        List<Cell> result = initial.stream().filter(liveOrIisus)
                .collect(Collectors.toList());
        for(Cell c : result)
            c.setLive();
        List<Cell> result2 = initial.stream().filter(killCell)
                .collect(Collectors.toList());
        for (Cell c: result2)
            c.setDeath();
        initial = Cell.updateVecini(initial);
        for(int i = 0; i < initial.size(); i++){
            System.out.print(initial.get(i).toString() + " ");
            if((i + 1) % 5 == 0) System.out.println();;
        }

    }

}