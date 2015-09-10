Question: https://leetcode.com/problems/min-stack/
```
Use two stacks:
public class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Solution() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.empty()){
            minStack.push(number);
        }
        else if (number <= minStack.peek()){
            minStack.push(number);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
////////////////////////////////////////////
Use one stack:
class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
