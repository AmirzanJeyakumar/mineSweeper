import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class gridTest {

    @Test
    public void testGrid() {

        Grid test = new Grid();
        Assertions.assertEquals(5,test.getRows(),"Incorrect row number");

}
}
