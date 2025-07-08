package HashMap;

import java.util.*;

class PairWithSum {
    public boolean hasPair(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num))
                return true;
            seen.add(num);
        }
        return false;
    }
}
