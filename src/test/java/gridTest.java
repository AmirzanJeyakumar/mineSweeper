import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class gridTest {

    @Test
    public void testGrid() {

        Grid test = new Grid();
        Assertions.assertEquals(5,test.getRows(),"Incorrect row number");
        Assertions.assertEquals(5,test.getColumns(),"Incorrect column number");
        Assertions.assertEquals(5,test.getNumOfMines(),"Incorrect number of mines");

        
}
}
