package methodinvoke;

/**
 * 动态分派
 * 根据方法接收者实际类型
 * invokevirtual指令 找到操作数栈顶第一个元素指向的对象的实际类型C
 * C中找方法 找到就验证权限 否则在C的父类找
 */
public class DynamicDispatch {
    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human {
        @Override
        protected void sayHello(){
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human {
        @Override
        protected void sayHello(){
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        man.sayHello(); //输出 man say hello
    }
}
