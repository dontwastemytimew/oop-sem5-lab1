package com.newyeargift.model.sweet;

/**
 * A baked sweet that may contain a filling.
 */
public class Cookie extends Sweet {

    private final boolean filled;

    public Cookie(String name, double weightInGrams,
                  double sugarContentPercent, boolean filled) {
        super(name, weightInGrams, sugarContentPercent);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String getCategory() {
        return "Cookie";
    }

    @Override
    public String toString() {
        return super.toString() + (filled ? ", filled" : ", plain");
    }
}