package instruction.math;

/**
 * switch case
 * case {0,1,2,3,4}
 * 如果case值可以编码成一个索引表 实现成tableswitch 指令
 * 否则{1,100,233,1433223}不能编码成索引表则实现成 lookupswitch指令
 */
public class SwitchTest {
    /**
     * type TABLE_SWITCH struct {
     *     defaultOffset int32   //u4 default情况的偏移量
     *     low           int32   //u4 偏移量起始的索引
     *     high          int32   //u4 偏移量结束的索引
     *      #非default情况的索引表
     *      #对应每种情况对应的偏移量 长度[high-low+1]
     *      #根据传入的case 到jumpOffsets[case]
     *      #当然要先判断case是否在[low,high]
     *     jumpOffsets   []int32 //
     *
       }
     */
    public static void tableswitch(){

    }

    /**
     *
     *type LOOKUP_SWITCH struct {
        defaultOffset int32 //默认偏移
        npairs        int32 //
        #类似字典类型 key是case值 value是偏移指令
        #索引{0,2,4,6...} 存key
        #索引{1,3,5,7...} 存value
        matchOffsets  []int32 //容量是 npairs的两倍
     }
         这样每传入一个值 都要去matchOffsets查找key 再返回key下一个值
     */
    public static void lookupswitch(){

    }
    public static void main(String[] args) {
    }
}
