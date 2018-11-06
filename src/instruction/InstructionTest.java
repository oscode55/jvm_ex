package instruction;

import instruction.math.RemTest;

import java.lang.reflect.Field;

/**
 * @ProjectName: jvm
 * @Package: instruction
 * @ClassName: InstructionTest
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/19 13:59
 * @Version: 1.0
 */
public class InstructionTest {
    public static void main(String[] args) {
//        RemTest.testDoubleRem();
//        RemTest.testIntRem();
//        System.out.println(186.53/100000);
        Class c = Student.class;
        for(Field field:c.getDeclaredFields()){
            System.out.println(field.getName());
        }
        try {
            Field field = c.getField("name");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    private String no;
    private String name;
    private String sex;
    public String Tag;
    public Student(){
        System.out.println("student instance");
    }
    public Student(String no,String name,String sex){

    }
    public void defaultMethod(){
        System.out.println("defaultMethod");
    }
}
