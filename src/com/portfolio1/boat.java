package com.portfolio1;

public class boat {
    public String flag;
    public int draft;
    public int length;
    public int width;
    public int[] cargo;
    public int maxCargoSize;

    public boat(String flag, int draft, int length, int width, int cargoNumber, int maxCargoSize) {
        this.flag = flag;
        this.draft = draft;
        this.length = length;
        this.width = width;
        cargo = new int[cargoNumber];
        this.maxCargoSize = maxCargoSize;
    }

    public void loadingCargo(int quantity) {
        if (quantity > this.maxCargoSize - this.cargo[0])
            System.err.print("Cargo 0 doesn't have the space available for this quantity.");
        else
            this.cargo[0] += quantity;
    }

    public void loadingCargo(int cargoNumber, int quantity) {
        if (quantity > this.maxCargoSize - this.cargo[cargoNumber])
            System.err.print("Cargo " + cargoNumber + " doesn't have the space available for this quantity.");
        else
            cargo[cargoNumber] += quantity;
    }

    public int[] utilityLevelOfCapacity() {
        int[] result = new int[this.cargo.length];

        for (int i = 0; i < this.cargo.length; i++)
            result[i] = this.maxCargoSize - this.cargo[i];

        return result;
    }
}
