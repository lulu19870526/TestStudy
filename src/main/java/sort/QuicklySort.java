package sort;

public class QuicklySort {
    //通过一趟排序将待排记录分割成两部分，其中一部分记录的关键字比另一部分记录的关键字小
    private static int getMiddle(Integer[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }//最终结束：low=high
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }
    private static void quickSort(Integer[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] list={34,3,53,2,23,7,14,10};
        quickSort(list,0,list.length-1);
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
