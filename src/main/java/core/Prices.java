package core;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Price object that holds a price and how many times that price appears for a food
 * constructor sets the price and count and class has getters for those two fields
 * Created by syoung on 10/7/15.
 */
public class Prices {
    private BigDecimal price;
    private int pCount;

    public Prices(BigDecimal _price, int _pCount){
        this.price = _price;
        this.pCount = _pCount;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public int getpCount() {
        return pCount;
    }

}
