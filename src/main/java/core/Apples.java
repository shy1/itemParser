package core;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Apple extension of Food class with a constructor that sets the name variable
 * Created by syoung on 10/7/15.
 */
public class Apples extends Food{
    private int count;
    private int pCount;
    private String name;
    private ArrayList<BigDecimal> prices;
    private String mPattern;

    public Apples(){
        this.count = 0;
        this.pCount = 0;
        this.prices = new ArrayList<BigDecimal>();
        this.setName("Apples");
        this.setPattern("[aA][pP][pP][lL][eE][sS]");
    }
}