package classloading;

import java.io.IOException;
import java.io.InputStream;
/*
    类加载器测试 当使用不同的类加载器加载类 代表不一样的类
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        //自定义类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                //获取加载的类名称
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                //获取this的类对象实例
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is==null){
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name,b,0,b.length);
            }
        };
        //用自定义加载器 去加载ClassLoaderTest
        Object obj = myLoader.loadClass("classloading.ClassLoaderTest").newInstance();
        //输出false 因为不是同一个类加载器加载出来的对象
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
