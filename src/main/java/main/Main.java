package main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static SafeZone safeZone = new SafeZone(
            new BoardPoint(0,0),
            new BoardPoint(200,40)
    );
    public static Board board = new Board(200, 200);
    public static List<Cell> cellList= new ArrayList<>();
    public static int population = 100;
    public static double mutationRate = 0.01;

    public static void main(String[] args) throws IOException {
        cellList = GenerationController.createStartingGeneration();

        for (int k=0;k<=10000;k++){
            System.out.println(k);
            for (int i=0;i<300;i++){
                for (Cell cell : cellList){
                    cell.makeMove();
                }
            }

                cellList = AliveChecker.aliveList();
                System.out.println(cellList.size());

               try {
                   cellList = GenerationController.createNewGeneration();
               }
               catch (Exception e){
                   System.out.println(e);
                   break;
               }

            System.gc();
        }


    }
}
