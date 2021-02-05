package cz.yb.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioTest11 {
    public static void main(String[] args)  throws  Exception{
        ServerSocketChannel serverSocketChannel =ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);

        int messageLength = 2+3+4;

        ByteBuffer[]  byteBuffers = new  ByteBuffer[3];
        byteBuffers[0]=ByteBuffer.allocate(2);
        byteBuffers[1]=ByteBuffer.allocate(3);
        byteBuffers[2]=ByteBuffer.allocate(4);

        SocketChannel socketChannel =serverSocketChannel.accept();
        while (true){
            int byteRead = 0;
            while (byteRead < messageLength){
                long r = socketChannel.read(byteBuffers);
                byteRead +=r;

                System.out.println("byteRead:"+byteRead);

                Arrays.asList(byteBuffers).stream()
                        .map(buffer->"position:"+buffer.position()+",limit:"+buffer.limit())
                        .forEach(System.out::println);

            }

            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());


            long byteWriten = 0;
            while (byteWriten< messageLength){
                long r = socketChannel.write(byteBuffers);
                byteWriten +=r;
            }

            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());

            System.out.println("byteRead:"+byteRead+",byteWriten:"+byteWriten);
        }

    }
}
