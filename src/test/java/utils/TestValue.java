package utils;

public class TestValue {
    private String inputString;
    private String secondInputString;
    private String expectedResult;
    private String secondExpectedResult;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public void setSecondInputString(String secondInputString) {
        this.secondInputString = secondInputString;
    }

    public String getSecondInputString() {
        return secondInputString;
    }
    public String getSecondExpectedResult() {
        return secondExpectedResult;
    }

    public void setSecondExpectedResult(String secondExpectedResult) {
        this.secondExpectedResult = secondExpectedResult;
    }
}
