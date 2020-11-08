package testData;

import io.github.sskorol.core.DataSupplier;
import org.testng.reporters.jq.INavigatorPanel;
import utils.TestData;

import java.math.BigInteger;
import java.util.stream.Stream;

import static utils.FileReader.getTestValues;

public class Primes5Data {
    @DataSupplier(name = "Primes")
    public Stream<TestData<Integer, Integer>> supplier(){
        return getTestValues("src/main/resources/5.Primes").map(testValue -> new TestData<Integer, Integer>(Integer.valueOf(testValue.getInputString()), Integer.valueOf(testValue.getExpectedResult())));
    }
}
