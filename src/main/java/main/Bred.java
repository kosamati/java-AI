package main;

import java.util.ArrayList;
import java.util.Random;

public class Bred {
    private final Random random  = new Random();

    public ArrayList<Cell> generation0(int populationSize,Board board){

        ArrayList<Cell> list = new ArrayList<>();

        for (int i=0;i<populationSize;i++){
            Cell temp = new Cell(new Input("topWeight",random.nextDouble()),
                    new Input("bottomWeight",random.nextDouble()),
                    new Input("leftWeight",random.nextDouble()),
                    new Input("rightBottom",random.nextDouble()),
                     random.nextInt(board.getWidth() - 2) + 1,
                    random.nextInt(board.getHeight() - 2) + 1, board);
            list.add(temp);

        }
        return list;
    }
    public ArrayList<Cell> allive(ArrayList<Cell> oldList,SaveZone zone){
        ArrayList<Cell> newList = new ArrayList<>();
        for (Cell cell : oldList){
            if (cell.getPositionY() >=zone.getStartY() && cell.getPositionY() <=zone.getEndY() &&
                    cell.getPositionX() >=zone.getStartX() && cell.getPositionX() <=zone.getEndX() ) newList.add(cell);
        }
        return newList;
    }

    public ArrayList<Cell> newGeneration(ArrayList<Cell> oldList,int population,double mutationRate,Board board){
        ArrayList<Cell> newList = new ArrayList<>();
        int childrenRate = population/ oldList.size();

        while (oldList.size()>2){

            for (int j=0;j<childrenRate*2;j++){
                Cell temp;
                if(random.nextDouble()<mutationRate){
                    temp = new Cell(new Input("topWeight",random.nextDouble()),
                            new Input("bottomWeight",random.nextDouble()),
                            new Input("leftWeight",random.nextDouble()),
                            new Input("rightBottom",random.nextDouble()),
                            random.nextInt(board.getWidth() - 2) + 1,
                            random.nextInt(board.getHeight() - 2) + 1, board);
                }
                else {
                    temp = new Cell(
                            new Input("topWeight",
                                    (oldList.get(0).getInput0().getValue()+oldList.get(1).getInput0().getValue())/2+(random.nextDouble()*0.02-0.01)),
                            new Input("bottomWeight",
                                    (oldList.get(0).getInput1().getValue()+oldList.get(1).getInput1().getValue())/2+(random.nextDouble()*0.02-0.01)),
                            new Input("leftWeight",
                                    (oldList.get(0).getInput2().getValue()+oldList.get(1).getInput2().getValue())/2+(random.nextDouble()*0.02-0.01)),
                            new Input("rightBottom",
                                    (oldList.get(0).getInput3().getValue()+oldList.get(1).getInput3().getValue())/2+(random.nextDouble()*0.02-0.01)),
                            random.nextInt(board.getWidth() - 2) + 1,
                            random.nextInt(board.getHeight() - 2) + 1, board);

                }

                newList.add(temp);

            }
            oldList.remove(0);
            oldList.remove(1);
        }
        while (newList.size()<population){
            newList.add(newList.get(random.nextInt(newList.size()-1)));
        }




        return newList;
    }



}
