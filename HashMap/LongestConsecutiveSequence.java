package HashMap;

import java.util.*;

class LongestConsecutive {
    public int longestSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
