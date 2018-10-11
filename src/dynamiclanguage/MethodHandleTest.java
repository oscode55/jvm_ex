package dynamiclanguage;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA {
        public void println(int s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable{
        Object obj = new ClassA();
        //无论obj最终是哪个类都能调用println方法
        getPrintlnMH(obj).invokeExact(1);
    }
    private static MethodHandle getPrintlnMH(Object reveiver) throws  Throwable {
        //MethodType代表方法类型,包含方法返回值 arg0 具体参数列表 arg1~
        MethodType mt = MethodType.methodType(void.class,int.class);
        //lookup()来自MethodHandles.lookup,在指定类中查找给定方法名称、方法类型、符合调用权限的方法句柄
        //调用的是虚方法，arg0是隐式代表方法的接受者，也就是this指向的对象,现在使用bindTo完成
        return lookup().findVirtual(reveiver.getClass(),"println",mt).
                bindTo(reveiver);
    }
}
