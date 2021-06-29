package com.mohsin.learning.BT;

import java.util.LinkedList;
import java.util.List;

public class LeafnodeRemoval {

    public static void main(String[] args) {
        LeafnodeRemoval removal=new LeafnodeRemoval();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        System.out.println(removal.findLeaves(root));
    }
    public List<List<Integer>> findLeaves(Node root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(result, root);
        return result;
    }
    private int dfs(List<List<Integer>> result, Node node) {
        if (node == null) {
            return 0;
        }
        System.out.println("L");
        int left = dfs(result, node.left);
        System.out.println("R");
        int right = dfs(result, node.right);
        System.out.println("V");
        int curr = Math.max(left, right) + 1;
        System.out.println();
        System.out.print("left = " + left);
        System.out.print("right = " + right);
        System.out.println("curr = " + curr);
        System.out.println("1.result = "+result);

        if (result.size() < curr) {
            result.add(new LinkedList());
            System.out.println("2.result = "+result);
        }
        result.get(curr - 1).add(node.data);
        System.out.println("3.result = "+result);
        return curr;
    }
}