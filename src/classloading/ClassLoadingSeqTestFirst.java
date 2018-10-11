package classloading;

//测试类的加载顺序1
public class ClassLoadingSeqTestFirst {
    static class Parent {
        //以下语句 在类初始化时完成 <clinit>() 按顺序执行
        public static int A = 1;
        static {
            A = 2;
        }


    }
    //加载Sub类 必先加载完Parent类型
    static class Sub extends Parent {
        public static int B = A; //B属于类常量 使用getStatic指令 必须加载该类

        //初始化阶段执行
        static {
            C = 2; //可以赋值
//            System.out.println(C);//未初始化完成 不能访问
        }
        public static int C;//在准备阶段 赋零值

        //类的加载(1.加载.2.验证3.准备4.解析5.初始化
    }

    public static void main(String[] args) {
        System.out.println(Parent.A);//输出2
        System.out.println(Sub.B);//输出2
    }
}
