package testData;

import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.stream.Stream;

import static utils.FileReader.getTestValues;

public class String0Data {
    @DataSupplier(name = "String0")
    public Stream<TestData<String,Integer>> supplier(){
        return getTestValues("src/main/resources/0.String").map(testValue -> new TestData<String, Integer>(testValue.getInputString(),Integer.valueOf(testValue.getExpectedResult())));
    }
}
