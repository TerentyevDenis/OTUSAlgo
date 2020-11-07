package testData;

import Bitboard.Result;
import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.stream.Stream;

import static utils.FileReader.getTestValues;
import static utils.FileReader.getTwoExpectedValues;

public class BitboardData {
    @DataSupplier(name = "King")
    public Stream<TestData<Integer,Result>> supplier(){
        return getTwoExpectedValues("src/main/resources/1.Bitboard - Король").map(testValue
                -> new TestData<Integer, Result>(Integer.valueOf(testValue.getInputString()),
                new Result(Integer.valueOf(testValue.getExpectedResult()), Long.parseUnsignedLong(testValue.getSecondExpectedResult()))));
    }

    @DataSupplier(name = "Knight")
    public Stream<TestData<Integer,Result>> supplierKnight(){
        return getTwoExpectedValues("src/main/resources/2.Bitboard - Конь").map(testValue
                -> new TestData<Integer, Result>(Integer.valueOf(testValue.getInputString()),
                new Result(Integer.valueOf(testValue.getExpectedResult()), Long.parseUnsignedLong(testValue.getSecondExpectedResult()))));
    }

    @DataSupplier(name = "Rook")
    public Stream<TestData<Integer,Result>> supplierRook(){
        return getTwoExpectedValues("src/main/resources/3.Bitboard - Ладья").map(testValue
                -> new TestData<Integer, Result>(Integer.valueOf(testValue.getInputString()),
                new Result(Integer.valueOf(testValue.getExpectedResult()), Long.parseUnsignedLong(testValue.getSecondExpectedResult()))));
    }

    @DataSupplier(name = "Bishop")
    public Stream<TestData<Integer,Result>> supplierBishop(){
        return getTwoExpectedValues("src/main/resources/4.Bitboard - Слон").map(testValue
                -> new TestData<Integer, Result>(Integer.valueOf(testValue.getInputString()),
                new Result(Integer.valueOf(testValue.getExpectedResult()), Long.parseUnsignedLong(testValue.getSecondExpectedResult()))));
    }

    @DataSupplier(name = "Queen")
    public Stream<TestData<Integer,Result>> supplierQueen(){
        return getTwoExpectedValues("src/main/resources/5.Bitboard - Ферзь").map(testValue
                -> new TestData<Integer, Result>(Integer.valueOf(testValue.getInputString()),
                new Result(Integer.valueOf(testValue.getExpectedResult()), Long.parseUnsignedLong(testValue.getSecondExpectedResult()))));
    }
}
