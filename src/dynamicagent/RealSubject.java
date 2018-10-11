package dynamicagent;

//委托类 真实的处理逻辑
public class RealSubject implements Interface {
    @Override
    public void sell(String msg) {
        System.out.println("商品:"+msg);
    }
}
