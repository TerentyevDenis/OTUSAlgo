package tests;

import Bitboard.Result;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.BitboardData;
import testData.String0Data;
import utils.TestData;

import static Bitboard.Bitboard.*;
import static String0.String0.stringSize;

public class BitboardTest {
    @Test(testName = "Task1 Bitboard king test",dataProviderClass = BitboardData.class,dataProvider = "King")
    void testKing(TestData<Integer, Result> testData){
        Result result = king(testData.getInput());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Task1 Bitboard Knight test",dataProviderClass = BitboardData.class,dataProvider = "Knight")
    void testKnight(TestData<Integer, Result> testData){
        Result result = knight(testData.getInput());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Task1 Bitboard Rook test",dataProviderClass = BitboardData.class,dataProvider = "Rook")
    void testRook(TestData<Integer, Result> testData){
        Result result = rook(testData.getInput());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Task1 Bitboard Bishop test",dataProviderClass = BitboardData.class,dataProvider = "Bishop")
    void testBishop(TestData<Integer, Result> testData){
        Result result = bishop(testData.getInput());
        Assert.assertEquals(result,testData.getExpectedValue());
    }

    @Test(testName = "Task1 Bitboard Queen test",dataProviderClass = BitboardData.class,dataProvider = "Queen")
    void testQueen(TestData<Integer, Result> testData){
        Result result = queen(testData.getInput());
        Assert.assertEquals(result,testData.getExpectedValue());
    }
}
