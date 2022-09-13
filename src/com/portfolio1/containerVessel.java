package com.portfolio1;

public class containerVessel extends boat {

    public containerVessel(String flag, int draft, int length, int width, int maxCargoSize) {
        super(flag, draft, length, width, 1, maxCargoSize);
    }

    public containerVessel(String flag, int draft, int length, int width, int cargoNumber, int maxCargoSize) {
        super(flag, draft, length, width, cargoNumber, maxCargoSize);
    }
}
