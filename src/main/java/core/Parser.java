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
    public static ArrayList<String[]> sList = new ArrayList<String[]>();
    public List<Integer> errIndex = new ArrayList<Integer>();
    ArrayList<String> errorLog = new ArrayList<String>();

    /**
     * getFoods method calls checkFood for each food type and displays error count afterwards
     * @param _sList - arraylist with input string divided into separate parts for each item attribute
     */
    public void getFoods(ArrayList<String[]> _sList) {

        sList = _sList;
        String divider1 = "=============";


        checkFood(milk);
        checkFood(bread);
        checkFood(cookies);
        checkFood(apples);

        // decides whether to print "time" or "times" based on error count
        if (eCount == 1){
            eTimes = "time";
        } else eTimes = "times";

        // display error count and list the items with errors
        System.out.printf("\nErrors                    seen: %d %-5s", eCount, eTimes);
        System.out.printf("\n%S%26s\n", divider1, divider1);
        for (int n = 0; n < errorLog.size(); n++){
            System.out.println(errorLog.get(n));
        }

    }

    /**
     * checkFood method to get the count of a particular food and its prices
     * @param food - specific food object that provides the name of the food and match pattern
     */
    public void checkFood(Food food){
        int mCount = 0;
        //String[] remove = new String[0];

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
                    errIndex.add(i);
                }

                // check if name text matches the pattern of a food
                if (nValue.matches(food.getPattern())) {
                    mCount++;
                    String pTemp = saTemp[j+1].substring(6).trim();

                    // add item index to errIndex if error is found, else add item price to mPrices array
                    if (pTemp.length() < 1) {
                        eCount++;
                        errIndex.add(i);
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
        for (int x = errIndex.size() - 1; x >= 0; x--){

            int rmIdx = errIndex.get(x);

            // build string for found errors and add that string to the errorLog
            StringBuilder builder = new StringBuilder();
            for(String s : sList.get(rmIdx)) {
                builder.append(s);
            }
            String tempError = builder.toString();
            errorLog.add(tempError);

            // remove items with errors from the main list so that they are not counted multiple times
            sList.remove(rmIdx);
        }

        // remove items from errIndex
        for (int m = errIndex.size() - 1; m >= 0 ; m--){
            errIndex.remove(m);
        }

    }

}
