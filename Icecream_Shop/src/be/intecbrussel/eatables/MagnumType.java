package be.intecbrussel.eatables;

public enum MagnumType {
    MILKCHOCOLATE(1.1),
    WHITECHOCOLATE(1.2),
    BLACKCHOCOLATE(1.3),
    ALPINENUTS(1.5),
    ROMANTICSTRAWBERRIES(1.05);

    private double multiplier;

    MagnumType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
