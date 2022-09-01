package com.example.demo_practise.algorithm.leetcode;

import java.util.Stack;

/**
 * ClassName: M_LC155_MinStack
 * Description:
 * date: 2022/8/9 18:45
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class M_LC155_MinStack {
    private Stack<innerClass> stack = null;
    class innerClass {
        public int val;
        public int minVal;
        innerClass(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    public M_LC155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.size() == 0) {
            stack.push(new innerClass(val, val));
        } else {
            stack.push(new innerClass(val, Math.min(val, stack.peek().minVal)));
        }
    }

    public void pop() {

    }

    public int top() {

    }

    public int getMin() {

    }
}
