package main;

import java.util.ArrayList;

public class InputSet {
    private final Input directionTop;
    private final Input directionBottom;
    private final Input directionLeft;
    private final Input directionRight;
    private final double suma;

    public InputSet(Input directionTop, Input directionBottom, Input directionLeft, Input directionRight) {
        this.directionTop =  removeNegativeValue(directionTop);
        this.directionBottom = removeNegativeValue(directionBottom);
        this.directionLeft = removeNegativeValue(directionLeft);
        this.directionRight = removeNegativeValue(directionRight);
        this.suma = this.directionTop.getValue() + this.directionBottom.getValue() + this.directionLeft.getValue() + this.directionRight.getValue();
    }

    private Input removeNegativeValue(Input input){
        if (input.getValue() < 0 ){
            input.setValue(0);
            return input;
        }
        return input;
    }

    public ArrayList<Double> chanceList(){
        ArrayList<Double> chances = new ArrayList<>();
        double moveTowardsTopChance = this.directionTop.getValue()/this.suma;
        double moveTowardsBottomChance = moveTowardsTopChance+this.directionBottom.getValue()/this.suma;
        double moveTowardsLeftChance = moveTowardsBottomChance+this.directionLeft.getValue()/this.suma;
        double moveTowardsRightChance = moveTowardsLeftChance+this.directionRight.getValue()/this.suma;
        chances.add(moveTowardsTopChance);
        chances.add(moveTowardsBottomChance);
        chances.add(moveTowardsLeftChance);
        chances.add(moveTowardsRightChance);
        return chances;
    }

    public double getSuma() {
        return suma;
    }

    public double[] inputValueList(){
        double[] inputValueList = {
                this.directionTop.getValue(),
                this.directionBottom.getValue(),
                this.directionLeft.getValue(),
                this.directionRight.getValue()
        };
        return inputValueList;
    }
}
