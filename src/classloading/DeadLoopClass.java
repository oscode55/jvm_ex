package classloading;

/**
 * 多个线程初始化同个类 同步加锁 其他线程等待
 */
public class DeadLoopClass {
    static {
        if(true) {
            System.out.println(Thread.currentThread()+" init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script =new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+" start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread()+" run over");
            }
        };
        Thread t1=new Thread(script);
        Thread t2=new Thread(script);
        t1.start();
        t2.start();
    }
}
