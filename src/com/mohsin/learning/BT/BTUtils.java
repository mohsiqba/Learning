package com.mohsin.learning.BT;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 10-May-2021
 * Description :
 */
public class BTUtils {
    public static void preOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

}
