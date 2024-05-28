package main;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Main {
    public static SaveZone saveZone = new SaveZone(0,200,0,40);
    public static Board board = new Board(200, 200, saveZone);
    public static List<Cell> cellList= new ArrayList<>();
    public static Bred bred = new Bred();
    public static int pop = 100;

    public static void main(String[] args) throws IOException {

        Path path = Path.of("");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(Calendar.getInstance().getTime());
        Path newDirectory = Files.createDirectory(path.resolve(timeStamp));

        String test;
        System.out.println("Generacja 0");

        cellList = bred.generation0(pop,board);
        for (int k=1;k<=1000;k++){
            test = "";
            test +="200;rozmiar\n";

            System.out.println("Generacja "+String.valueOf(k));
            cellList = bred.newGeneration((ArrayList<Cell>) cellList,pop,1/10,board);

            for (int i=0;i<300;i++){
                test += "step\n";

                for (Cell cell : cellList){
                    cell.makeMove();
                    test += cell.position()+"\n";
                }
            }

            Path generateFile = Files.createFile(newDirectory.resolve(String.valueOf(k)+".txt"));
            Files.write(generateFile, Collections.singleton(test), StandardCharsets.UTF_8);

            cellList = bred.allive((ArrayList<Cell>) cellList,saveZone);
            System.out.println(cellList.size());

            System.gc();
        }
    }
}
