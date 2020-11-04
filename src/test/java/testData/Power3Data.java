package testData;

import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.stream.Stream;

import static utils.FileReader.getTestValues;
import static utils.FileReader.getTwoTestValues;

public class Power3Data {
    @DataSupplier(name = "Power")
    public Stream<TestData<Power,Double>> supplier(){
        return getTwoTestValues("src/main/resources/3.Power").map(testValue -> new TestData<Power, Double>(
                new Power(Long.valueOf(testValue.getSecondInputString()),Double.valueOf(testValue.getInputString()))
                ,Double.valueOf(testValue.getExpectedResult())));
    }
    public class Power{
        Long power;
        Double base;

        public Power(Long power, Double base) {
            this.power = power;
            this.base = base;
        }

        public Long getPower() {
            return power;
        }

        public Double getBase() {
            return base;
        }

        @Override
        public String toString() {
            return "Power{" +
                    "power=" + power +
                    ", base=" + base +
                    '}';
        }
    }
}
