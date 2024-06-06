package main;

import static main.Main.board;

public class CellPoint extends Point {

    public CellPoint(int x, int y) {
        super(x, y);
    }

    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public boolean isMoveUpAvailable() {
        return this.y > 0;
    }

    public boolean isMoveDownAvailable() {
        return this.y < board.getHeight();
    }

    public boolean isMoveLeftAvailable() {
        return this.x > 0;
    }

    public boolean isMoveRightAvailable() {
        return this.y < board.getWidth();
    }

}
