package tests;

import graph.Demucron;
import graph.Edge;
import graph.Kruscala;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.testng.annotations.Test;

public class KruscalaTest {

    @Test
    void test(){

        int [][] input = {{0,1,0,1,0},
                          {1,0,10,0,2},
                          {0,10,0,10,3},
                          {1,0,10,0,0},
                          {0,2,3,0,0}};


        Kruscala kruscala = new Kruscala();
        Edge[] result = kruscala.mstKruskal(input);
        System.out.println(result);
    }
}
