package gdd.queue.linked;

import java.util.Stack;

/**
 * @author gsd
 * @date 2021/6/3 3:04 下午
 * @Email:mrguosir@qq.com
 * 测试栈
 * 栈的特性 ： 先入后出
 *
 **/
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("sam smith");
        stack.add("taylor swift");
        stack.add("lorde");
        System.out.println("最终的结果会被逆序展示");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }



}
