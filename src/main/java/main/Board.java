package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private final SaveZone saveZone;
    private final List<Chunk> chunkList = new ArrayList<>();

    public Board(int width, int height, SaveZone saveZone) {
        this.width = width;
        this.height = height;
        this.saveZone = saveZone;
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }
}
