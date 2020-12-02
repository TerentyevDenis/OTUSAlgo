package LineaSort;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class FileGenerator {
    static final int BUFFER_SIZE_SHORT = 1000000;
    public static void generateFile(int size){
        try(FileOutputStream fos=new FileOutputStream("numberSorts/10")){
            Random random = new Random();
            while (size>0) {
                ByteBuffer byteBuf = ByteBuffer.allocate(size > BUFFER_SIZE_SHORT ? 2*BUFFER_SIZE_SHORT : 2*size);
                random.ints(size > BUFFER_SIZE_SHORT ? BUFFER_SIZE_SHORT : size, 0, 65535)
                        .forEach(elem -> {byteBuf.putShort((short) elem);});
                fos.write(byteBuf.array());
                size=size-BUFFER_SIZE_SHORT;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void read(){
        try(FileInputStream fis=new FileInputStream ("numberSorts/10");
            DataInputStream dis = new DataInputStream(fis)) {
            while (dis.available()!=0) {
                System.out.println(dis.readUnsignedShort());
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args){
        generateFile(10);
        read();
        System.out.println();
        SortingByCounting mergeFileSort = new SortingByCounting();
        mergeFileSort.sort("numberSorts/10");
        read();
    }
}
