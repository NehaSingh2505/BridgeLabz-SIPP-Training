package Stack;

import java.util.*;

class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k)
                dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offer(i);
            if (i >= k - 1)
                result.add(nums[dq.peek()]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
