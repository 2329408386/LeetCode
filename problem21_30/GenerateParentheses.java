package problem21_30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Generate all the formed parentheses with number n.
 * Created by happyboy on 2017/5/16.
 */

public class GenerateParentheses
{
    /**
     * Generate all well-formed parentheses with n parentheses pairs.
     * @param n: n parentheses pairs
     * @return
     */
    public List<String> generateParenthesis(int n)
    {
        // Store all the well-formed parentheses from 0 to n.
        List<List<String>> alls=new LinkedList<List<String>>();

        // Add first empty parentheses pairs.
        LinkedList<String> temp=new LinkedList<>();
        temp.add("");
        alls.add(temp);

        if (n<1)
            return alls.get(0);

        // Dynamic programming to add well-formed parentheses with @local parenthesePos pairs.
        for(int parenthesePos=1;parenthesePos<=n;parenthesePos++)
        {
            // Store all possible parentheses with @local parentheses pairs.
            List<String> curParentheses=new LinkedList<>();

            // Go through every possible combination.
            for(int innerParenthesePos=0;innerParenthesePos<parenthesePos;innerParenthesePos++)
                curParentheses.addAll(getParentheses(alls,innerParenthesePos,parenthesePos-innerParenthesePos-1));

            alls.add(curParentheses);
        }

        return alls.get(n);
    }


    /**
     * Get the parentheses with "(alls[inner])alls[outer]".
     * @param alls
     * @param inner
     * @param outer
     * @return
     */
    public List<String> getParentheses(List<List<String>> alls,int inner,int outer)
    {
        List<String> parentheses=new LinkedList<>();

        List<String> innerParentheses=alls.get(inner);
        List<String> outerParentheses=alls.get(outer);

        for(int innerPos=0;innerPos<innerParentheses.size();innerPos++)
            for(int outerPos=0;outerPos<outerParentheses.size();outerPos++)
                parentheses.add("("+innerParentheses.get(innerPos)+")"+outerParentheses.get(outerPos));
        return parentheses;
    }


    public static void main(String[] args)
    {
        GenerateParentheses parentheses=new GenerateParentheses();
        parentheses.generateParenthesis(3);
    }
}
