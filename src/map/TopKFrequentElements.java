package map;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Problem 347
 */
public class TopKFrequentElements {
    // use TreeMap
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();

        for (int num : nums) {
            frequentMap.computeIfPresent(num, (K, V) -> V +=1 );
            frequentMap.putIfAbsent(num, 1);
        }

        TreeMap<Integer, List<Integer>> frequentTreeMap = new TreeMap<>();
        for (int key : frequentMap.keySet()) {
            int frequency = frequentMap.get(key);
            if(!frequentTreeMap.containsKey(frequency)) {
                frequentTreeMap.put(frequency, new LinkedList<>());
            }
            frequentTreeMap.get(frequency).add(key);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = frequentTreeMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        return res;
    }

    // use maxHeap
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // key: frequency, value: number
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        maxHeap.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    // use array
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // index: count, value: number
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            for (int i = bucket.length - 1; i > 0 && k > 0; i --) {
                if (bucket[i] != null) {
                    List<Integer> list = bucket[i];
                    for (Integer index : list) {
                        res.add(index);
                        k--;
                        if (k == 0) break;
                    }
                }
            }
        }
        return res;
    }
}
