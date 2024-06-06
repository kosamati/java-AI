package main;

import java.util.ArrayList;

import static main.Main.cellList;
import static main.Main.safeZone;

public class AliveChecker {
    public static ArrayList<Cell> aliveList(){
        ArrayList<Cell> newList = new ArrayList<>();
        for (Cell cell : cellList){
            if (isAlive(cell)){
                newList.add(cell);
            }
        }
        return newList;
    }

    public static boolean isAlive(Cell cell){
        int[] cellPosition = cell.getActualPosition();
        int cellX = cellPosition[0];
        int cellY = cellPosition[1];

        int[] safeZoneStartPosition = safeZone.getStartPoint();
        int safeZoneStartX = safeZoneStartPosition[0];
        int safeZoneStartY = safeZoneStartPosition[1];

        int[] safeZoneEndPosition = safeZone.getEndPoint();
        int safeZoneEndX = safeZoneEndPosition[0];
        int safeZoneEndY = safeZoneEndPosition[1];

        return cellY >= safeZoneStartY && cellY <= safeZoneEndY && cellX >= safeZoneStartX && cellX <= safeZoneEndX;
    }
}
