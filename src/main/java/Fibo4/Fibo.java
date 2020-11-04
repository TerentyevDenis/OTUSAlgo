package Fibo4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Fibo {
        public static BigInteger fiboIterative(int n){
            BigInteger f0= BigInteger.valueOf(0);
            BigInteger f1=BigInteger.valueOf(1);
            BigInteger f2=BigInteger.valueOf(n); //0,1 or then count
            for (int i =1;i<n; i ++){
                f2=f0.add(f1);
                f0=f1;
                f1=f2;
            }
            return f2;
        }

        public static BigInteger fiboGold(int n){
            Double f = (1+Math.sqrt(5))/2;
            return BigDecimal.valueOf(f).pow(n).divide(BigDecimal.valueOf(Math.sqrt(5)), RoundingMode.HALF_UP).add(BigDecimal.valueOf(0.5)).toBigInteger();
        }

        public static BigInteger fiboMatrix(int i){
            if (i==0){
                return BigInteger.valueOf(0);
            }
            Matrix matrix = new Matrix();
            BigInteger[][] init = {{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};
            matrix.setA(init);
            matrix.pow(i-1);
            return matrix.getA()[0][0];
        }
}
