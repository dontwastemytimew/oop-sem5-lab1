package com.newyeargift.model.sweet;

/**
 * A candy is a sweet that is characterized by its flavor.
 */
public abstract class Candy extends Sweet {

    private final String flavor;

    protected Candy(String name, double weightInGrams,
                    double sugarContentPercent, String flavor) {
        super(name, weightInGrams, sugarContentPercent);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return super.toString() + ", flavor " + flavor;
    }
}