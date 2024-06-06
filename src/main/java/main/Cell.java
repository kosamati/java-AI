package main;

import java.util.ArrayList;

public class Cell {
    private final InputSet inputSet;
    private CellPoint position;


    public Cell(InputSet inputSet, CellPoint position) {
        this.inputSet = inputSet;
        this.position = position;
    }

    public void makeMove(){
        double random = Math.random() * 1;
        ArrayList<Double> directionsChanceList;
        directionsChanceList = this.inputSet.chanceList();

        if (random < directionsChanceList.get(0) && this.position.isMoveUpAvailable()) {
            this.position.moveUp();
        }
        else if ( random < directionsChanceList.get(1) && this.position.isMoveDownAvailable()) {
            this.position.moveDown();
        }
        else if ( random < directionsChanceList.get(2) && this.position.isMoveLeftAvailable()) {
            this.position.moveLeft();
        }
        else if ( random < directionsChanceList.get(3) && this.position.isMoveRightAvailable())  {
            this.position.moveRight();
        }
    }
    public int[] getActualPosition(){
        return this.position.getActualPoint();
    }
    public double[] inputValueList(){
        return this.inputSet.inputValueList();
    }

}
