package slot;
/*
    slot局部变量表回收
   VM args:
       -verbose:gc
 */
public class Test {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
//        int a = 0;
        System.gc();
    }
}
