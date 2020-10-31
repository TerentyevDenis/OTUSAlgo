package testData;

import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.stream.Stream;

import static utils.FileReader.getTestValues;

public class TicketsData {
    @DataSupplier(name = "Tickets")
    public Stream<TestData<Integer,Long>> supplier(){
        return getTestValues("src/main/resources/1.Tickets").map(testValue -> new TestData<Integer, Long>(Integer.valueOf(testValue.getInputString()),Long.valueOf(testValue.getExpectedResult())));
    }
}
