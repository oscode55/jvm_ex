package instruction.math;

/**
 * 求余指令 rem
 * 整型、长整型 除数为0 抛出异常 "java.lang.ArithmeticException: / by zero"
 * 浮点数 有无穷大Infinity 不会抛出异常
 * 浮点运算可能产出数值 NaN (not a number)
 */
public class RemTest {
    public static void testDoubleRem(){
        System.out.println("double Rem Test");
        double x1 = 2,x2=0,divResult=0,remResult=0;
        divResult = x1/x2;
        remResult = x1%x2;
        System.out.println("divResult: "+divResult);//Infinity
        System.out.println("remResult: "+remResult);//NaN
    }
    public static void testIntRem(){
        System.out.println("int Rem Test");
        int x1 = 2,x2=0,divResult=0,remResult=0;
        divResult = x1/x2;
        remResult = x1%x2;
        System.out.println("divResult: "+divResult);//Infinity
        System.out.println("remResult: "+remResult);//NaN
    }

    public static void main(String[] args) {
        RemTest.testDoubleRem();
        RemTest.testIntRem();
    }

}
