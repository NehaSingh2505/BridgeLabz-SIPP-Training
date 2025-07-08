package Stack; 

import java.util.Stack;

class SortingStackRecusively {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insert(stack, temp);
        }
    }

    private void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }
}
