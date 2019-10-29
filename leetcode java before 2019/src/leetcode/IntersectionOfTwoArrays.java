/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/
/**
 * 这道题的目标是找出两个整数数组公共的部分（而且要去重，就是如果重复了两个2，只输出一个2）
 * 我的思路是用一个bit vector当做map用，先把第一个数组的所有数字遍历一遍存入map,然后遍历第二个数组查看公共部分
 * @author Jiexin Guo
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[1000];
        for (int i : nums1) {
            int index=i/32;
            int leftShift=i%32;
            map[index]=map[index]|(1<<leftShift);
        }
        for(int i:nums2){
            int index=i/32;
            int rightShift=i%32;
            boolean exist=((map[index]>>rightShift)&0x01)==1;
            if(exist){
                result.add(i);
                map[index]&=(~(1<<rightShift));
            }
        }
        int[] newRes=new int[result.size()];
        int index=0;
        for(int i:result){
            newRes[index++]=i;
        }
        return newRes;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] num1 = { 1, 2, 2, 1 };
        int[] num2 = { 2, 2 };
        int[] result=intersection(num1,num2);
        for(int i:result){
            System.out.println(i);
        }
    }

}
