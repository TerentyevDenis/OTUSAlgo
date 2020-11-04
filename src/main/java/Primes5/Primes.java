package Primes5;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;

public class Primes {

    static ArrayList<Integer> primes;

    public static Integer primesIterative(int n){
        primes = new ArrayList<Integer>(n);
        Integer count =0;
        for (int p = 2; p <=n; p++){
            if (isPrime(p)) {
                count++;
                primes.add(p);
            }
        }
        return count;
    }

    static boolean isPrime(int p){
        int sqrt = (int)Math.sqrt(p);
        for (int elem:
             primes) {
            if (p%elem==0)
                return false;
        }
        return true;
    }

    public static Integer aratosfen(int N){
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[1] = false;
        isPrime[0] = false;
        int count = 0;
        for (int i=2; i*i <= N; i++) {
            if (isPrime[i])
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
        }
        for (boolean num:
             isPrime) {
            if (num)
                count++;
        }
        return count;
    }

    public static Integer aratosfenON(int N){

        int[] lp = new int[N+1];
        Arrays.fill(lp,0);
        ArrayList<Integer> pr = new ArrayList<>(N);

        for (int i=2; i <= N; i++) {
            if (lp[i]==0){
                lp[i]=i;
                pr.add(i);
            }
            for (int p:pr) {
                if (p<=lp[i] && p*i<=N)
                    lp[p*i]=p;
                else break;
            }

        }
        return pr.size();
    }

}
