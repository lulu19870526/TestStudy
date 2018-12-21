package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;


/**
 * 163 Missing Ranges 缺失区间
 *
 *
 * Given a sorted integer array where the range of elements are [0, 99] inclusive,
 * return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class MissingRanges163 {

    public static void main(String[] args){
        int[] nums = {0, 1, 3, 50, 75};
        List<String> list = getMissingRange(nums,0,99);
        System.out.println("list="+ JSON.toJSONString(list));
    }

    public static List<String> getMissingRange(int[] nums, int lower, int higher){
        List<String> list = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            list.add(lower+"->"+higher);
        }

        int expect = lower;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != expect)
           {
                int gap = nums[i] - expect;
                if(gap == 1){
                    list.add(expect+"");
                }else{
                    list.add(expect+"->"+(nums[i]-1));
                }
            }
            expect = nums[i]+1;
        }
        if(expect != higher){
            int gap = higher - expect;
            if(gap == 1){
                list.add(expect+"");
            }else{
                list.add(expect+"->"+higher);
            }
        }
        return list;
    }

}
