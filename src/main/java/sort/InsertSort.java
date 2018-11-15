package sort;

public class InsertSort {

    public static void main(String[] args) {

        int arr[] = {1,4,6,8,2,5,3,7,9};
        System.out.println("数组排序前顺序：");
        for(int n : arr){
            System.out.print(n+" ");
        }

        //直接插入排序
        insertSort(arr);

        System.out.println("\n数组排序后顺序：");
        for(int n : arr){
            System.out.print(n+" ");
        }

    }

    //直接插入排序
    private static void insertSort(int[] arr){

        //外层循环确定待比较数值
        for (int i=1;i<arr.length;i++) {  //必须i=1，因为开始从第二个数与第一个数进行比较
            int temp = arr[i];  //待比较数值
            int j = i - 1;
            //内层循环为待比较数值确定其最终位置
            for (;j>=0 && arr[j]>temp;j--) {  //待比较数值比前一位置小，应插往前插一位
                //将大于temp的值整体后移一个单位
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp; //待比较数值比前一位置大，最终位置无误
        }
    }
}
