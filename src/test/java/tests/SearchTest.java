package tests;

import Bitboard.Result;
import Search.BoyerMur;
import Search.BoyerMurHorspul;
import Search.SlowSearch;
import Search.ValueToSearch;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.BitboardData;
import testData.SearchData;
import utils.TestData;

import static Bitboard.Bitboard.bishop;

public class SearchTest {
    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "Search")
    void test(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new SlowSearch().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "SearchAB")
    void testAB(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new SlowSearch().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }
    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "Search")
    void test2(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new BoyerMurHorspul().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "SearchAB")
    void test2AB(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new BoyerMurHorspul().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }
    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "Search")
    void test3(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new BoyerMur().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Slow search English alphabet",dataProviderClass = SearchData.class,dataProvider = "SearchAB")
    void test3AB(TestData<ValueToSearch, Result> testData){
        ValueToSearch value = testData.getInput();
        Integer result = new BoyerMur().find(value.getText(),value.getPattern());
        Assert.assertEquals(result,testData.getExpectedValue());
    }
}
