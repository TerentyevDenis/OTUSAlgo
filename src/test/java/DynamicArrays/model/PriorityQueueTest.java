package DynamicArrays.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PriorityQueueTest {

    @Test
    void test(){
        MyPriorityQueue queue = new MyPriorityQueue<Integer>(2);
        queue.enqueue(0,1);
        queue.enqueue(1,3);
        queue.enqueue(0,2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}