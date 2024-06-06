package main;

import java.util.ArrayList;
import java.util.Random;

import static main.Main.*;

public class GenerationController {
    private static final Random random  = new Random();

    public static ArrayList<Cell> createStartingGeneration(){
        ArrayList<Cell> list = new ArrayList<>();
        for (int i=0;i<population;i++){
            list.add(createRandomCell());
        }
        return list;
    }

    public static ArrayList<Cell> createNewGeneration() throws Exception {
        ArrayList<Cell> newList = new ArrayList<>();
        int childrenPerCouple = (population / cellList.size()) * 2;

        if (cellList.size() > 1){
            while (cellList.size() > 1){
                for (int i=0;i<childrenPerCouple;i++){
                    Cell temporaryCell;

                    if(random.nextDouble()<mutationRate) temporaryCell = createRandomCell();
                    else temporaryCell = new Cell(createInputSetFromSeed(), (CellPoint) createRandomPosition());

                    newList.add(temporaryCell);
                }
                cellList.remove(0);
                cellList.remove(0);
            }
        }
        else throw new Exception("Too little cells alive");


        while (newList.size() < population){
            newList.add(newList.get(random.nextInt(newList.size()-1)));
        }

        return newList;
    }

    public static Cell createRandomCell(){
        return new Cell(createRandomInputSet(), (CellPoint) createRandomPosition());
    }

    private static Point createRandomPosition(){
        int x = random.nextInt(board.getWidth() - 2) + 1;
        int y = random.nextInt(board.getHeight() - 2) + 1;
        return new CellPoint(x,y);
    }

    private static InputSet createRandomInputSet(){
        InputSet temporaryInputSet = new InputSet(
                createRandomInput("topWeight"),
                createRandomInput("bottomWeight"),
                createRandomInput("leftWeight"),
                createRandomInput("rightBottom")
        );
        return temporaryInputSet;
    }

    private static Input createRandomInput(String name){
        return new Input(name,random.nextDouble());
    }

    private static InputSet createInputSetFromSeed(){
        InputSet newInputSet = new InputSet(
                createInputFromSeed("topWeight",0),
                createInputFromSeed("bottomWeight",1),
                createInputFromSeed("leftWeight",2),
                createInputFromSeed("rightWeight",3)
        );
        return newInputSet;
    }

    private static Input createInputFromSeed(String name, int inputNumber){
        double[] firstParentValueArray = cellList.get(0).inputValueList();
        double[] secondParentValueArray = cellList.get(1).inputValueList();
        double newValue = (firstParentValueArray[inputNumber] + secondParentValueArray[inputNumber]) / 2 + (random.nextDouble()*0.02-0.01);
        return new Input(name,newValue);
    }
}
