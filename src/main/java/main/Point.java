package main;

import static main.Main.board;

public abstract class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getActualPoint(){
        return new int[]{this.x,this.y};
    }
}

