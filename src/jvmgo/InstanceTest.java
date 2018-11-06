package jvmgo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @ProjectName: jvm_ex
 * @Package: temp
 * @ClassName: InstanceTest
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/11/5 15:21
 * @Version: 1.0
 */
public class InstanceTest {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>() instanceof Collection);
    }
}
