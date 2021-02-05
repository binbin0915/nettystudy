package cz.yb.netty.demo.decorator;

/***
 * 装饰
 */
public class Decorator implements  Component {
    //抽象构建角色引用
    private  Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
