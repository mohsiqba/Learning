package com.mohsin.learning.BT;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 10-May-2021
 * Description :
 */
public class LogicalANDBT {

    public static void main(String[] args) {
        /* Create following Binary Tree
            1
        / \
        1     0
        / \ / \
        0 1 1 1
            */

        Node root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(0);
        root.left.left=new Node(0);
        root.left.right=new Node(1);
        root.right.left=new Node(1);
        root.right.right=new Node(1);
        System.out.print("Inorder traversal before conversion ");
        BTUtils.inOrder(root);

//        convertTree(root);
        logicalANDBT(root);
        System.out.println();
        System.out.print("Inorder traversal after conversion ");
        BTUtils.inOrder(root);
    }

    private static void convertTree(Node root) {
        if(root==null)
            return;

        convertTree(root.left);
        convertTree(root.right);
        if(root.left!=null && root.right!=null)
            root.data=root.left.data & root.right.data;
    }

    private static int logicalANDBT(Node root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;

        int l=logicalANDBT(root.left);
        int r=logicalANDBT(root.right);

        root.data=root.left.data & root.right.data;
        return root.data;
    }

}
