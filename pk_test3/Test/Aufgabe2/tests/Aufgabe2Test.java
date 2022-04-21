import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe2Test {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testPrintLevel() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        String expected = "72";
        log.clear();
        tree.printLevel(1);
        String result = log.getLog().replaceAll("\\s","");
        assertThat(result, is(expected));

        expected = "861";
        log.clear();
        tree.printLevel(2);
        result = log.getLog().replaceAll("\\s","");
        assertThat(result, is(expected));
        log.clear();


    }

    @Test
    public void testSumGreaterEqual5() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.sumGreaterEqual(5), is(26));

    }

    @Test
    public void testSumGreaterEqual15() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.sumGreaterEqual(15), is(0));

    }

}