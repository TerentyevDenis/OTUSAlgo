package Power3;

public class Pow {
    public static Double powIterative(double o, Long p){
        double res = 1;
        for (int i = 0;i < p; i++){
            res=res*o;
        }
        return res;
    }

    public static Double pow2WithAditional(double o, Long p){
        double res = o;
        Long pow = 1L;
        if (p==0){
            return 1.0;
        }
        for (long i =2; i<=p;i=i*2) {
            res = res * res;
            pow = i;
        }
        for (long i = pow; i<p;i++) {
            res = res * o;
        }

        return res;
    }

    public static Double powBinary(double o, Long power){
        if (power==0){
            return 1.0;
        }
        double p=o;
        double res = 1;
        Long ost = power;
        while (ost>=1){
            if (ost!=power){
                p=p*p;
            }
            if (ost%2==1){
                res=res*p;
            }
            ost=ost/2;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.print(pow2WithAditional(2,1L));
    }
}
