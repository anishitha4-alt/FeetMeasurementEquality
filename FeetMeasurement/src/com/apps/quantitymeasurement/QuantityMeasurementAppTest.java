package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0,
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0,
                Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET),
                1e-6);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0,
                Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_CmToInches() {
        assertEquals(1.0,
                Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES),
                1e-3);
    }

    @Test
    public void testConversion_Zero() {
        assertEquals(0.0,
                Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testConversion_Negative() {
        assertEquals(-12.0,
                Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.INCHES));
    }
}