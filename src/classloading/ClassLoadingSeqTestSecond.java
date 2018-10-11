package classloading;

/**
 * @ProjectName: jvm
 * @Package: classloading
 * @ClassName: ClassLoadingSeqTest_2nd
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/11 11:00
 * @Version: 1.0
 */
/*类加载顺序测试*/
/*类的加载(1.加载2.验证3.准备4.解析5.初始化*/
class A {
    //初始化阶段执行
    static {
        System.out.print("1");
    }

    public static final int a_number = 2;//静态常量在准备阶段赋值为ConstantValue

    //实例化阶段执行
    public A() {
        System.out.print("3");
    }
}

class B extends A {
    static {
        System.out.print("4");
    }

    public static int b_number = 5;//静态变量 准备阶段赋零值 初始化阶段赋值5

    public B() {
        System.out.print("6");
    }
}

public class ClassLoadingSeqTestSecond {

    public static void main(String[] args) {
        System.out.print(A.a_number);//2 访问静态常量 无需初始化类
        System.out.print(B.b_number); // 1 4 5 单独执行输出
        B b = new B(); // 1 4 3 6 单独执行输出
//        一起执行输出 2 1 4 5 3 6
        /*
         #2 静态常量输出
         #1 初始化A
         #4 初始化B
         #5 getStatic( B.b_number )
         #3 <init>() A
         #6 <init>() B
        */

    }
}

