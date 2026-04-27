package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison using raw values
    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return demonstrateLengthEquality(l1, l2);
    }

    // ✅ UC5 METHOD (overloaded)
    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {
        double result = Length.convert(value, from, to);
        return new Length(result, to);
    }

    // Overloaded version
    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit to) {
        return length.convertTo(to);
    }

    // Main (for testing)
    public static void main(String[] args) {

        System.out.println(Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)); // 12
        System.out.println(Length.convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET)); // 9
        System.out.println(Length.convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS)); // 1
        System.out.println(Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES)); // 0.39

        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        System.out.println(demonstrateLengthConversion(l, Length.LengthUnit.INCHES)); // 72 inches
    }
}