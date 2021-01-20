package tests;

import graph.Demucron;
import org.testng.annotations.Test;

public class DemucronTest {

    @Test
    void test(){

        int [][] input = {{0,0,1,0,0,0,0,0,0,0,0,0,1,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,1,0,0,0,0,0,1,1,0,0,0,0},
                          {0,0,0,1,0,0,0,0,0,0,1,1,1,0},
                          {0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                          {0,1,0,1,0,1,1,0,0,0,0,0,0,0},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,1,0,0,0,0,1,0,0},
                          {0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



        Demucron demucron = new Demucron();
        int [][] result = demucron.demucron(input);
    }
}
