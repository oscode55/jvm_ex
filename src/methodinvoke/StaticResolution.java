package methodinvoke;

//static方法 使用的指令是 invokestatic
//使用 javap -verbose StaticResolution.class 反编译
public class StaticResolution {
    public static void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
