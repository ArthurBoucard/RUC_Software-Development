package com.portfolio1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {

    private ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setStreams() {
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setErr(originalErr);
    }

    @Test
    void containerVesselTest() {
        // Basic Test
        containerVessel v1 = new containerVessel("SG", 30, 50, 20, 10);
        assertEquals("SG", v1.flag);
        assertEquals(30, v1.draft);
        assertEquals(50, v1.length);
        assertEquals(20, v1.width);
        assertEquals(10, v1.cargoList.get(0).maxSize);
        assertEquals(0, v1.cargoList.get(0).quantity);
        v1.loadingCargo(8);
        assertEquals(8, v1.cargoList.get(0).quantity);
        assertArrayEquals(new int[]{2}, v1.utilityLevelOfCapacity());

        // Overriding / Overloading Test
        containerVessel v2 = new containerVessel("SG", 30, 50, 20, 2, 10);
        assertEquals(0, v2.cargoList.get(1).quantity);
        v2.loadingCargo(1, 8);
        assertEquals(8, v2.cargoList.get(1).quantity);

        // Error Handling Test
        containerVessel v3 = new containerVessel("SG", 30, 50, 20, 2, 10);
        v3.loadingCargo(12);
        assertEquals("Cargo 0 doesn't have the space available for this quantity.", err.toString());
        setStreams();
        v3.loadingCargo(1, 8);
        v3.loadingCargo(1, 5);
        assertEquals("Cargo 1 doesn't have the space available for this quantity.", err.toString());
    }

    // need to finish changing test below to arraylist uses -> then remove all cargo object in boat class
    @Test
    void tankerTest() {
        tanker t1 = new tanker("FR", 30, 50, 20, 5, 100);
        assertEquals("FR", t1.flag);
        assertEquals(30, t1.draft);
        assertEquals(50, t1.length);
        assertEquals(20, t1.width);
        assertEquals(100, t1.maxCargoSize);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, t1.cargo);
        t1.loadingCargo(2, 50);
        t1.loadingCargo(3, 85);
        assertArrayEquals(new int[]{0, 0, 50, 85, 0}, t1.cargo);
        assertArrayEquals(new int[]{100, 100, 50, 15, 100}, t1.utilityLevelOfCapacity());
    }

    @Test
    void roroVesselTest() {
        roroVessel r1 = new roroVessel("DK", 30, 50, 20, 50);
        assertEquals("DK", r1.flag);
        assertEquals(30, r1.draft);
        assertEquals(50, r1.length);
        assertEquals(20, r1.width);
        assertEquals(50, r1.maxCargoSize);
        assertArrayEquals(new int[]{0}, r1.cargo);
        r1.loadingCargo(32);
        assertArrayEquals(new int[]{32}, r1.cargo);
        assertArrayEquals(new int[]{18}, r1.utilityLevelOfCapacity());

        // Overriding Test
        roroVessel r2 = new roroVessel("DK", 30, 50, 20, 2, 50);
        assertArrayEquals(new int[]{0, 0}, r2.cargo);
        r2.loadingCargo(1, 8);
        assertArrayEquals(new int[]{0, 8}, r2.cargo);
    }
}
