package cz.yb.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl  implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
       System.out.println("Get Client Params:"+username);

       Person person = new Person();
       person.setAge(10);
       person.setMarried(false);
       person.setUsername(username);

       return person;

    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Get Client Params:");
        System.out.println(person.getAge());
        System.out.println(person.getUsername());
        System.out.println(person.isMarried());

    }
}
