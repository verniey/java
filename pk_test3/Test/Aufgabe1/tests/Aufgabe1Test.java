import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;

public class Aufgabe1Test {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testTime2() throws Exception {
        Time t = new Time(2);
        Assert.assertTrue(t.equals(new Time(2,0)));
    }

    @Test
    public void testTimeNeg0200() throws Exception {
        Time t = new Time(-2);
        Assert.assertTrue(t.equals(new Time(-2,0)));
    }

    @Test
    public void testTimeslotStartStandard() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(12,30),45);

        Assert.assertThat(ts.weekday(),is(3));
        Assert.assertThat(ts.start(),is(new Time(12,30)));
        Assert.assertThat(ts.end(),is(new Time(13,15)));
    }

    @Test
    public void testTimeslotStartNegative() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(-12,-30),45);

        Assert.assertThat(ts.weekday(),is(2));
        Assert.assertThat(ts.start(),is(new Time(11,30)));
        Assert.assertThat(ts.end(),is(new Time(12,15)));

    }

    @Test
    public void testTimeslotStartNextDay() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(24+12,30),45);

        Assert.assertThat(ts.weekday(),is(4));
        Assert.assertThat(ts.start(),is(new Time(12,30)));
        Assert.assertThat(ts.end(),is(new Time(13,15)));

    }

    @Test
    public void testTimeslotLong() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(20,30),1000);

        Assert.assertThat(ts.weekday(),is(3));
        Assert.assertThat(ts.start(),is(new Time(20,30)));
        Assert.assertThat(ts.end(),is(new Time(24,00)));

    }

    @Test
    public void testTimeslotLongStartNegative() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(-3,-30),1000);

        Assert.assertThat(ts.weekday(),is(2));
        Assert.assertThat(ts.start(),is(new Time(20,30)));
        Assert.assertThat(ts.end(),is(new Time(24,00)));

    }

    @Test
    public void testTimeslotEquals() throws Exception {
        Timeslot ts = new Timeslot(3,new Time(3,30),10);

        Assert.assertTrue(ts.equals(new Timeslot(3,new Time(3,30),10)));
        Assert.assertTrue(!ts.equals(new Timeslot(2,new Time(3,30),10)));
        Assert.assertTrue(!ts.equals(new Timeslot(3,new Time(2,30),10)));
        Assert.assertTrue(!ts.equals(new Timeslot(3,new Time(3,30),15)));

    }

    @Test
    public void testTimeslotToString() throws Exception {
        Timeslot ts = new Timeslot(2, new Time(10, 30), 60);

        String expected = "Mi, 10:30 - 11:30";
        Assert.assertThat(ts.toString().replaceAll("\\s",""), is(expected.replaceAll("\\s","")));

    }

    @Test
    public void testTimetableGetStart() throws Exception {
        Timetable tt = new Timetable();
        tt.add("PK",new Timeslot(0,new Time(15),120));
        tt.add("Mathe",new Timeslot(3,new Time(9,30),60));
        tt.add("Security",new Timeslot(3,new Time(15,0),120));

        tt.getStart("PK").equals(new Time(15,0));
    }

    @Test
    public void testTimetableToString() throws Exception {
        Timetable tt = new Timetable();
        tt.add("PK",new Timeslot(0,new Time(15),120));
        tt.add("Mathe",new Timeslot(3,new Time(9,30),60));
        tt.add("Security",new Timeslot(3,new Time(15,0),120));

        Assert.assertTrue(tt.toString().replaceAll("\\s","").contains("Mathe=Do,09:30-10:30"));
        Assert.assertTrue(tt.toString().replaceAll("\\s","").contains("PK=Mo,15:00-17:00"));
        Assert.assertTrue(tt.toString().replaceAll("\\s","").contains("Security=Do,15:00-17:00"));
    }

}