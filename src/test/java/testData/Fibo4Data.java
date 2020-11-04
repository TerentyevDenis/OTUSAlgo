package testData;

import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.math.BigInteger;
import java.util.stream.Stream;

import static utils.FileReader.getTestValues;

public class Fibo4Data {
    @DataSupplier(name = "Fibo")
    public Stream<TestData<Integer, BigInteger>> supplier(){
        return getTestValues("src/main/resources/4.Fibo").map(testValue -> new TestData<Integer, BigInteger>(Integer.valueOf(testValue.getInputString()),new BigInteger(testValue.getExpectedResult())));
    }
}
