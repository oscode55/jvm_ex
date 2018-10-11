package gcc;
/*
-Xms20M
-Xmx20M
-Xmn10M
-XX:+PrintGCDetails
-XX:SurvivorRatio=8
-XX:MaxTenuringThreshold=1
//设置年龄阀值
 */
public class TenuringThreshold {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1=new byte[_1MB/4];//新生代
        allocation2=new byte[4*_1MB];//新生代
        allocation3=new byte[4*_1MB];//Minor GC
        allocation3=null;//allocation3到老年代
        allocation3=new byte[4*_1MB];//新生代

    }
}
