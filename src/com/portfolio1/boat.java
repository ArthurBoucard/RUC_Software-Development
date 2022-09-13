package com.portfolio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class boat {
    public String flag;
    public int draft;
    public int length;
    public int width;
    public int[] cargo;
    public int maxCargoSize;
    public List<cargo> cargoList;

    public boat(String flag, int draft, int length, int width, int cargoNumber, int maxCargoSize) {
        this.flag = flag;
        this.draft = draft;
        this.length = length;
        this.width = width;
        cargo = new int[cargoNumber];
        this.maxCargoSize = maxCargoSize;
        cargoList = new ArrayList<cargo>();
        for (int i = 0; i < cargoNumber; i++)
            cargoList.add(new cargo(maxCargoSize));
    }

    public void loadingCargo(int quantity) {
        if (quantity > this.cargoList.get(0).maxSize - this.cargoList.get(0).quantity)
            System.err.print("Cargo 0 doesn't have the space available for this quantity.");
        else
            this.cargoList.get(0).quantity += quantity;
    }

    public void loadingCargo(int cargoNumber, int quantity) {
        if (quantity > this.cargoList.get(cargoNumber).maxSize - this.cargoList.get(cargoNumber).quantity)
            System.err.print("Cargo " + cargoNumber + " doesn't have the space available for this quantity.");
        else
            this.cargoList.get(cargoNumber).quantity += quantity;
    }

    public int[] utilityLevelOfCapacity() {
        int[] result = new int[this.cargoList.size()];

        for (int i = 0; i < this.cargoList.size(); i++)
            result[i] = this.cargoList.get(i).maxSize - this.cargoList.get(i).quantity;

        return result;
    }
}
