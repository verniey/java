import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class Aufgabe1Test {


    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void testRectangleHasElement() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                    if(x >= 0 && x <= 4 && y >= 0 && y <= 5) {
                        Assert.assertTrue(rect1.hasElement(new Position(x,y)));
                    } else {
                        Assert.assertTrue(!rect1.hasElement(new Position(x,y)));
                    }
            }
        }


        rect1 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                if(x >= 3 && x <= 3 && y >= 3 && y <= 7) {
                    Assert.assertTrue(rect1.hasElement(new Position(x,y)));
                } else {
                    Assert.assertTrue(!rect1.hasElement(new Position(x,y)));
                }
            }
        }
    }

    @Test
    public void testRectangleHasElementMove() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        rect1.moveVertical(3);

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                if(x >= 0 && x <= 4 && y >= 3 && y <= 8) {
                    Assert.assertTrue(rect1.hasElement(new Position(x,y)));
                } else {
                    Assert.assertTrue(!rect1.hasElement(new Position(x,y)));
                }
            }
        }

        rect1 = new Rectangle(new Position(3,3), new Position(3,7), 'o');
        rect1.moveVertical(5);

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                if(x >= 3 && x <= 3 && y >= 8 && y <= 12) {
                    Assert.assertTrue(rect1.hasElement(new Position(x,y)));
                } else {
                    Assert.assertTrue(!rect1.hasElement(new Position(x,y)));
                }
            }
        }
    }

    @Test
    public void testRectangleSymbol() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Assert.assertThat(rect1.symbol(), is('#'));
        rect1 = new Rectangle(new Position(3,3), new Position(3,7), 'o');
        Assert.assertThat(rect1.symbol(), is('o'));

    }

    @Test
    public void testFigureAdd() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);

        Field field = Figure.class.getDeclaredField("rectangles");
        field.setAccessible(true);

        List<Rectangle> listA =  (List<Rectangle>) field.get(fig);
        List<Rectangle> listB = new LinkedList<>();
        listB.add(rect1);
        fig.add(listB.get(listB.size()-1));
        listB.add(rect2);
        fig.add(listB.get(listB.size()-1));
        for (int x = 0; x < 6; x++) {
            int y = x+2;

            listB.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
            fig.add(listB.get(listB.size()-1));

        }

        Assert.assertTrue(listA.containsAll(listB) && listB.containsAll(listA));
        for(Rectangle rect: listB) {
            Assert.assertThat(listA.get(listA.indexOf(rect)).toString(),is(rect.toString()));
        }

    }


    @Test
    public void testFigureGet() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        Rectangle rect3 = fig.get(new Position(3,3));
        Assert.assertTrue(rect3 == rect2);

    }

    @Test
    public void testFigureGetAndDelete() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        Rectangle rect3 = fig.get(new Position(3,3));
        Assert.assertTrue(rect3 == rect2);
        fig.delete(new Position(3,3));

        rect3 = fig.get(new Position(3,3));
        Assert.assertTrue(rect3 == rect1);

    }

    @Test
    public void testFigureDeleteReturnValue() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        Rectangle rect3 = fig.get(new Position(3,3));
        Assert.assertTrue(rect3 == rect2);
        Assert.assertTrue(fig.delete(new Position(3,3)));

        Assert.assertTrue(!fig.delete(new Position(8,8)));

    }

    @Test
    public void testFigureToString() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        String result = "#####.....\n" +
                "#####.....\n" +
                "\\####.....\n" +
                "#\\#o#.....\n" +
                "##\\o#.....\n" +
                "###\\#.....\n" +
                "...o\\.....\n" +
                "...o.\\....\n" +
                "..........\n" +
                "..........";

        Assert.assertThat(fig.toString().trim(), is(result));

    }

    @Test
    public void testFigureMoveToString() throws Exception {
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        rect1.moveVertical(3);

        String result = "..........\n" +
                "..........\n" +
                "\\.........\n" +
                "#\\#o#.....\n" +
                "##\\o#.....\n" +
                "###\\#.....\n" +
                "###o\\.....\n" +
                "###o#\\....\n" +
                "#####.....\n" +
                "..........";

        Assert.assertThat(fig.toString().trim(), is(result));

    }




}