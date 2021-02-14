package Search;

public class BoyerMurHorspul {
    public int find(String text, String pattern) {
        int t = 0;
        int[] shift = CreateSift(pattern);
        int last = pattern.length() - 1;
        while (t < text.length() - last) {
            int pos = last;
            while (pos >= 0 && text.charAt(t + pos) == pattern.charAt(pos)) {
                pos--;
            }
            if (pos == -1) {
                return t;
            }
            t += shift[text.charAt(t + last)];
        }
        return -1;
    }

    private int[] CreateSift(String pattern) {
        int[] shift = new int[128];
        for (int j = 0; j < shift.length; j++) {
            shift[j] = pattern.length();
        }
        for (int p = 0; p < pattern.length() - 1; p++) {
            shift[pattern.charAt(p)] = pattern.length() - p - 1;
        }
        return shift;
    }
}
