package gcc;
/*
    测试GC是否采用了引用计数算法
    答案是没有!!
    VM Args:-XX:+PrintGCDetails //打印GC日志参数
 */
public class ReferenceCountingGC {
    public Object instance=null;
    private static final int _1MB=1024*1024;
    //这个成员属性的意义在于占用内存，以便于在GC日志中看是否被回收
    private byte[] bigSize=new byte[2*_1MB];
    public static void testGC(){
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;//相互引用

        objA=null;
        objB=null;

        //若使用了引用计数算法,由于两个实例都有被引用，所以应该不被回收
        System.gc();
        //但结果显示回收了
    }
    public static void main(String[] args) {
        testGC();
    }
}
