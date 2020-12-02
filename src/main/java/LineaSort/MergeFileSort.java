package LineaSort;

import java.io.*;
import java.nio.ByteBuffer;

public class MergeFileSort {

    public void sort(int LastIndex) {
        sort(0, LastIndex);
    }

    private void merge(int leftElem, int center, int rightElem) {
        try (FileInputStream fisL = new FileInputStream("numberSorts/" + leftElem + "." + center);
             BufferedInputStream bufIL = new BufferedInputStream(fisL, 1000);
             DataInputStream disL = new DataInputStream(bufIL);
             FileInputStream fisR = new FileInputStream("numberSorts/" + (center + 1) + "." + rightElem);
             BufferedInputStream bufIR = new BufferedInputStream(fisR, 1000);
             DataInputStream disR = new DataInputStream(bufIR);
             FileOutputStream fos = new FileOutputStream("numberSorts/" + leftElem + "." + rightElem);
             BufferedOutputStream bos = new BufferedOutputStream(fos, 1000)) {
            int leftNumber = disL.readUnsignedShort();
            int rightNumber = disR.readUnsignedShort();
            while (leftNumber != -1 || rightNumber != -1) {
                if (leftNumber != -1 && leftNumber < rightNumber || rightNumber == -1) {
                    bos.write(leftNumber / 256);
                    bos.write(leftNumber % 256);
                    leftNumber = disL.available() > 0 ? disL.readUnsignedShort() : -1;
                } else if (rightNumber != -1) {
                    bos.write(rightNumber / 256);
                    bos.write(rightNumber % 256);
                    rightNumber = disR.available() > 0 ? disR.readUnsignedShort() : -1;
                }
            }
            bos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        File leftFile = new File("numberSorts/" + leftElem + "." + center);
        leftFile.delete();
        File rightFile = new File("numberSorts/" + (center + 1) + "." + rightElem);
        rightFile.delete();
    }

    private void sort(int leftElem, int rightElem) {
        if (leftElem >= rightElem) return;
        int center = (leftElem + rightElem) / 2;
        splitFiles(leftElem, center, rightElem);
        sort(leftElem, center);
        sort(center + 1, rightElem);
        merge(leftElem, center, rightElem);
    }

    private void splitFiles(int leftElem, int center, int rightElem) {
        try (FileInputStream fis = new FileInputStream("numberSorts/" + leftElem + "." + rightElem);
             BufferedInputStream bufIN = new BufferedInputStream(fis, 1000);
             FileOutputStream fosL = new FileOutputStream("numberSorts/" + leftElem + "." + center);
             BufferedOutputStream bosL = new BufferedOutputStream(fosL, 1000);
             FileOutputStream fosR = new FileOutputStream("numberSorts/" + (center + 1) + "." + rightElem);
             BufferedOutputStream bosR = new BufferedOutputStream(fosR, 1000)) {
            int count = 0;
            int elem = bufIN.read();
            while (elem != -1 && count < (center - leftElem) * 2 + 2) {
                bosL.write(elem);
                elem = bufIN.read();
                count++;
            }
            while (elem != -1) {
                bosR.write(elem);
                elem = bufIN.read();
            }
            bosL.flush();
            bosR.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long time = System.nanoTime();
        MergeFileSort mergeFileSort = new MergeFileSort();
        mergeFileSort.sort(999999999);
        System.out.println(System.nanoTime() - time);
    }
}

