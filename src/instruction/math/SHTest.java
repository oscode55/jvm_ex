package instruction.math;

/**
 * 位移指令
 */
public class SHTest {
    //右移分为: 算术右移(补1) 和 逻辑右移(补0)
    public static void testUnsignOrSignSH(){
        int x = -256;//补码存储 11111111 11111111 11111111 11111111
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x >> 8));//算术右移
//        System.out.println(x>>8);//-1
        System.out.println(Integer.toBinaryString(x >>> 8));//逻辑右移
//        System.out.println(x>>>3);
    }
    public static void testChar(){
        char c = 10;
        System.out.println(Integer.toBinaryString(c));

    }
    public static void main(String[] args) {
        SHTest.testUnsignOrSignSH();
//        SHTest.testChar();
    }

}
