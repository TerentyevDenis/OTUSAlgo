package utils;

public class TestData<T,G> {
        T input;
        G expectedValue;

    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }

    public G getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(G expectedValue) {
        this.expectedValue = expectedValue;
    }

    public TestData(T input, G expectedValue) {
        this.input = input;
        this.expectedValue = expectedValue;
    }
}
