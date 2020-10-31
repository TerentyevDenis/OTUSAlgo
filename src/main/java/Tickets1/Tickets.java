package Tickets1;

import java.util.ArrayList;
import java.util.Arrays;

public class Tickets {

    private static long[] possibleSum;
    public static Long ticketsCount(int n){
        possibleSum = new long[n/2*9+1];//we can get any sum from 0 to n*9 (n is a size of ticket)
        countSums(n,0,0);  //create array that contains number of ways that sums can be gotten
        return Arrays.stream(possibleSum).map(i->i*i).sum();
    }

    static private void countSums(int n, int k, int sum){
        if (k==n/2){
                possibleSum[sum]=possibleSum[sum]+1;
                return;
        }
        for (int d=0;d<10;d++){
            countSums(n, k+1, sum+d);
        }
    }
}
