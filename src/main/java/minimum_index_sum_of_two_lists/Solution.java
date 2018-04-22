package minimum_index_sum_of_two_lists;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/

class Solution {

    static class Restaurant {
        public Restaurant(String name, int idxSum) {
            this.name = name;
            this.idxSum = idxSum;
        }
        String name;
        int idxSum;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> r2index = new HashMap<>();
        for (int i=0; i<list1.length; i++) {
            r2index.put(list1[i], i);
        }

        PriorityQueue<Restaurant> queue = new PriorityQueue<>(1, Comparator.comparingInt(o -> o.idxSum));
        for (int i=0; i<list2.length; i++) {
            Integer idx = r2index.get(list2[i]);
            if (idx != null) {
                queue.add(new Restaurant(list2[i], idx + i));
            }
        }
        List<String> result = new ArrayList<>();
        int sum = 0;
        while(!queue.isEmpty()) {
            Restaurant r = queue.poll();
            if (!result.isEmpty() && r.idxSum != sum) break;
            result.add(r.name);
            sum = r.idxSum;
        }
        String[] arr = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
