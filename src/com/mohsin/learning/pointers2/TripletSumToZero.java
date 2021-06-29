package com.mohsin.learning.pointers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class TripletSumToZero {

    static class Triplet{
        int x,y,z;

        public Triplet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "("+ x +","+ y + "," + z +')';
        }
    }
    public static void main(String[] args) {
        System.out.println(tripletSumToZero(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(tripletSumToZero(new int[]{-5, 2, -1, -2, 3}));
        System.out.println(tripletSumToZero(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(tripletSumToZero(new int[]{-2,0,0,2,2}));

    }

    public static List<Triplet> tripletSumToZero(int[] arr){
        Arrays.sort(arr);
        List<Triplet> triplets=new ArrayList<>();
        for (int i = 0; i < arr.length-2; i++) {
            // check i with i-1 for duplicate and ignore
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            search(arr,-arr[i],i+1,triplets);
        }
        return triplets;
    }

    public static void search(int[] arr, int target, int left, List<Triplet> triplets) {
        int right= arr.length-1;
        while(left<right){
            int currentSum=arr[left]+arr[right];
            if(currentSum==target){
                triplets.add(new Triplet(-target,arr[left],arr[right]));
                left++;
                right--;
                while(left<right && arr[left]==arr[left-1]) left++;
                while(left<right && arr[right]==arr[right+1]) right--;
            } else if(currentSum<target){
                left++;
            } else {
                right--;
            }
        }
    }
}
