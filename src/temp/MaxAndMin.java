package temp;


import java.util.function.Function;

/**
 * @ProjectName: jvm
 * @Package: temp
 * @ClassName: Test
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/12 19:43
 * @Version: 1.0
 */
public class MaxAndMin {
    public static void main(String[] args) {
        System.out.println(fun(18,12));
    }
    //最大公约数,辗转相除法
    public static int fun(int a,int b){
        if(b==0)
            return a;
        else
            return fun(b,a%b);
    }
    /*
    12 18
     18 12
       12 6
       6 0
    */
    //最小公倍数,两数之积处于最大公约数
    public static int fun2(int a,int b){
        return (a*b)/fun(a,b);
    }
}
