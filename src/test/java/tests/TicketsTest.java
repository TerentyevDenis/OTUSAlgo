package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.String0Data;
import testData.TicketsData;
import utils.TestData;

import static String0.String0.stringSize;
import static Tickets1.Tickets.ticketsCount;

public class TicketsTest {
    @Test(testName = "Task1 1.Tickets test",dataProviderClass = TicketsData.class,dataProvider = "Tickets")
    void test(TestData<Integer,Long> testData){
        Long count = ticketsCount(testData.getInput()*2);
        Assert.assertEquals(count,testData.getExpectedValue(),"Lucky Tickets size: '"+testData.getInput()+"' amount");
    }
}
