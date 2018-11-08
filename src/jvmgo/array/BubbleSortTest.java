package jvmgo.array;

/**
 * @Author: myname
 * @Date: 2018/11/7 14:32
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {22,84,77,11,95,9,78,56,36,97,65,36,10,24,92};
        bubbleSort(arr);
        printArray(arr);
    }
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void printArray(int[] arr) {
        for(int i:arr ){
//            System.out.println(i+" ");//此时还不能识别String类型
            System.out.println(i);
        }
    }
}
