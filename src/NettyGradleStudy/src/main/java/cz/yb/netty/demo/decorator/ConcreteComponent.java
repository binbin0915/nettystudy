package cz.yb.netty.demo.decorator;

public class ConcreteComponent implements  Component {
    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
