package gcc;

/*
   -Xms20M 堆最小20M
   -Xmx20M 堆最大20M
   -Xmn10M 新生代10M
   -XX:+PrintGCDetails 打印GC日志
   -XX:SurvivorRatio=8 设置Survivor区的大小8:1:1
 */
public class MinorGC {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        //对象优先在Eden 8MB 和 From 1MB 这9MB的内存中分配
        allocation1=new byte[2*_1MB];//Eden 2MB 剩余6MB
        allocation2=new byte[2*_1MB];//Eden 4MB 剩余4MB
        allocation3=new byte[2*_1MB];//Eden 6MB 剩余2MB

        allocation4=new byte[4*_1MB];
        //出现一次Minor GC
        //对象1 2 3 还有强引用 不可回收
        //复制清除算法 对象1 2 3 考虑进入To 区 1MB 不够装
        //对象1 2 3 只能通过担保分配机制 进入老年代
    }
}
