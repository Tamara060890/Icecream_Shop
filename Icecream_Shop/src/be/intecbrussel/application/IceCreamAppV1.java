package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

import static java.lang.Math.*;

public class IceCreamAppV1 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(1, 2, 2);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Eatable[] orders = new Eatable[]{
                iceCreamSalon.orderCone(new Flavor[]{Flavor.BANANA, Flavor.CHOCOLATE}),
                iceCreamSalon.orderMagnum(MagnumType.BLACKCHOCOLATE),
                iceCreamSalon.orderIceRocket()
        };

        for (Eatable e : orders){
            e.eat();
        }

        System.out.println("Ik betaal " + iceCreamSalon.getProfit() + " euro.");
    }
}
