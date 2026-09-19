package com.newyeargift.model.sweet;

/**
 * A caramel candy that is either hard or soft.
 */
public class Caramel extends Candy {

    private final boolean hard;

    public Caramel(String name, double weightInGrams,
                   double sugarContentPercent, String flavor, boolean hard) {
        super(name, weightInGrams, sugarContentPercent, flavor);
        this.hard = hard;
    }

    public boolean isHard() {
        return hard;
    }

    @Override
    public String getCategory() {
        return "Caramel";
    }

    @Override
    public String toString() {
        return super.toString() + (hard ? ", hard" : ", soft");
    }
}