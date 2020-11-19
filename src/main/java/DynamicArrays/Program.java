package DynamicArrays;

import DynamicArrays.model.*;


import java.util.Date;

public class Program {

    public static void main(String[] args) {
        IArray singleArray = new SingleArray();
        IArray vectorArray = new VectorArray();
        IArray factorArray = new FactorArray();
        IArray matrixArray = new MatrixArray();
        IArray ListArray = new ArrayListWrapper();
        testAddArray(singleArray, 100_0);
        testAddArray(vectorArray, 100_0);
        testAddArray(factorArray, 100_0);
        testAddArray(ListArray, 100_0);
        testAddArray(matrixArray, 100_0);
    }

    static void testAddArray(IArray data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j++)
            data.add(new Date());

        System.out.println(data + " testAddArray: " +
                (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        for (int j = 0; j < total - 1; j++)
            data.remove(0);

        System.out.println(data + " testRemoveArray: " +
                (System.currentTimeMillis() - start));

        for (int j = 0; j < total - 1; j++)
            data.add(new Date(), 0);

        System.out.println(data + " testAddToBeginningArray: " +
                (System.currentTimeMillis() - start));
        System.out.println();
    }
}
