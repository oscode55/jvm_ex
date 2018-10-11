package classloading;

/**
 * 字段的解析
 */
public class FieldResolution {

    interface Interface {
        int A = 2;
    }
    static class Parent {
        public static int A = 3;
    }
    static class Sub extends Parent implements Interface {
        //Sub.A 首先找Sub类 再找Interface接口 最后找父类
    }

    public static void main(String[] args) {
//        System.out.println(Sub.A);
    }
}
