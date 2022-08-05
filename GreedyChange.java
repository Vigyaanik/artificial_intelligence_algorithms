import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class GreedyChange{

/**
* Apply the greedy algorithm to calculate coin change.
* @param amount a non-negative integer which is required to be made up.
* @param denominations the available coin types (unique positive integers)
* @return a map of each denomination to the number of times it is used in the solution.
* **/

    public static Map<Integer,Integer> greedyChange(int amount, int[] denominations){
        //fill in code here
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.sort(denominations);

        for (int i = denominations.length-1; i >= 0; i--) {
            int value = (int) (amount/denominations[i]);
            amount = amount % denominations[i];
            m.put(denominations[i], value);
        }
        return m;
    }


    public static void main(String[] args) {
        int[] denominations = {1,2,3};
    Map<Integer,Integer> change = greedyChange(5, denominations);

    Integer[] keys = change.keySet().toArray(new Integer[0]);
    Arrays.sort(keys);
    for(Integer i: keys)
    System.out.println(i+":"+change.get(i));
    }
}

