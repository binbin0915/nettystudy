package cz.yb.netty.demo.decorator;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherthing();
    }

    private void doAnotherthing(){
        System.out.println("功能C");
    }
}
