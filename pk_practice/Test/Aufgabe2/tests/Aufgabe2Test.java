import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Aufgabe2Test {

    @Test
    public void testEmptyToString() throws Exception {

        Tree tree = new Tree();

        assertThat(tree.toString().replaceAll("\\s", ""), is("[]"));

    }

    @Test
    public void testToString() throws Exception {

        Tree tree = new Tree();

        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(5);
        tree.add(2);

        assertThat(tree.toString().replaceAll("\\s", ""), is("[1,2,2,3,4,5]"));

    }

    @Test
    public void testEmptyCountLeaves() throws Exception {

        Tree tree = new Tree();

        assertThat(tree.countFromLevel(0), is(0));

    }

    @Test
    public void testCountLevelAll() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.countFromLevel(0), is(6));

    }

    @Test
    public void testCountLevel1() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.countFromLevel(1), is(5));

    }

    @Test
    public void testCountLevel2() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.countFromLevel(2), is(3));

    }

    @Test
    public void testCountLevel2Extra() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.countFromLevel(2), is(4));

    }
    @Test
    public void testCountLevel3LargeTree() throws Exception {

        Tree tree = new Tree();

        tree.add(20);
        tree.add(16);
        tree.add(14);
        tree.add(18);
        tree.add(17);
        tree.add(13);
        tree.add(15);
        tree.add(19);
        tree.add(30);
        tree.add(28);
        tree.add(27);
        tree.add(29);
        tree.add(35);
        tree.add(36);
        tree.add(34);

        assertThat(tree.countFromLevel(3), is(8));

    }

    @Test
    public void testCountLevel2LargeTree() throws Exception {

        Tree tree = new Tree();

        tree.add(20);
        tree.add(16);
        tree.add(14);
        tree.add(18);
        tree.add(17);
        tree.add(13);
        tree.add(15);
        tree.add(19);
        tree.add(30);
        tree.add(28);
        tree.add(27);
        tree.add(29);
        tree.add(35);
        tree.add(36);
        tree.add(34);

        assertThat(tree.countFromLevel(2), is(12));

    }

    @Test
    public void testCountLevel1LargeTree() throws Exception {

        Tree tree = new Tree();

        tree.add(20);
        tree.add(16);
        tree.add(14);
        tree.add(18);
        tree.add(17);
        tree.add(13);
        tree.add(15);
        tree.add(19);
        tree.add(30);
        tree.add(28);
        tree.add(27);
        tree.add(29);
        tree.add(35);
        tree.add(36);
        tree.add(34);

        assertThat(tree.countFromLevel(1), is(6));

    }

    @Test
    public void testToStringLeavesEmpty() throws Exception {

        Tree tree = new Tree();

        assertThat(tree.toStringLeafs(), is("[]"));

    }

    @Test
    public void testToStringLeavesOneElem() throws Exception {

        Tree tree = new Tree();

        tree.add(5);

        assertThat(tree.toStringLeafs(), is("[5]"));

    }

    @Test
    public void testToStringLeaves5() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);

        assertThat(tree.toStringLeafs(), is("[1,6]"));

    }

    @Test
    public void testToStringLeaves6() throws Exception {

        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.toStringLeafs(), is("[1,6,8]"));

    }


}