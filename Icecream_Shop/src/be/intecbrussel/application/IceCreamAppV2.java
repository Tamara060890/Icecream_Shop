package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;
public class IceCreamAppV2 {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(1, 2, 3);
        Stock stock = new Stock(3,5,6,4);
        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);
        try{
            Eatable[] orders = new Eatable[]{
                    iceCreamCar.orderCone(new Flavor[]{Flavor.BANANA, Flavor.CHOCOLATE}),
                    iceCreamCar.orderMagnum(MagnumType.BLACKCHOCOLATE),
                    iceCreamCar.orderIceRocket()
            };

            for (Eatable e : orders) {
                e.eat();
            }
            System.out.println("Ik betaal: " + iceCreamCar.getProfit() + " euro.");
        }catch (NoMoreIceCreamException e){
            System.out.println("Sorry, er is geen voorraad meer: " + e.getMessage());
        }
        try{
            Eatable[] orders2 = new Eatable[]{
                    iceCreamCar.orderIceRocket(),
                    iceCreamCar.orderIceRocket(),
                    iceCreamCar.orderIceRocket()

            };

            for (Eatable e : orders2) {
                e.eat();
            }
            System.out.println("Ik betaal " + iceCreamCar.getProfit() + " euro.");
        }catch (NoMoreIceCreamException e){
            System.out.println("Fout bij bestellen: " + e.getMessage());
        }
    }
}
