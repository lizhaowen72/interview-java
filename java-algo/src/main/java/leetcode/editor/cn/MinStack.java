package leetcode.editor.cn;

import java.util.Stack;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计
public class MinStack {
    public static void main(String[] args) {
//        MinStack2 solution = new MinStack2().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack2 {
        Stack<Integer> dataStack;
        Stack<Integer> minValStack;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            dataStack = new Stack<>();
            minValStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minValStack.isEmpty()) {
                minValStack.push(x);
            } else {
                int tem = minValStack.peek();
                if (tem < x) {
                    x = tem;
                }
                minValStack.push(x);
            }
        }

        public void pop() {
            dataStack.pop();
            minValStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minValStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
}