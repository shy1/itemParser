package core;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Milk extension of Food class with a constructor that sets the name variable
 * Created by syoung on 10/7/15.
 */
public class Milk extends Food{
    private int count;
    private int pCount;
    private String name;
    private ArrayList<BigDecimal> prices;

    public Milk(){
        this.count = 0;
        this.pCount = 0;
        this.setName("Milk");
        this.prices = new ArrayList<BigDecimal>();
    }
}
