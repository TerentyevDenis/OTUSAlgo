package Search;

public class ValueToSearch {
    private String text;
    private String pattern;

    public ValueToSearch(String pattern, String text) {
        this.text = text;
        this.pattern = pattern;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
