package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public interface IceCreamSeller extends Profitable{
    public Cone orderCone(Flavor[] balls);
    public IceRocket orderIceRocket();
    public Magnum orderMagnum(MagnumType type);

    @Override
    double getProfit();
}
