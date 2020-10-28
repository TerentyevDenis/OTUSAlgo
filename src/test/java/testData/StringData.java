package testData;

import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.stream.Stream;

import static utils.FileReader.getTestValues;

public class StringData {
    @DataSupplier(name = "String")
    public Stream<TestData<String,Integer>> supplier(){
        //return Stream.of(new TestData<>("123",3));
        return getTestValues("src/main/resources/0.String").map(testValue -> new TestData<String, Integer>(testValue.getInputString(),Integer.valueOf(testValue.getExpectedResult())));
    }
}
