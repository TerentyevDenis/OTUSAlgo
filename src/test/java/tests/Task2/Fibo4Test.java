package tests.Task2;

import org.decimal4j.util.DoubleRounder;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.Fibo4Data;
import testData.Power3Data;
import utils.TestData;

import java.math.BigInteger;

import static Fibo4.Fibo.*;
import static Power3.Pow.powIterative;

public class Fibo4Test {
    @Test(testName = "Task2 4.Fibo test",dataProviderClass = Fibo4Data.class,dataProvider = "Fibo")
    void test(TestData<Integer, BigInteger> testData){
        Assert.assertEquals(fiboIterative(testData.getInput()),testData.getExpectedValue());
    }

    @Test(testName = "Task2 4.Fibo test",dataProviderClass = Fibo4Data.class,dataProvider = "Fibo")
    void testGold(TestData<Integer, BigInteger> testData){
        Assert.assertEquals(fiboGold(testData.getInput()),testData.getExpectedValue());
    }

    @Test(testName = "Task2 4.Fibo test",dataProviderClass = Fibo4Data.class,dataProvider = "Fibo")
    void testMatrix(TestData<Integer, BigInteger> testData){
        Assert.assertEquals(fiboMatrix(testData.getInput()),testData.getExpectedValue());
    }
}
