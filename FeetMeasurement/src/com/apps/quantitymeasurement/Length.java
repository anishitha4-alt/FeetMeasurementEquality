package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // ===== ENUM FOR UNITS =====
    public enum LengthUnit {
        FEET(12.0),     // 1 foot = 12 inches
        INCHES(1.0);    // base unit

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ===== CONSTRUCTOR =====
    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // ===== CONVERT TO BASE UNIT (INCHES) =====
    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // ===== COMPARE LOGIC =====
    private boolean compare(Length other) {
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    // ===== EQUALS METHOD =====
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;

        return compare(other);
    }
}