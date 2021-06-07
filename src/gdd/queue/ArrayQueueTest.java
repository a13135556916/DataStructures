package gdd.queue;

import java.util.Scanner;

/**
 * @author gsd
 * @date 2021/5/31 10:06 上午
 * @Email:mrguosir@qq.com
 **/
public class ArrayQueueTest {
    //测试数组队列
    public static void main(String[] args) throws Exception {
        //初始化一个数组
        ArrayQueueBasic queueDemo = new ArrayQueueBasic(3);
        //接收用户的输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列的数据");
            System.out.println("请输入指令");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queueDemo.showQueue();
                    break;
                case 'e':
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queueDemo.addItem(value);
                    System.out.println("添加成功");
                    break;
                case 'g':
                    queueDemo.getItem();
                    break;
                case 'h':
                    queueDemo.showHead();
                    break;
            }
        }
        System.out.println("程序结束~~~~~");


    }

}
