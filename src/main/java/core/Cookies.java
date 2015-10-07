package core;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Cookies extension of Food class with a constructor that sets the name variable
 * Created by syoung on 10/7/15.
 */
public class Cookies extends Food{
    private int count;
    private int pCount;
    private String name;
    private ArrayList<BigDecimal> prices;

    public Cookies(){
        this.count = 0;
        this.pCount = 0;
        this.setName("Cookies");
        this.prices = new ArrayList<BigDecimal>();
    }
}
