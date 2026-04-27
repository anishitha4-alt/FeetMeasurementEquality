package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }
        return l1.add(l2);
    }

    // main method for testing
    public static void main(String[] args) {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(l1, l2);

        System.out.println("Result: " + result); // 2.00 FEET
    }
}