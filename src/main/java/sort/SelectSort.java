package sort;

/**
 * 时间复杂度o(n2)
 */
public class SelectSort {

    public static void main(String[] args){
        int arr[] = {1,4,6,8,2,5,3,7,9};
        System.out.println("数组排序前顺序：");
        for(int n : arr){
            System.out.print(n+" ");
        }


        sort(arr);

        System.out.println("\n数组排序后顺序：");
        for(int n : arr){
            System.out.print(n+" ");
        }

    }
    //简单选择排序：每一趟在n-i个记录中取关键字最小的记录作为有序序列中第i个元素
    public static void sort(int[] R){
        int i,j,k;
        int temp;
        for(i=0;i<R.length;i++){
            k=i;//k表示最小的元素的坐标；
            //在无序序列中找到最小的元素
            for(j=i+1;j<R.length;j++){
                if(R[k]>R[j]){
                    k=j;
                }
            }

            if(i != k){
                //最小元素和无序序列的第一个元素交换
                temp = R[k];
                R[k]=R[i];
                R[i]=temp;
            }

        }
    }
}
