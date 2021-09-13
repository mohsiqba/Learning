package com.mohsin.learning;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : Mohsin Iqbal
 * Date : 27-May-2021
 * Description :
 */
public class StackConcept {

    /**
     * 1. PLE - prev less element (stack in increasing order)
     * 2. NLE - next less element (stack in increasing order)
     * 3. PGE - prev greater element (stack in decreasing order)
     * 4. NGE - next greater element (stack in decreasing order)
     */
    public static void main(String[] args) {
        StackConcept concept = new StackConcept();
        System.out.println(Arrays.toString(concept.NGE(new int[]{1, 2, 4, 2, 9, 5, 7, 8}))); //[2, 4, 9, 9, 0, 7, 8, 0]
        System.out.println(Arrays.toString(concept.PGE(new int[]{1, 2, 4, 2, 9, 5, 7, 8}))); //[0, 0, 0, 4, 0, 9, 9, 9]
        System.out.println(Arrays.toString(concept.NLE(new int[]{1, 2, 4, 2, 9, 5, 7, 8}))); //[0, 0, 2, 0, 5, 0, 0, 0]
        System.out.println(Arrays.toString(concept.PLE(new int[]{1, 2, 4, 2, 9, 5, 7, 8}))); //[0, 0, 2, 0, 5, 0, 0, 0]
    }


    public int[] NGE(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public int[] PGE(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : nums[stack.peek()];
            stack.push(i);
        }
        return res;
    }

    public int[] NLE(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public int[] PLE(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : nums[stack.peek()];
            stack.push(i);
        }
        return res;
    }
}
