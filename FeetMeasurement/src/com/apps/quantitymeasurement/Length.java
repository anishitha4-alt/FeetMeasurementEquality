package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    // Enum inside class (as per your design)
    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getFactor();
    }

    // Convert from base to target unit
    private double convertFromBase(double baseValue, LengthUnit targetUnit) {
        return baseValue / targetUnit.getFactor();
    }

    // ✅ UC6 ADD METHOD
    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double thisBase = this.convertToBaseUnit();
        double thatBase = thatLength.convertToBaseUnit();

        double sumBase = thisBase + thatBase;

        double result = convertFromBase(sumBase, this.unit);

        // rounding to 2 decimals
        result = Math.round(result * 100.0) / 100.0;

        return new Length(result, this.unit);
    }

    // equals method (important for tests)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double thisBase = this.convertToBaseUnit();
        double otherBase = other.convertToBaseUnit();

        return Math.round(thisBase * 100.0) ==
                Math.round(otherBase * 100.0);
    }

    // toString (for printing)
    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}