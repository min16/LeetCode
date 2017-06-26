package ArrayString;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {
    private HashMap<Integer, Integer> hashMap = new HashMap();

    public void add(int input) {
        int count = hashMap.containsKey(input) ? hashMap.get(input) : 0;
        hashMap.put(input, count + 1);
    }

    public boolean find(int val) {
        if (hashMap.size() < 2) return false;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int x = entry.getKey();
            int y = val - x;
            // check duplicate keys
            if (x == y) {
                if (entry.getValue() >= 2) return true;
            } else if (hashMap.containsKey(val - x)) return true;
        }
        return false;
    }
}
