package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller{
    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Flavor[] balls) throws NoMoreIceCreamException {
        return prepareCone(balls);
    }
    private Cone prepareCone(Flavor[] balls) {
        if (stock.getCones() <= 0) {
            throw new NoMoreIceCreamException("Geen cones op voorraad");
        }
        if (stock.getBalls() < balls.length) {
            throw new NoMoreIceCreamException("Niet genoeg ijsbollen op voorraad");
        }
        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - balls.length);

        // Bereken de prijs op basis van aantal bollen
        double price = priceList.getBallPrice() * balls.length;
        profit += price;// Verhoog de winst
        return new Cone(balls);// Maak en retourneer nieuwe Cone
    }

    @Override
    public Magnum orderMagnum(MagnumType type) throws NoMoreIceCreamException{
        return prepareMagnum(type);
    }
    private Magnum prepareMagnum(MagnumType type) {
        if(stock.getMagni() <= 0){
            throw new NoMoreIceCreamException("Geen magnums op voorraad");
        }
        stock.setMagni(stock.getMagni()-1);

        double price = priceList.getMagnumPrice(type);
        profit += price;
        return  new Magnum(type);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException{
        return prepareRocket();
    }
    private IceRocket prepareRocket(){
        if(stock.getIceRocket() <= 0){
            throw new NoMoreIceCreamException("Geen ijs rockets op voorraad");
        }
        stock.setIceRocket(stock.getIceRocket()-1);

        double price = priceList.getRocketPrice();
        profit += price;
        return new IceRocket();
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
