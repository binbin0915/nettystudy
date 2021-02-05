package cz.yb.netty.demo.decorator;

/***
 * 装饰模式
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.doSomething();
    }
}
