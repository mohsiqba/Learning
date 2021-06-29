package com.mohsin.learning.BT;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 07-May-2021
 * Description :
 */
public class Node {
    Integer data;
    Node left,right;

    public Node(Integer data) {
        this.data = data;
        left=null;
        right=null;
    }
}
