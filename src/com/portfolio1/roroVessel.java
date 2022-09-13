package com.portfolio1;

public class roroVessel extends boat {

    public roroVessel(String flag, int draft, int length, int width, int maxCargoSize) {
        super(flag, draft, length, width, 1, maxCargoSize);
    }

    public roroVessel(String flag, int draft, int length, int width, int cargoNumber, int maxCargoSize) {
        super(flag, draft, length, width, cargoNumber, maxCargoSize);
    }
}
