package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Demucron {

    int[][] input;
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int nodesAmount;

    public int[][] demucron(int[][] input){
        int layer = 0;
        nodesAmount = input[0].length;
        this.input = input;
        int[] incomPow = new int[input[0].length];

        for (int i = 0; i < input[0].length;i++){
            for (int j = 0; j < input.length;j++){
                incomPow[i] += input[j][i];
            }
        }
        result.add(new ArrayList<Integer>());
        while (nodesAmount != 0){
            findZero(incomPow,layer);
            layer++;
            result.add(new ArrayList<Integer>());
        }

        int[][] resultArray = new int[layer][];
        for (int i =0; i < layer;i++){
            resultArray[i] = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size();j++){
                resultArray[i][j] = result.get(i).get(j);
            }
        }
        return resultArray;

    }

    public void findZero(int[] input, int layer){
        int[] rowMinus = new int[input.length];
        for (int i = 0; i < input.length; i++){
            if (input[i] == 0){
                input[i]=-1;
                sumRow(i, rowMinus);
                result.get(layer).add(i);
                nodesAmount--;
            }
        }
        minusRow(input, rowMinus);
    }

    public void minusRow(int[] input,int[] rowMinus){
        for (int j = 0; j < input.length; j++){
            if (input[j]!=-1) {
                input[j] -= rowMinus[j];
            }
        }
    }
    public void sumRow(int i,int[] input){
        for (int j = 0; j < input.length; j++){
            if (input[j]!=-1) {
                input[j] += this.input[i][j];
            }
        }
    }

}
