package Bitboard;

import java.util.Objects;

public class Result {
    private long mask;
    private int count;

    public Result(int count, long mask) {
        this.mask = mask;
        this.count = count;
    }

    public long getMask() {
        return mask;
    }

    public void setMask(long mask) {
        this.mask = mask;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return mask == result.mask &&
                count == result.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mask, count);
    }

    @Override
    public String toString() {
        return "Result{" +
                "mask=" + mask +
                ", count=" + count +
                '}';
    }
}
