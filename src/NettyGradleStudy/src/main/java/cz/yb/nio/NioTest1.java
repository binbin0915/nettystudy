package cz.yb.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity() ; i++) {
            int randNum = new SecureRandom().nextInt(20);
            buffer.put(randNum);
        }
        //翻转到初始部位指针
        System.out.println("==========before flip============");
        System.out.println("limit:"+buffer.limit());
        buffer.flip();
        System.out.println("==========after flip============");
        System.out.println("limit:"+buffer.limit());
        System.out.println("==========enter whileloop============");
        while (buffer.hasRemaining()){
            System.out.println("position:"+buffer.position());
            System.out.println("limit:"+buffer.limit());
            buffer.get();
//            System.out.println(buffer.get());
        }
    }
}
