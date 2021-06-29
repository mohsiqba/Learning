package com.mohsin.learning.pointers2;

public class Triplet {
    int x, y, z;

    public Triplet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ')';
    }
}