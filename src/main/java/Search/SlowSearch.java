package Search;

public class SlowSearch {
    public int find(String text, String pattern) {
        int t = 0;
        int last = pattern.length() - 1;
        while (t < text.length() - last) {
            int pos = 0;
            while (pos <= last && text.charAt(t + pos) == pattern.charAt(pos)) {
                pos++;
            }
            if (pos == pattern.length()) {
                return t;
            }
            t++;
        }
        return -1;
    }
}
