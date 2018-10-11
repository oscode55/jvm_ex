package outofmemory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/*
    运行时常量池 溢出
 */
//VM Args:
// -XX:PermSize=10M -XX:MaxPermSize=10M
public class RuntimeConstantPoolOOM {
    static class OOMObject{

    }
    //jdk1.6:造成OOM PermGen溢出
    //jdk1.7:没有溢出 常量池移到Heap区 Method Area只记录引用
    public void StringOOM(){
        //使用List保持常量池引用不至于导致Full GC回收常量池
        List<String> list=new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
    public void ClassOOM(){
        while(true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,objects);
                }
            });
            enhancer.create();
        }
    }
    public static void main(String[] args) {
        new RuntimeConstantPoolOOM().ClassOOM();
    }
}
