package DynamicArrays.model;

public class VectorArray<T> implements IArray<T> {

    private Object[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        if (size()==array.length)
            resize();
        for (int i=size();i>index;i--){
            array[i] = array[i-1];
        }
        array[index]=item;
        size++;
    }

    @Override
    public T remove(int index) {
        T res = get(index);
        if (size==1) {
            array[0] = null;
            return res;
        }
        for (int j = index; j < size()-1; j ++) {
            array[j] = array[j + 1];
        }
        array[--size]=null;
        return res;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
