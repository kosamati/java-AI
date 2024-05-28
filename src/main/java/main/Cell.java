package main;

public class Cell {
    private final Input input0;
    private final Input input1;
    private final Input input2;
    private final Input input3;
    private int positionX;
    private int positionY;
    private final double count;
    private final Board board;


    public Cell(Input i0,Input i1,Input i2,Input i3, int positionX, int positionY, Board board) {
        this.input0 = i0;
        this.input1 = i1;
        this.input2 = i2;
        this.input3 = i3;
        this.positionX = positionX;
        this.positionY = positionY;
        this.board = board;
        if (this.input0.getValue() < 0) this.input0.setValue(0);
        if (this.input1.getValue() < 0) this.input1.setValue(0);
        if (this.input2.getValue() < 0) this.input2.setValue(0);
        if (this.input3.getValue() < 0) this.input3.setValue(0);
        this.count = this.input0.getValue() + this.input1.getValue() + this.input2.getValue() + this.input3.getValue();
        this.input0.setChance(this.input0.getValue()/this.count);
        this.input1.setChance(this.input0.getChance()+this.input1.getValue()/this.count);
        this.input2.setChance(this.input1.getChance()+this.input2.getValue()/this.count);
        this.input3.setChance(this.input2.getChance()+this.input3.getValue()/this.count);

    }
    public void makeMove(){
        double random = Math.random() * this.count;

        if (random < this.input0.getChance() && this.positionY>0 ) this.positionY--;
        else if ( random < this.input1.getChance() && this.positionY<this.board.getHeight() ) this.positionY++;
        else if ( random < this.input2.getChance() && this.positionX>0 ) this.positionX--;
        else if ( random < this.input3.getChance() && this.positionX<this.board.getWidth() ) this.positionX++;
    }


    public int getPositionX() {
        return positionX;
    }


    public int getPositionY() {
        return positionY;
    }



    public Input getInput0() {
        return input0;
    }


    public Input getInput1() {
        return input1;
    }

    public Input getInput2() {
        return input2;
    }

    public Input getInput3() {
        return input3;
    }

    public String position(){
        return String.valueOf(this.positionX)+";"+String.valueOf(this.positionY);
    }
}
