package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    // Enum with ALL units (base unit = inches)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert everything to base unit (inches)
    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // Comparison logic
    public boolean compare(Length other) {
        if (other == null) return false;

        double thisVal = this.toBaseUnit();
        double otherVal = other.toBaseUnit();

        return Math.abs(thisVal - otherVal) < 0.0001; // precision handling
    }

    // equals() override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return compare(other);
    }
}