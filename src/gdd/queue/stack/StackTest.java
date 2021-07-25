package gdd.queue.stack;

import java.util.Scanner;

/**
 * @author gsd
 * @date 2021/6/7 4:12 下午
 * @Email:mrguosir@qq.com
 **/
public class StackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
//        LinkedStack stack = new LinkedStack();
        Scanner scanner = new Scanner(System.in);
        boolean lope = true;
        while (lope) {
            System.out.println("show 显示栈");
            System.out.println("push 添加数据");
            System.out.println("pop 取出数据");
            System.out.println("exit 退出程序");
            System.out.println("请输入指令");
            String key = scanner.next();
            System.out.println(1);
            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    try {
                        stack.push(value);
                    }catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        stack.pop();
                    }catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":lope = false;
                    scanner
                    .close();
                    break;
            }
        }
        System.out.println("程序结束～～～～");


    }
}
