package com.newyeargift.model.sweet;

/**
 * A candy made of chocolate with a known cocoa share.
 */
public class ChocolateCandy extends Candy {

    private final double cocoaContentPercent;

    public ChocolateCandy(String name, double weightInGrams,
                          double sugarContentPercent, String flavor,
                          double cocoaContentPercent) {
        super(name, weightInGrams, sugarContentPercent, flavor);
        this.cocoaContentPercent = cocoaContentPercent;
    }

    public double getCocoaContentPercent() {
        return cocoaContentPercent;
    }

    @Override
    public String getCategory() {
        return "Chocolate candy";
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(", cocoa %.1f%%", cocoaContentPercent);
    }
}