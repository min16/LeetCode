package ArrayString;

import java.util.*;

public class TwoSum3List {
    private List<Integer> list = new ArrayList<>();
    private void add(Integer number) {
        list.add(number);
    }
    private boolean find(Integer value) {
        Collections.sort(list);
        if(list.size() < 2) return false;

        int left = 0, sum;
        int right = list.size() - 1;
        while (left < right) {
            sum = list.get(left) + list.get(right);
            if (sum == value) return true;
            else if (sum < value) left++;
            else right--;
        }
        return false;
    }
    public static void main (String [] args) {
        TwoSum3List ts3 = new TwoSum3List();
        ts3.add(1);
        ts3.add(5);
        ts3.add(5);
        System.out.println(ts3.find(5));
    }
}
