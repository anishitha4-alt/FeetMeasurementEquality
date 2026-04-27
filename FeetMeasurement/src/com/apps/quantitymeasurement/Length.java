package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum with conversion factors (BASE UNIT = INCHES)
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
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double toBaseUnit() {
        return value * unit.getFactor();
    }

    // ✅ UC5: STATIC CONVERSION METHOD
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // convert to base (inches)
        double baseValue = value * source.getFactor();

        // convert to target
        double result = baseValue / target.getFactor();

        return result;
    }

    // ✅ Instance conversion (returns NEW object → immutability)
    public Length convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    // equals() using base unit comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double thisBase = this.toBaseUnit();
        double otherBase = other.toBaseUnit();

        return Math.abs(thisBase - otherBase) < 1e-6;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}