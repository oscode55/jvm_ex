package methodinvoke;

/**
 * 宗量：方法接收者与方法参数
 * 方法的静态分派：多宗量
 * 编译阶段选择：根据静态类型 和 方法参数
 * 方法的动态分派：单宗量
 * 运行时选择：根据方法接受者的实际类型
 */
public class Dispatch {
    static class QQ {}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }
        public void hardChoice(_360 arg){
            System.out.println("father choose 360");
        }
    }
    public static class Son extends Father {
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }
        public void hardChoice(_360 arg){
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        //根据传入的参数 选择
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
