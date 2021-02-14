package tests;

import graph.Deicstra;
import graph.Edge;
import graph.Kruscala;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DeicstraTest {

    @Test
    void test(){

        int [][] input = {{0,1,0,1,0},
                {1,0,10,0,2},
                {0,10,0,10,3},
                {1,0,10,0,0},
                {0,2,3,0,0}};


        Deicstra deicstra = new Deicstra();
        int[] result = deicstra.deicstra(input);
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }
}
