package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{
    private final PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Flavor[] balls) {
        // De prijs berekenen op basis van aantal bollen
        double price = priceList.getBallPrice() * balls.length;
        totalProfit += price;// De winst verhogen
        return new Cone(balls);// Een nieuwe Cone maken en retourneren
    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
        double price = priceList.getMagnumPrice(type);
        totalProfit += price;
        return new Magnum(type);
    }

    @Override
    public IceRocket orderIceRocket() {
        double price = priceList.getRocketPrice();
        totalProfit += price;
        return new IceRocket();
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon met totale winst: " + totalProfit;
    }
}
