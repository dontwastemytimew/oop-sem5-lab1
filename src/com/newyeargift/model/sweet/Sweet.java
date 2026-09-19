package com.newyeargift.model.sweet;

/**
 * Base type for any sweet that can be put into a gift.
 */
public abstract class Sweet {

    private static final double PERCENT_DIVISOR = 100.0;

    private final String name;
    private final double weightInGrams;
    private final double sugarContentPercent;

    protected Sweet(String name, double weightInGrams,
                    double sugarContentPercent) {
        this.name = name;
        this.weightInGrams = weightInGrams;
        this.sugarContentPercent = sugarContentPercent;
    }

    /**
     * Returns the category of the sweet, e.g. "Caramel".
     */
    public abstract String getCategory();

    public String getName() {
        return name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public double getSugarContentPercent() {
        return sugarContentPercent;
    }

    public double getSugarWeightInGrams() {
        return weightInGrams * sugarContentPercent / PERCENT_DIVISOR;
    }

    @Override
    public String toString() {
        return String.format("%s '%s' (%.1f g, sugar %.1f%%)",
                getCategory(), name, weightInGrams, sugarContentPercent);
    }
}