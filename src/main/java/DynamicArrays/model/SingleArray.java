package DynamicArrays.model;

import java.util.ArrayList;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        resize();
        for (int i=size()-1;i>index;i--){
            array[i] = array[i-1];
        }
        array[index]=item;
    }

    @Override
    public T remove(int index) {
        T res = get(index);
        int delta=0;
        Object[] newArray = new Object[size() - 1];
        for (int j = 0; j < size(); j ++){
            if (j==index){
                delta=1;
            }else {
                newArray[j-delta] = array[j];
            }
        }
        array = newArray;
        return res;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
//        for (int j = 0; j < size(); j ++)
//            newArray[j] = array[j];
        array = newArray;
    }
}
