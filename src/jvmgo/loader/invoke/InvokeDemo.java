package jvmgo.loader.invoke;

/**
 * @Author: myname
 * @Date: 2018/11/6 17:09
 */
public class InvokeDemo implements Runnable{
    public static void main(String[] args) {
        new InvokeDemo().test();
    }
    public void test(){
        InvokeDemo.staticMethod(); //invokestatic
        InvokeDemo demo = new InvokeDemo();
        demo.instanceMethod(); //invokevirtual
        super.equals(null);
        this.run();
        ((Runnable)demo).run();
    }
    public static void staticMethod(){

    }
    private void instanceMethod(){

    }
    @Override
    public void run() {

    }
}
