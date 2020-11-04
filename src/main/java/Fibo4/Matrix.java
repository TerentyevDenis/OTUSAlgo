package Fibo4;

import java.math.BigInteger;

public class Matrix {
    BigInteger[][] a = new BigInteger[2][2];

    public void multiply(Matrix matrix){
        BigInteger[][] c = new BigInteger[2][2];
        BigInteger[][] b = matrix.getA();
        c[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        c[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        c[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        c[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
        a=c;
    }

    public BigInteger[][] getA() {
        return a;
    }

    public void setA(BigInteger[][] a) {
        this.a = a;
    }

    public void pow(int power){
        Matrix p = this;
        Matrix res = new Matrix();
        BigInteger[][] init = {{BigInteger.valueOf(1),BigInteger.valueOf(0)},{BigInteger.valueOf(0),BigInteger.valueOf(1)}};
        res.setA(init);
        int ost = power;
        while (ost>=1){
            if (ost!=power){
                p.multiply(p);
            }
            if (ost%2==1){
                res.multiply(p);
            }
            ost=ost/2;
        }
        a=res.getA();
    }
}
