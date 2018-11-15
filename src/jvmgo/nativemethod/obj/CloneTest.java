package jvmgo.nativemethod.obj;

/**
 * @Author: myname
 * @Date: 2018/11/14 15:44
 */
public class CloneTest implements Cloneable {
    private double pi = 3.14;
    @Override
    protected CloneTest clone() {
        try {
            return (CloneTest)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CloneTest obj1 = new CloneTest();
        CloneTest obj2 = obj1.clone();
        obj1.pi = 3.1415926;
        System.out.println(obj1.pi);
        System.out.println(obj2.pi);
    }
}
