package problem12;

import java.util.HashMap;
import java.util.Map;

/**
 * convert integer to Roman.
 * Created by happyboy on 2017/5/10.
 */

/*Solved*/
public class IntegerToRoman
{
    private String[] unitDigits={"I","II","III","IV","V","VI","VII","VIII","IX"};   // Unit Digit
    private String[] tensDigits={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};   // Tens Digit
    private String[] hundredsDigits={"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};   // Hundreds Digit
    private String[] thousandsDigit={"M","MM","MMM"};   // Thousand Digit
    private Map<Integer,String> relations=new HashMap<>();  //Store every digit's relation between integer and Roman
    // number

    public IntegerToRoman()
    {
        init();
    }

    /**
     * Convert an integer between 1~3999 to a Roman String.
     * @param num
     * @return
     */
    public String intToRoman(int num)
    {
        int unit=0,tens=0,hundreds=0,thousands=0;

        unit=num%10;
        tens=num/10%10*10;
        hundreds=num/100%10*100;
        thousands=num/1000*1000;


        return relations.get(thousands)+relations.get(hundreds)+relations.get(tens)+relations.get(unit);
    }

    /**
     * Initialize relations with Integers and its Roman Number.
     */
    private void init()
    {
        relations.put(0,"");

        for(int unitNum=1;unitNum<=9;unitNum++)
            relations.put(unitNum,unitDigits[unitNum-1]);
        for(int tensNum=1;tensNum<=9;tensNum++)
            relations.put(tensNum*10,tensDigits[tensNum-1]);
        for(int hundredsNum=1;hundredsNum<=9;hundredsNum++)
            relations.put(hundredsNum*100,hundredsDigits[hundredsNum-1]);
        for(int thousandsNum=1;thousandsNum<=3;thousandsNum++)
            relations.put(thousandsNum*1000,thousandsDigit[thousandsNum-1]);
    }


}
