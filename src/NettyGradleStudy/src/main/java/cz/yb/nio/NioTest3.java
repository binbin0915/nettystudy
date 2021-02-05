package cz.yb.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 写文件
 */
public class NioTest3 {
    public static void main(String[] args) throws  Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] arrMsg = "hello word \r\nniohao\n12".getBytes();
        for (int i = 0; i < arrMsg.length; i++) {
            byteBuffer.put(arrMsg[i]);
        }
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
