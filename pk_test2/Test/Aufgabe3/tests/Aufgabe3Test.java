import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;

public class Aufgabe3Test {

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    // liefert die i+1 niedrigstwertigen Ziffern der Dezimaldarstellung von 'n' als String
    // (die Einerstelle steht darin ganz rechts). Ziffern werden durch ',' getrennt.
    // Vorbedingung: n > 0
    public static String digits(int n, int i) {
        String s = "";
        do {
            s = i <= 0 ? s : n%10 + (s.equals("") ? "" : "," + s);
            n /= 10;
            i--;
        } while (n > 0);
        return s;
    }

    // Vorbedingung: x >= 0 und y > 0
    public static boolean f(int x, int y) {
        return x < y ? x == 0 : f(x-y, y);
    }

    // Liefert den maximalen Rest der Division durch 'divisor' über alle Einträge in 'array' zurück.
    // Vorbedingung: array != null und array.length > 0.
    public static int largestRemainder(int[] array, int divisor) {
        int max = array[0] % divisor;
        while(array.length > 1) {
            array = java.util.Arrays.copyOfRange(array, 1, array.length);
            int remainder = array[0] % divisor;
            if (max < remainder) {
                max = remainder;
            }
        }
        return max;
    }

    @Test
    public void testDigitsWithoutSeparator() throws Exception {
        for (int n = 1; n < 100000; n++) {
            for (int i = 0; i < 6; i++) {
                Assert.assertThat(Aufgabe3.digits(n, i).replaceAll(",", ""),
                        is(Aufgabe3Test.digits(n,i).replaceAll(",", "")));
            }
        }
    }

    @Test
    public void testDigitsFull() throws Exception {
        for (int n = 1; n < 100000; n++) {
            for (int i = 0; i < 6; i++) {
                Assert.assertThat(Aufgabe3.digits(n, i),
                        is(Aufgabe3Test.digits(n,i)));
            }
        }
    }

    @Test
    public void testF() throws Exception {
        for(int x = 0; x < 100; x++) {
            for (int y = 1; y < 100; y++) {
                Assert.assertThat(Aufgabe3.f(x,y),
                        is(Aufgabe3Test.f(x, y)));
            }
        }
    }

    @Test
    public void testLargestRemainder() throws Exception {
        int[] array = {1,2,3,4,3,2,1};
        Assert.assertThat(Aufgabe3.largestRemainder(array,2), is(Aufgabe3Test.largestRemainder(array,2)));
        Assert.assertThat(Aufgabe3.largestRemainder(array,5), is(Aufgabe3Test.largestRemainder(array,5)));
    }

    @Test
    public void testLargestRemainderRandom() throws Exception {
        for (int i = 0; i < 100; i++) {
            Random rn = new Random();
            int[] array = {rn.nextInt(),
                    rn.nextInt(),
                    rn.nextInt(),
                    rn.nextInt(),
                    rn.nextInt()};
            int divisor = rn.nextInt() + 1;
            Assert.assertThat(Aufgabe3.largestRemainder(array, divisor), is(Aufgabe3Test.largestRemainder(array, divisor)));
        }
    }

}