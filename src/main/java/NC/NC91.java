package NC;

public class NC91 {

    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        int[] result = LIS(arr);
        for(int num:result)
            System.out.println("num=" + num);
    }

    public static int[] LIS (int[] arr) {
        // write code here
        if(arr == null || arr.length <= 1)
            return arr;

        int[] end = new int[arr.length];
        int[] childLen = new int[arr.length];
        int len = 1;
        end[0] = arr[0];
        childLen[0] = len;
        for(int i = 1; i < arr.length;i++){
            if(end[len - 1] < arr[i]){
                end[len++] = arr[i];
                childLen[i] = len;
            }else if(end[len - 1] == arr[i]){
                childLen[i] = len;
            }else{
                int index = getFirstAbove(end,len,arr[i]);
                end[index] = arr[i];
                childLen[i] = (index + 1);
            }
        }

        int[] result = new int[len];
        for(int i = arr.length-1;i >= 0;i--){
            if(childLen[i] == len){
                result[--len] = arr[i];
            }
        }
        return result;
    }

    public static int getFirstAbove(int[] end,int len,int key){
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(end[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
