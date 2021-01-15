package cz.yb.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufTest {
    public  static  void  main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student stu = DataInfo.Student.newBuilder().setName("只是").setAge(16).setAddress("cxcxcxc").build();
        byte[] bArrStu =stu.toByteArray();
        DataInfo.Student stu2 = DataInfo.Student.parseFrom(bArrStu);
        System.out.println(stu2.getName());

    }
}
