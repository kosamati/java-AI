import main.Board;
import main.GenerationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.Main.*;

public class GenerationControllerTest {

    @BeforeEach
    public void setUp(){
        population = 100;
        mutationRate = 0.01;
        board = new Board(200, 200);
        cellList.clear();
    }
    @Test
    public void createNewGenerationTestWhenNumberOffCellsEqualOne(){
        cellList.add(GenerationController.createRandomCell());
        String result = "";
        try{
            GenerationController.createNewGeneration();

        }
        catch (Exception e){
            result = String.valueOf(e);
        }
        Assertions.assertEquals("java.lang.Exception: Too little cells alive",result);

    }
    @Test
    public void createNewGenerationTestWhenNumberOffCellsEqualTwo(){
        cellList.add(GenerationController.createRandomCell());
        cellList.add(GenerationController.createRandomCell());

        try{
            cellList = GenerationController.createNewGeneration();
        }
        catch (Exception e){
            System.out.println(e);
        }
        Assertions.assertEquals(population,cellList.size());

    }
    @Test
    public void createNewGenerationTestWhenNumberOffCellsEqualThree(){

        cellList.add(GenerationController.createRandomCell());
        cellList.add(GenerationController.createRandomCell());
        cellList.add(GenerationController.createRandomCell());

        try{
            cellList = GenerationController.createNewGeneration();
        }
        catch (Exception e){
            System.out.println(e);
        }
        Assertions.assertEquals(population,cellList.size());

    }
}
