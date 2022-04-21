import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

public class Aufgabe2Test {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testBargraphGeneral() throws Exception {
        char[][] expectedResult = new char[5][9];
        expectedResult[4] = new char[] {'.','.','#','.','.','.','.','.'};
        expectedResult[3] = new char[] {'.','.','#','#','.','.','.','.'};
        expectedResult[2] = new char[] {'.','#','#','#','.','.','.','.'};
        expectedResult[1] = new char[] {'.','#','#','#','#','.','.','.'};
        expectedResult[0] = new char[] {'#','#','#','#','#','.','#','.'};
        char[][] result = Aufgabe2.bargraph(new int[]{1,3,5,4,2,0,1,0});
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testBargraphOneColumn1() throws Exception {
        char[][] expectedResult = new char[1][1];
        expectedResult[0] = new char[] {'#'};
        char[][] result = Aufgabe2.bargraph(new int[]{1});
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testBargraphOneColumn2() throws Exception {
        char[][] expectedResult = new char[4][1];
        expectedResult[3] = new char[] {'#'};
        expectedResult[2] = new char[] {'#'};
        expectedResult[1] = new char[] {'#'};
        expectedResult[0] = new char[] {'#'};
        char[][] result = Aufgabe2.bargraph(new int[]{4});
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testAxisGeneral1() throws Exception {
        char[][] input = new char[5][9];
        input[4] = new char[] {'.','.','#','.','.','.','.','.'};
        input[3] = new char[] {'.','.','#','#','.','.','.','.'};
        input[2] = new char[] {'.','#','#','#','.','.','.','.'};
        input[1] = new char[] {'.','#','#','#','#','.','.','.'};
        input[0] = new char[] {'#','#','#','#','#','.','#','.'};
        char[][] result = Aufgabe2.axis(input);
        char[][] expectedResult = new char[6][9];
        expectedResult[5] = new char[] {'.','.','#','.','.','.','.','.'};
        expectedResult[4] = new char[] {'.','.','#','#','.','.','.','.'};
        expectedResult[3] = new char[] {'.','#','#','#','.','.','.','.'};
        expectedResult[2] = new char[] {'.','#','#','#','#','.','.','.'};
        expectedResult[1] = new char[] {'#','#','#','#','#','.','#','.'};
        expectedResult[0] = new char[] {'0','1','2','3','4','5','6','7'};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testAxisGeneral2() throws Exception {
        char[][] input = new char[3][3];
        input[2] = new char[] {'#','#','#'};
        input[1] = new char[] {'#','#','#'};
        input[0] = new char[] {'#','#','#'};
        char[][] result = Aufgabe2.axis(input);
        char[][] expectedResult = new char[4][3];
        expectedResult[3] = new char[] {'#','#','#'};
        expectedResult[2] = new char[] {'#','#','#'};
        expectedResult[1] = new char[] {'#','#','#'};
        expectedResult[0] = new char[] {'0','1','2'};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testAxisOneColumn() throws Exception {
        char[][] input = new char[3][1];
        input[2] = new char[] {'#'};
        input[1] = new char[] {'#'};
        input[0] = new char[] {'#'};
        char[][] result = Aufgabe2.axis(input);
        char[][] expectedResult = new char[4][1];
        expectedResult[3] = new char[] {'#'};
        expectedResult[2] = new char[] {'#'};
        expectedResult[1] = new char[] {'#'};
        expectedResult[0] = new char[] {'0'};
        Assert.assertArrayEquals(expectedResult, result);
    }

}