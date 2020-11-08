package Bitboard;

public class Bitboard {
    public static Result king(int n){
        long noA = Long.parseUnsignedLong("18374403900871474942");
        long noH = Long.parseUnsignedLong("9187201950435737471");
        long x = Long.parseUnsignedLong("1") << n;
        long mask =
                ((x & noA) << 7) | (x << 8) | ((x & noH) << 9) |
                ((x & noA) >>> 1) |            ((x & noH) << 1) |
                ((x & noA) >>> 9) | (x >>> 8) | ((x & noH) >>> 7) ;

        long resMask = mask;
        int count = 0;
        while (mask != 0)
        {
            count++;
            mask &=mask-1;
        }

        return new Result(count, resMask);
    }

    public static Result knight(int n){
        long noA = Long.parseUnsignedLong("18374403900871474942");
        long noAB = Long.parseUnsignedLong("18229723555195321596");
        long noH = Long.parseUnsignedLong("9187201950435737471");
        long noGH = Long.parseUnsignedLong("4557430888798830399");

        long x = Long.parseUnsignedLong("1") << n;
        long mask =
                         noGH & (x <<  6 | x >>> 10)
                        |  noH & (x << 15 | x >>> 17)
                        | noA  & (x << 17 | x >>> 15)
                        | noAB & (x << 10 | x >>>  6);

        long resMask = mask;
        int count = 0;
        while (mask != 0)
        {
            count++;
            mask &=mask-1;
        }

        return new Result(count, resMask);
    }

    public static Result rook(int n){
        long x = Long.parseUnsignedLong("1") << n;
        long v = Long.parseUnsignedLong("1") << n%8;
        long h = Long.parseUnsignedLong("1") << n-n%8;
        long mask = 0;
        for (int i = 0; i<8;i++){
            mask=mask|v;
            v = v<<8;
        }
        for (int i = 0; i<8;i++){
            mask=mask|h;
            h = h<<1;
        }
        mask=mask ^ x;
        long resMask = mask;
        int count = 0;
        while (mask != 0)
        {
            count++;
            mask &=mask-1;
        }

        return new Result(count, resMask);
    }

    public static Result bishop(int n){
        long x = Long.parseUnsignedLong("1") << n;
        long l = x;
        long mask = 0;
        for (int i = 0; (i<8-n/8)&&(i<n%8);i++){
            l = l<<7;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<n/8)&&(i<7-n%8);i++){
            l = l>>>7;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<8-n/8)&&(i<7-n%8);i++){
            l = l<<9;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<n/8)&&(i<n%8);i++){
            l = l>>>9;
            mask=mask|l;
        }

        long resMask = mask;
        int count = 0;
        while (mask != 0)
        {
            count++;
            mask &=mask-1;
        }

        return new Result(count, resMask);
    }

    public static Result queen(int n){
        long x = Long.parseUnsignedLong("1") << n;
        long l = x;
        long mask = 0;
        for (int i = 0; (i<8-n/8)&&(i<n%8);i++){
            l = l<<7;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<n/8)&&(i<7-n%8);i++){
            l = l>>>7;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<8-n/8)&&(i<7-n%8);i++){
            l = l<<9;
            mask=mask|l;
        }
        l=x;
        for (int i = 0; (i<n/8)&&(i<n%8);i++){
            l = l>>>9;
            mask=mask|l;
        }

        long v = Long.parseUnsignedLong("1") << n%8;
        long h = Long.parseUnsignedLong("1") << n-n%8;

        for (int i = 0; i<8;i++){
            mask=mask|v;
            v = v<<8;
        }
        for (int i = 0; i<8;i++){
            mask=mask|h;
            h = h<<1;
        }

        mask=mask ^ x;

        long resMask = mask;
        int count = 0;
        while (mask != 0)
        {
            count++;
            mask &=mask-1;
        }
        return new Result(count, resMask);
    }

}
