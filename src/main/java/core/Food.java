package core;

import java.util.ArrayList;


/**
 * parent Food class that has the required functions the child classes use
 * Created by syoung on 10/7/15.
 */
public class Food {
    private int count;
    private int pCount;
    private ArrayList<Prices> prices = new ArrayList<Prices>();
    private String name;
    private String timeStr;
    private String divider1 = "=============";
    private String divider2 = "-------------";
    private String mPattern;

    public Food(){
    }

    /**
     * setters
     *
     */
    public void setCount(int _count){
        this.count = _count;
    }

    public void setpCount(int _pCount){
        this.pCount = _pCount;
    }

    public void addPrice(Prices _price) {
        prices.add(_price);
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setPattern(String _pattern){
        mPattern = _pattern;
    }

    public String getPattern(){
        return mPattern;
    }


    /**
     * displays the requisite information for a particular food in the desired format
     */
    public void displayPrices(){

        if (count == 1){
            timeStr = "time";
        } else timeStr = "times";
        System.out.printf("\nName:%8s             seen: %d %-5s\n", this.name, this.count, timeStr);
        System.out.printf("%S%26s\n", divider1, divider1);

        for (int i = 0; i < prices.size(); i++){
            if (prices.get(i).getpCount() == 1){
                timeStr = "time";
            } else timeStr = "times";
            System.out.printf("Price:%7s             seen: %d %-5s\n", prices.get(i).getPrice(), prices.get(i).getpCount(), timeStr);
            System.out.printf("%S%26s\n", divider2, divider2);
        }
    }


}
