package sort;

/**
 * 冒泡排序时间复杂读为o(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
      int[] arr={6,3,8,2,9,1};
      System.out.println("排序前数组为：");
      for(int num:arr){
       System.out.print(num+" ");
      }

      //冒泡排序：第一趟，使关键字最大的记录被安置在最后一个记录的位置上，依次类推
      for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
        for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
         if(arr[j]>arr[j+1]){
             int temp=arr[j];
             arr[j]=arr[j+1];
             arr[j+1]=temp;
         }
     }
    }
       System.out.println();
       System.out.println("排序后的数组为：");
       for(int num:arr){
          System.out.print(num+" ");
       }
      }
}
