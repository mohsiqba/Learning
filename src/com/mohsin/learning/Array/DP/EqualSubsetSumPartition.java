package com.mohsin.learning.Array.DP;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class EqualSubsetSumPartition {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4}));
        System.out.println(canPartition(new int[]{1, 1, 3, 4, 7}));
        System.out.println(canPartition(new int[]{2, 3, 4, 6}));
        System.out.println(canPartition(new int[]{2, 3, 4, 6,2, 3, 4, 6,2, 3, 4, 6}));

        System.out.println(canPartitionDP(new int[]{1, 2, 3, 4}));
        System.out.println(canPartitionDP(new int[]{1, 1, 3, 4, 7}));
        System.out.println(canPartitionDP(new int[]{2, 3, 4, 6}));
        System.out.println(canPartitionDP(new int[]{2, 3, 4, 6,2, 3, 4, 6,2, 3, 4, 6}));
    }

    static boolean canPartitionDP(int[] num) {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        Boolean arr[][]=new Boolean[num.length][sum];
        return canPartitionRecursiveDP(num, 0, sum / 2,arr);
    }

    public static boolean canPartitionRecursiveDP(int[] num, int idx, int sum, Boolean[][] arr) {
        if(arr[idx][sum]!=null){
            return arr[idx][sum];
        }
        if (sum == 0)
            return true;
        if (idx >= num.length || sum < 0)
            return false;

        arr[idx][sum] = canPartitionRecursive(num, idx + 1, sum - num[idx]);
        arr[idx][sum] = canPartitionRecursive(num, idx + 1, sum);

        System.out.println(Arrays.deepToString(arr));
        return arr[idx][sum];

    }

    static boolean canPartition(int[] num) {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        return canPartitionRecursive(num, 0, sum / 2);
    }

    public static boolean canPartitionRecursive(int[] num, int idx, int sum) {
        if (sum == 0)
            return true;
        if (idx >= num.length || sum < 0)
            return false;

        boolean b = canPartitionRecursive(num, idx + 1, sum - num[idx]);
        boolean c = canPartitionRecursive(num, idx + 1, sum);

        return b || c;

    }
}
