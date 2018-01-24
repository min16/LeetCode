package array_string;

import java.util.Stack;

public class DailyTemperatures {

    // use stack
    public int[] dailyTemperaturesUsingStack(int[] temperatures) {
        int[] result = new int[temperatures.length -1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i ++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int id = stack.pop();
                result[id] = i - id;
            }
            stack.push(i);
        }

        return result;
    }

    // use array
    public int[] dailyTemperaturesUsingArray(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;

        for (int i = 0; i < temperatures.length; i ++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int id = stack[top --];
                result[id] = i - id;
            }
            stack[++ top] = i;
        }

        return result;
    }
}
