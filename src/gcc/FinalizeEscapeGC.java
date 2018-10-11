package gcc;

//1.对象可以在被GC时自我拯救
//2.机会只有一次,一个对象的finalize方法最多被jvm调用一次
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;
    public void isAlive(){
        System.out.println("yes,i am still alive :)");
    }
    //放在优先队列 优先级低 程序不保证它执行完成
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }
    public static void main(String[] args) throws Throwable {
        SAVE_HOOK=new FinalizeEscapeGC();//对象1
        //1.对象能成功拯救自己
        SAVE_HOOK=null;//对象1失去引用,即将被回收
        System.gc();//提醒垃圾回收期回收s
        Thread.sleep(500);//finalize方法优先级低,暂停0.5秒等待它执行

        if(SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no,i am dead :(");

        //2.对象无法拯救自己,finalize只能执行一次
        SAVE_HOOK=null;//对象1失去引用,即将被回收
        System.gc();//提醒垃圾回收器回收s
        //对象成功拯救了自己,该对象不会被回收
        Thread.sleep(500);//finalize方法优先级低,暂停0.5秒等待它执行
        if(SAVE_HOOK!=null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no,i am dead :(");

    }
}
