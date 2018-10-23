package temp;

/**
 * @ProjectName: jvm
 * @Package: temp
 * @ClassName: PrintqAndO
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/12 20:11
 * @Version: 1.0
 */
class Num { //资源
    int i = 1;
    boolean flag = false;//交替执行标志位
}
class PrintQ implements Runnable {
    Num num;
    public PrintQ(Num num){
        this.num=num;
    }
    @Override
    public void run(){
        while(true){
            synchronized (num){
                if(num.flag){
                    try {
                        num.wait();//等待其他线程通过
                    }catch (Exception e){ }
                }else{
                    System.out.println("Q:"+num.i);
                    num.i++;
                    num.flag=true;
                    num.notify();//唤醒其他线程
                }
            }
        }
    }
}
class PrintO implements Runnable {
    Num num;
    public PrintO(Num num) {
        this.num = num;
    }
    public void run()
    {
        while(num.i<=100)
        {
            synchronized (num)/* 必须要用一把锁对象，这个对象是num*/ {
                if(!num.flag)
                {
                    try
                    {
                        num.wait();  //操作wait()函数的必须和锁是同一个
                    } catch (Exception e){}
                }
                else {
                    System.out.println("O:"+num.i);
                    num.i++;
                    num.flag = false;
                    num.notify();
                }
            }
        }
    }
}
public class PrintqAndO {
    public static void main(String[] args) {
        Num num = new Num();
        PrintQ pQ = new PrintQ(num);
        PrintO pO = new PrintO(num);

        Thread aThread = new Thread(pQ);
        Thread bThread = new Thread(pO);

        aThread.start();
        bThread.start();
    }
}
