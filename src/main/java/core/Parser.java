package core;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by syoung on 10/7/15.
 */
public class Parser {
    Food milk = new Milk();
    Food bread = new Bread();
    Food cookies = new Cookies();
    Food apples = new Apples();
    int eCount = 0;
    String eTimes;
    ArrayList<String[]> sList;

    /**
     * getFoods method calls checkFood for each food type and displays error count afterwards
     * @param _sList - arraylist with input string divided into separate parts for each item attribute
     */
    public void getFoods(ArrayList<String[]> _sList) {
        ArrayList<String[]> sList = _sList;

        checkFood(sList, "[mM][iI][lL][kK]", milk);
        checkFood(sList, "[bB][rR][eE][aA][dD]", bread);
        checkFood(sList, "[cC][oO0][oO0][kK][iI][eE][sS]", cookies);
        checkFood(sList, "[aA][pP][pP][lL][eE][sS]", apples);

        // decides whether to print "time" or "times" based on error count
        if (eCount == 1){
            eTimes = "time";
        } else eTimes = "times";

        System.out.printf("\nErrors                    seen: %d %-5s", eCount, eTimes);

    }

    /**
     * checkFood method to get the count of a particular food and its prices
     * @param _sList - arraylist of divided input string
     * @param aPattern - pattern to match to find a specific food
     * @param food - specific food object
     */
    public void checkFood(ArrayList<String[]> _sList, String aPattern, Food food){
        int mCount = 0;
        ArrayList<String[]> sList = _sList;
        BigDecimal tPrice;
        List<BigDecimal> mPrices = new ArrayList<BigDecimal>();

        for (int i = 0; i < sList.size(); i++){
            String[] saTemp = sList.get(i);
            for (int j = 0; j < saTemp.length; j += 4) {
                String siTemp = saTemp[j];

                // get the text after name:
                String nValue = siTemp.substring(5).trim();

                // check that name text exists and increment error counter if it doesn't
                if (nValue.length() < 1) {
                    eCount++;
                    sList.remove(i);
                }

                // check if name text matches the pattern of a food
                if (nValue.matches(aPattern)) {
                    mCount++;
                    String pTemp = saTemp[j+1].substring(6).trim();
                    if (pTemp.length() < 1) {
                        eCount++;
                        sList.remove(i);
                    } else {
                        tPrice = new BigDecimal(pTemp);

                        // add entry to prices for the listed price if food pattern matched
                        mPrices.add(tPrice);
                    }

                }
            }
        }

        // create hashset with unique prices for a particular food
        Set<BigDecimal> uPrices = new HashSet<BigDecimal>(mPrices);
        Iterator iterator = uPrices.iterator();

        // iterate through unique price hashset
        while (iterator.hasNext()){
            BigDecimal aPrice = (BigDecimal) iterator.next();

            // count frequency of each price
            int aCount = Collections.frequency(mPrices, aPrice);

            // create Price object for each unique price and include its frequency
            // then add that Price object to the food object
            Prices priceObj = new Prices(aPrice, aCount);
            food.addPrice(priceObj);

        }

        // set count of times the food appeared and display all of the information
        food.setCount(mPrices.size());
        food.displayPrices();

    }




}
