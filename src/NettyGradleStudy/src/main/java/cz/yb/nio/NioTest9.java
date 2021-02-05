package cz.yb.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//内存映射 直接修改内存里的
//IDEA Bug? 不会实时刷新
public class NioTest9 {
    public static void main(String[] args) throws  Exception {
        String inputFile = "NioTest9.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile,"rw");



        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();


        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_WRITE,0,5);

        inputData.put(0,(byte)'z');
        inputData.put(3,(byte)'y');


        inputRandomAccessFile.close();

    }
}
