package core;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Bread extension of Food class with a constructor that sets the name variable
 * Created by syoung on 10/7/15.
 */
public class Bread extends Food{
    private int count;
    private int pCount;
    private String name;
    private String mPattern;
    private ArrayList<BigDecimal> prices;

    public Bread(){
        this.count = 0;
        this.pCount = 0;
        this.setName("Bread");
        this.setPattern("[bB][rR][eE][aA][dD]");
        this.prices = new ArrayList<BigDecimal>();
    }
}