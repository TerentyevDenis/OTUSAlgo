package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.String0Data;
import utils.TestData;

import static String0.String0.stringSize;

public class String0Test {
    @Test(testName = "Task1 0.String test",dataProviderClass = String0Data.class,dataProvider = "String0")
    void test(TestData<String,Integer> testData){
        Assert.assertEquals(stringSize(testData.getInput()),testData.getExpectedValue(),"String: '"+testData.getInput()+"' size");
    }
}
