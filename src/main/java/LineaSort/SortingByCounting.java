package LineaSort;

import java.io.*;

public class SortingByCounting {
    private int[] counts = new int[65536];

    public void sort(String file) {
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream buf = new BufferedInputStream(fis, 10000);
             DataInputStream dis = new DataInputStream(buf)) {
            while (dis.available() > 0) {
                counts[dis.readUnsignedShort()]++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos, 10000)) {
            for (int i = 0; i < counts.length; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    bos.write(i / 256);
                    bos.write(i % 256);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long time = System.nanoTime();
        SortingByCounting mergeFileSort = new SortingByCounting();
        mergeFileSort.sort("numbersToSort");
        System.out.println(System.nanoTime() - time);
    }
}
