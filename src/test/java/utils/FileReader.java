package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileReader {

    public static Stream<TestValue> getTestValues(String resourceName){
        ArrayList<TestValue> testValues = new ArrayList<TestValue>();
        int testIndex =0;
        while (true){
            TestValue testValue = new TestValue();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(resourceName + "/test." + testIndex + ".in"), StandardCharsets.UTF_8))){
                testValue.setInputString(reader.readLine());
            } catch (FileNotFoundException e) {
                if (testValues.isEmpty())
                    e.printStackTrace();
                else
                    return testValues.stream(); //if file not found then we get all test values
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(resourceName + "/test." + testIndex + ".out"), StandardCharsets.UTF_8))){
                testValue.setExpectedResult(reader.readLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            testValues.add(testValue);
            testIndex++;
        }
    }
}
