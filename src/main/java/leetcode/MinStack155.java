package leetcode;

import java.util.Stack;


/**
 * 这道最小栈跟原来的栈相比就是多了一个功能，可以返回该栈的最小值。
 * 使用两个栈来实现，一个栈来按顺序存储push进来的数据，另一个用来存出现过的最小值
 */
public class MinStack155 {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** initialize your data structure here. */
    public MinStack155() {}

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }


    /**
     * 需要注意的是上面的Java解法中的pop()中，为什么不能用注释掉那两行的写法，
     * 我之前也不太明白为啥不能对两个stack同时调用peek()函数来比较，如果是这种写法，
     * 那么不管s1和s2对栈顶元素是否相等，永远返回false。这是为什么呢，
     * 这我们就要到Java的对于peek的定义了，对于peek()函数的返回值并不是int类型，
     * 而是一个Object类型，这是一个基本的对象类型，如果我们直接用==来比较的话，
     * 那么肯定不会返回true，因为是两个不同的对象，所以我们一定要先将一个转为int型，
     * 然后再和另一个进行比较，这样才能得到我们想要的答案
     */
    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        int x = s1.pop();
        if (s2.peek() == x) s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

}

class Test{
    public static void main(String[] args){
        MinStack155 stack = new MinStack155();
        stack.push(-1);
        stack.push(0);
        stack.push(-3);

        stack.pop();
        int min = stack.getMin();
        System.out.println("min="+min);
    }
}
