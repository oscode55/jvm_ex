package jvmgo.nativemethod;

/**
 * @Author: myname
 * @Date: 2018/11/14 14:27
 */
public class Main {
    public static void main(String[] args) {
//        Class.getName();
        new StringBuilder().append("1");
        new Integer(1).getClass().getName();
        new Object().toString();
        new int[1].clone();
        Class c = Void.TYPE;
    }
}
