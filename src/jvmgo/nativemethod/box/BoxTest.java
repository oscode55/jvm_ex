package jvmgo.nativemethod.box;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: myname
 * @Date: 2018/11/14 15:56
 * 自动装箱测试
 */
public class BoxTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        for(int x:list){
            System.out.println(x);
        }
    }
}
