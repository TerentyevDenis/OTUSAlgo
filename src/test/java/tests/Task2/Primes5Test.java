package tests.Task2;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.Primes5Data;
import utils.TestData;

import static Primes5.Primes.*;

public class Primes5Test {

    @Test(testName = "Task2 5.Primes test",dataProviderClass = Primes5Data.class,dataProvider = "Primes")
    void test(TestData<Integer,Integer> testData){
        Assert.assertEquals(primesIterative(testData.getInput()),testData.getExpectedValue());
    }

    @Test(testName = "Task2 5.Primes test",dataProviderClass = Primes5Data.class,dataProvider = "Primes")
    void testAratosfen(TestData<Integer,Integer> testData){
        Assert.assertEquals(aratosfen(testData.getInput()),testData.getExpectedValue());
    }

    @Test(testName = "Task2 5.Primes test",dataProviderClass = Primes5Data.class,dataProvider = "Primes")
    void testAratosfenON(TestData<Integer,Integer> testData){
        Assert.assertEquals(aratosfenON(testData.getInput()),testData.getExpectedValue());
    }
}
