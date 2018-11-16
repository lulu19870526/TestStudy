package sort;

public class binary_insert_sort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int array[] = {23,12,34,56,78,67,99,100};
        System.out.println("---------排序前的结果----------");
        binary_insert_sort.output(array);
        System.out.println("---------排序后的结果----------");
        binary_insert_sort.binary_insert_sort(array);
        binary_insert_sort.output(array);
    }
    //折半插入排序算法
    public static void  binary_insert_sort(int[] arr){
        int low,high,mid,temp,j;
        for(int i=1;i<arr.length;i++){
            temp = arr[i];
            low = 0;
            high = i-1;
            while(low <=high){
                mid =(high+low)/2;
                if(arr[mid] > temp){
                    high = mid -1;
                }
                else
                {
                    low = mid+1;
                }
            }
            for(j = i-1;j >=high+1; j--)
                arr[j+1] = arr[j];
            arr[j+1] = temp;
        }

    }
    //输出打印
    public static void output(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

}

