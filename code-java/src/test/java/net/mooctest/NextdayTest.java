package test.java.net.mooctest;

import static org.junit.Assert.*;

import main.java.net.mooctest.Date;
import main.java.net.mooctest.Nextday;
import main.java.net.mooctest.Year;
import main.java.net.mooctest.Month;
import main.java.net.mooctest.Day;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class NextdayTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void testIsLeap() {
        Nextday n = new Nextday();
        n.nextDay(new Date(11,11,2018));
        n.nextDay(new Date(2,29,2016));
        n.nextDay(new Date(2,28,100));
        n.nextDay(new Date(2,29,400));
        n.nextDay(new Date(2,29,4));
        n.nextDay(new Date(11,11,-2018));
        n.nextDay(new Date(2,28,-101));
        n.nextDay(new Date(2,29,-401));
        n.nextDay(new Date(2,29,-5));
    }
    @Test
    public void testIncrement() {
        Nextday n = new Nextday();
        n.nextDay(new Date(1,31,2018));
        n.nextDay(new Date(12,31,2018));
        n.nextDay(new Date(12,31,-1));
        n.nextDay(new Date(1,1,1));
        n.nextDay(new Date(2,29,4));
    }
    @Test
    public void testYearIsValid() throws  IllegalArgumentException{
        expectedEx.expect(IllegalArgumentException.class);
        Year year = new Year(1);
        Year year2 = new Year(4);
        Year year1 = new Year(0);
    }
    @Test
    public void testMonthIsValid() throws  IllegalArgumentException{
        expectedEx.expect(IllegalArgumentException.class);
        Year year = new Year(1);
        Month month = new Month(1,year);
        month.setMonth(-1,year);
    }
    @Test
    public void testDayIsValid() throws  IllegalArgumentException{
        expectedEx.expect(IllegalArgumentException.class);
        Year year = new Year(1);
        Year year1 = new Year(4);
        Month month = new Month(1,year1);
        Day day = new Day(29,new Month(2,year1));
        day.setDay(0,month);
        Day day1 = new Day(32,month);
    }
    @Test
    public void testEquals(){
        Year year = new Year(1);
        Year year1 = new Year(1);
        Year year2 = new Year(2);
        year.equals(year1);
        year.equals(year2);
        year.equals(1);

        Month month = new Month(1,new Year(1));
        Month month1 = new Month(2,new Year(1));
        Month month2 = new Month(1,new Year(2));
        month.equals(month1);
        month.equals(month);
        month.equals(month2);

        Day day = new Day(1,month);
        Day day1 = new Day(2,month);
        Day day2 = new Day(2,month1);
        day.equals(day1);
        day.equals(day);
        day1.equals(day2);
    }

}
