package Sorting;

import DynamicArrays.model.ArrayListWrapper;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class ShellSort {

    public static void shellSort1(int[] arg) {
        ArrayList<Integer> steps = new ArrayList<>();
        int elem = arg.length;
        while (elem / 2 > 0) {
            elem /= 2;
            steps.add(elem);
        }
        for (int step : steps) {
            for (int i = step; i < arg.length; i++) {
                for (int j = i - step; j >= 0 && arg[j] > arg[j + step]; j -= step) {
                    int x = arg[j];
                    arg[j] = arg[j + step];
                    arg[j + step] = x;
                }
            }
        }
    }

    public static void shellSort2(int[] arg) {
        ArrayList<Integer> steps = new ArrayList<>();
        int elem = 1;
        steps.add(1);
        while (elem < arg.length) {
            elem *= 2;
            steps.add(elem - 1);
        }
        for (int step : Lists.reverse(steps)) {
            for (int i = step; i < arg.length; i++) {
                for (int j = i - step; j >= 0 && arg[j] > arg[j + step]; j -= step) {
                    int x = arg[j];
                    arg[j] = arg[j + step];
                    arg[j + step] = x;
                }
            }
        }
    }

    public static void shellSort3(int[] arg) {
        ArrayList<Integer> steps = new ArrayList<>();
        int a = 4;
        int b = 1;
        steps.add(1);
        while (a + 3 * b + 1 < arg.length) {
            steps.add(a + 3 * b + 1);
            a = a * 4;
            b = b * 2;
        }
        for (int step : Lists.reverse(steps)) {
            for (int i = step; i < arg.length; i++) {
                for (int j = i - step; j >= 0 && arg[j] > arg[j + step]; j -= step) {
                    int x = arg[j];
                    arg[j] = arg[j + step];
                    arg[j + step] = x;
                }
            }
        }
    }
}
