package ArrayString;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3HM {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private void add(Integer number) {
        int count = hashMap.containsKey(number)? hashMap.get(number) : 0;
        hashMap.put(number, count + 1);
    }
    private boolean find(Integer value) {
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int x = entry.getKey();
            int y = value - x;
            if (x == y && entry.getValue() >= 2) return true;
            else if (hashMap.containsKey(y)) return true;
        }
        return false;
    }
    public static void main(String [] args) {
        TwoSum3HM ts3 = new TwoSum3HM();
        ts3.add(1);
        ts3.add(3);
        ts3.add(5);
        System.out.println(ts3.find(4));
        System.out.println(ts3.find(7));
    }
}
