package jvmgo;

/**
 * @Author: myname
 * @Date: 2018/11/5 16:22
 * ch06类加载器 尝试实现ldc new putstatic getstatic putfield getfield instanceof checkcast
 */
public class MyObject {
    public static int staticVar;
    public int instanceVar;

    public static void main(String[] args) {
        int x = 32768; //ldc
        MyObject myObj = new MyObject(); // new
        MyObject.staticVar = x; //putstatic
        x = MyObject.staticVar; //getstatic
        myObj.instanceVar = x; //putfield
        x = myObj.instanceVar; //getfield
        Object obj = myObj;
        if(obj instanceof MyObject) { //instanceof
            myObj = (MyObject) obj; //checkcast
            System.out.println(myObj.instanceVar);
        }
    }
}
