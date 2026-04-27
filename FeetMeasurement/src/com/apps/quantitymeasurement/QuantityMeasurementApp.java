package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Generic comparison method
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Comparing: " + value1 + " " + unit1 +
                " and " + value2 + " " + unit2 +
                " => " + result);

        return result;
    }

    public static void main(String[] args) {

        System.out.println("=== UC4 Extended Unit Support ===");

        // Feet ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yard ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // Yard ↔ Feet
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET);

        // CM ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                0.393701, Length.LengthUnit.INCHES);

        // CM ↔ Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);

        System.out.println("UC4 execution completed...");
    }
}