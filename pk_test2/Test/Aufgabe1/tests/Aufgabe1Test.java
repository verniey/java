import static org.junit.Assert.assertArrayEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertArrayEquals;

public class Aufgabe1Test {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void testRepeat1Size5General() throws Exception {

        int[] array = new int[]{15,14,10,12,17};
        Aufgabe1.repeat(array,2,1);
        int[] expected = new int[]{15,14,10,10,12};
        assertArrayEquals(expected, array);

    }

    @Test
    public void testRepeat2Size5General() throws Exception {

        int[] array = new int[]{15,14,10,12,17};
        Aufgabe1.repeat(array,1,2);
        int[] expected = new int[]{15,14,14,14,10};
        assertArrayEquals(expected, array);

    }
@Test
    public void testRepeat3Size10General() throws Exception {

        int[] array = new int[]{15,14,10,12,17,15,2,12,9,10};
        Aufgabe1.repeat(array,1,3);
        int[] expected = new int[]{15,14,14,14,14,10,12,17,15,2};
        assertArrayEquals(expected, array);

    }

    @Test
    public void testRepeat3Size5General() throws Exception {

        int[] array = new int[]{15,14,10,12,17};
        Aufgabe1.repeat(array,1,3);
        int[] expected = new int[]{15,14,14,14,14};
        assertArrayEquals(expected, array);

    }

    @Test
    public void testExpandSize5General() throws Exception {

        int[] array = new int[]{1,2,3,4,5};
        int[] result = Aufgabe1.expand(array,1);
        int[] expected = new int[]{1,2,2,2,3,4,5};
        assertArrayEquals(expected, result);

    }



}