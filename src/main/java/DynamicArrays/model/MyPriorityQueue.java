package DynamicArrays.model;

public class MyPriorityQueue<T> implements PriorityQueue<T> {

    private FactorArray<T>[] queues;

    public MyPriorityQueue(int prioritiesNumber) {
        queues = new FactorArray [prioritiesNumber];
        for (int i=0; i<prioritiesNumber;i++){
            queues[i] = new FactorArray<T>();
        }
    }

    @Override
    public void enqueue(int priority, T item) {
        verifyPriority(priority);
        queues[priority].add(item);
    }

    @Override
    public T dequeue() {
        for (FactorArray<T> queue : queues){
            if (queue.size()!=0)
                return queue.remove(0);
        }
        return null;
    }

    private void verifyPriority(int priority){
        if (priority<0 | priority> queues.length-1)
            throw new IndexOutOfBoundsException("Queue have no priority '"+priority+"'");
    }
}
