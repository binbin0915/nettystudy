package cz.yb.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("127.0.0.1",9988),600);
        TProtocol protocol  = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person2 =  new Person();
            person2.setUsername("李四");
            person2.setAge(11);
            person2.setMarried(true);
            client.savePerson(person2);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            transport.close();
        }

    }
}
