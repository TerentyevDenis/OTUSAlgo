package tests.Task2;

import org.decimal4j.util.DoubleRounder;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.Power3Data;
import testData.String0Data;
import utils.TestData;

import java.text.DecimalFormat;

import static Power3.Pow.*;

public class Power3Test {

    @Test(testName = "Task2 3.Power test",dataProviderClass = Power3Data.class,dataProvider = "Power")
    void test(TestData<Power3Data.Power,Double> testData){
        Assert.assertEquals(DoubleRounder.round(powIterative(testData.getInput().getBase(),testData.getInput().getPower()),11),testData.getExpectedValue());
    }

    @Test(testName = "Task2 3.Power test ",dataProviderClass = Power3Data.class,dataProvider = "Power")
    void testPow2WithAditional(TestData<Power3Data.Power,Double> testData){
        Assert.assertEquals(DoubleRounder.round(pow2WithAditional(testData.getInput().getBase(),testData.getInput().getPower()),6),DoubleRounder.round(testData.getExpectedValue(),6));
    }

    @Test(testName = "Task2 3.Power test ",dataProviderClass = Power3Data.class,dataProvider = "Power")
    void testPowBinary(TestData<Power3Data.Power,Double> testData){
        Assert.assertEquals(DoubleRounder.round(powBinary(testData.getInput().getBase(),testData.getInput().getPower()),6),DoubleRounder.round(testData.getExpectedValue(),6));
    }

}
