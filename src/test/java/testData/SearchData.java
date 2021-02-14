package testData;

import Search.ValueToSearch;
import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.math.BigInteger;
import java.util.stream.Stream;

import static utils.FileReader.getTestValues;
import static utils.FileReader.getTwoTestValues;

public class SearchData {
    @DataSupplier(name = "Search")
    public Stream<TestData<ValueToSearch, Integer>> supplier(){
        return getTwoTestValues("src/main/resources/Sort/21.SearchEnglish","string").map(testValue -> new TestData<ValueToSearch, Integer>(new ValueToSearch(testValue.getInputString(),testValue.getSecondInputString()), Integer.valueOf(testValue.getExpectedResult())));
    }
    @DataSupplier(name = "SearchAB")
    public Stream<TestData<ValueToSearch, Integer>> supplierAB(){
        return getTwoTestValues("src/main/resources/ab/ab","string").map(testValue -> new TestData<ValueToSearch, Integer>(new ValueToSearch(testValue.getInputString(),testValue.getSecondInputString()), Integer.valueOf(testValue.getExpectedResult())));
    }
}
