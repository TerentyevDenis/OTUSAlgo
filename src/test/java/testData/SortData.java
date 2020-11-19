package testData;

import Bitboard.Result;
import io.github.sskorol.core.DataSupplier;
import utils.TestData;

import java.util.Arrays;
import java.util.stream.Stream;

import static utils.FileReader.getTwoTestValues;

public class SortData {
    @DataSupplier(name = "Random")
    public Stream<TestData<int[], int[]>> supplier() {
        return getTwoTestValues("src/main/resources/sorting-tests/0.random").map(testValue
                -> new TestData<int[], int[]>(Arrays.stream(testValue.getSecondInputString().split(" "))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray(),Arrays.stream(testValue.getExpectedResult().split(" "))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray())
        );
    }
    @DataSupplier(name = "Digits")
    public Stream<TestData<int[], int[]>> supplierDigits() {
        return getTwoTestValues("src/main/resources/sorting-tests/1.digits").map(testValue
                -> new TestData<int[], int[]>(Arrays.stream(testValue.getSecondInputString().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray(),Arrays.stream(testValue.getExpectedResult().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray())
        );
    }

    @DataSupplier(name = "Sorted")
    public Stream<TestData<int[], int[]>> supplierSorted() {
        return getTwoTestValues("src/main/resources/sorting-tests/2.sorted").map(testValue
                -> new TestData<int[], int[]>(Arrays.stream(testValue.getSecondInputString().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray(),Arrays.stream(testValue.getExpectedResult().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray())
        );
    }

    @DataSupplier(name = "Revers")
    public Stream<TestData<int[], int[]>> supplierRevers() {
        return getTwoTestValues("src/main/resources/sorting-tests/3.revers").map(testValue
                -> new TestData<int[], int[]>(Arrays.stream(testValue.getSecondInputString().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray(),Arrays.stream(testValue.getExpectedResult().split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray())
        );
    }
}
