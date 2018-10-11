package gcc;
/*
    -Xms20M
    -Xmx20M  设置Heap最大和最小
    -Xmn10M  设置新生代
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8 设置分区比例
    -XX:PretenureSizeThreshold=3145728 设置超过3M的对象直接分配到老年代

    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=3145728

 */
public class PretenureSizeThreshold {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        byte[] allocation;
        allocation=new byte[_1MB*3];
    }
}
