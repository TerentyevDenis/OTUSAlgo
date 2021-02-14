package Search;

public class BoyerMur {
    public int find(String text, String pattern) {
        int t = 0;
        int[] shift = createSift(pattern);
        int[] suffix = createSuffix(pattern);
        int last = pattern.length() - 1;
        while (t < text.length() - last) {
            int pos = last;
            while (pos >= 0 && text.charAt(t + pos) == pattern.charAt(pos)) {
                pos--;
            }
            if (pos == -1) {
                return t;
            }
            int step = shift[text.charAt(t + last)] > suffix[pattern.length() - pos - 1] ? shift[text.charAt(t + last)] : suffix[pattern.length() - pos - 1];
            t += step;
        }
        return -1;
    }

    private int[] createSift(String pattern) {
        int[] shift = new int[128];
        for (int j = 0; j < shift.length; j++) {
            shift[j] = pattern.length();
        }
        for (int p = 0; p < pattern.length() - 1; p++) {
            shift[pattern.charAt(p)] = pattern.length() - p - 1;
        }
        return shift;
    }

    private int[] createSuffix(String pattern) {
        int[] suffix = new int[pattern.length()];
        for (int j = 0; j < suffix.length; j++) {
            suffix[j] = new SlowSearch().find(pattern.substring(0, j), pattern.substring(pattern.length() - j - 1));
        }
        return suffix;
    }
}
