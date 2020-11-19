package tests;

import Sorting.HeapSort;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.SortData;
import utils.TestData;

import static Sorting.BubbleSort.optimizedBubbleSort;
import static Sorting.InsertionSort.optimizedInsertionSort;
import static Sorting.ShellSort.*;

public class SortingTest {
    @Test(testName = "Task6 BubbleSort test",dataProviderClass = SortData.class,dataProvider = "Revers")
    void test(TestData<int[],int[]> testData){
        int[] arr = testData.getInput();
        optimizedBubbleSort(arr);
        Assert.assertEquals(arr,testData.getExpectedValue());
    }

    @Test(testName = "Task6 InsertionSort test",dataProviderClass = SortData.class,dataProvider = "Revers")
    void testInsert(TestData<int[],int[]> testData){
        int[] arr = testData.getInput();
        optimizedInsertionSort(arr);
        Assert.assertEquals(arr,testData.getExpectedValue());
    }

    @Test(testName = "Task6 ShellSort test",dataProviderClass = SortData.class,dataProvider = "Revers")
    void testShell(TestData<int[],int[]> testData){
        int[] arr = testData.getInput();
        shellSort3(arr);
        Assert.assertEquals(arr,testData.getExpectedValue());
    }

    @Test(testName = "Task6 HeapSort test",dataProviderClass = SortData.class,dataProvider = "Revers")
    void testHeap(TestData<int[],int[]> testData){
        int[] arr = testData.getInput();
        new HeapSort().sort(arr);
        Assert.assertEquals(arr,testData.getExpectedValue());
    }
}
