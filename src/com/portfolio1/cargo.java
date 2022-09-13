package com.portfolio1;

public class cargo {
    int maxSize;
    int quantity;

    public cargo(int maxSize) {
        this.maxSize = maxSize;
        this.quantity = 0;
    }

    public cargo(int maxSize, int quantity) {
        this.maxSize = maxSize;
        this.quantity = quantity;
    }
}
