package gdd.queue;

import java.util.Scanner;

/**
 * @author gsd
 * @date 2021/5/29 6:04 下午
 * @Email:mrguosir@qq.com 使用数组实现队列
 * 进阶版 采用环形数组的方式
 *
 * 其实核心思想就是更改rear 和 front 的下标
 * 在增加数据的时候 rear + 1
 * 在获取数据的时候 front + 1
 * 但是由于使用的是环形数组,当front 或 rear ==  maxSize 的时候 需要回到0 这个位置,所以会用到取余
 * 并且数组中 的一个空位是一直发生变化的,只要发生数据填充 rear就会+1 ,到顶的时候 继续从0开始
 * 获取队列中的有效数量公式为 :(rear+maxSize-front)%maxSize
 * 判断队列是否满了的公式为 :(rear+1)%maxSize  = front
 * 可以理解为rear 这个格子的上面一个格子就是 front时 视为队列满了
 *
 **/
public class CircleQueue {
    private int maxSize;

    /**
     * 队列的头部数据 从0开始
     */
    private int front;
    /**
     * 指向数组最后一个有效位置的后一位
     * 从0开始
     */
    private int rear;

    private int arr[];

    /**
     * 初始化数组队列的构造函数
     */
    public CircleQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    /**
     * 判断数组是否已经满了
     *
     * @return
     */
    public boolean isFull() {
        //可以想象成 rear上面一个格子是 front
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        //头和尾相等时说明数组为空
        return front == rear;
    }

    /**
     * 向数组中插入元素
     * 插入数据的时候更改 尾巴的下标
     */
    public void addItem(int value) throws Exception {
        if (isFull()) {
            throw new Exception("数组已满，无法插入数据");
        }
        //由于rear本身就指向 最后一个元素的后一位,所以直接将新的值赋值
        System.out.printf("即将放置的位置:%d\t\n",rear);
        arr[rear] = value;
        /**
         * 在这里不能直接+1
         * 因为环形队列 rear的值可能会 从4 变成 1 所以要取模
         */
        rear = (rear+1)%maxSize;
        System.out.printf("raer:%d",rear);


    }

    /**
     * 查看队列头部数据
     */
    public void showHead() {
        System.out.println("当前队列的头部元素为:" + arr[(front)%maxSize]);
    }

    /**
     * 显示队列信息
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列为空");
            return;
        }
        /**
         * 从第一个元素开始循环
         * 循环的次数 等于 有效元素
         * 因为 front 有可能 不是1 所以 要用 front + size()
         * 例如 maxSize = 5 front = 3 有效元素是4个
         * 应该循环的次数是 4
         * 从3 开始循环 循环 3+4(7) 也就是3 到 6 之间循环 累计4次
         */
        for (int i = front; i < front+size(); i++) {
            System.out.printf("数组arr[%d]的元素为:\t %d\n",i%maxSize,arr[i%maxSize]);
        }

    }

    /**
     * 获取队列中的有效元素
     * @return
     */
    public int size() {
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 获取队列中的元素
     * 获取的时候 更改头部下标
     */
    public void getItem() throws Exception {
        if (isEmpty()) {
            throw new Exception("当前数组元素为空，无法取得数据");
        }
        System.out.printf("当前获取的数据为:%d\n", arr[front]);
        front = (front+1)%maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) throws Exception {
        //初始化一个数组
        CircleQueue queueDemo = new CircleQueue(5);
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
            System.out.println("r(rear):显示队列尾部下标");
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
                case 'r':
                    System.out.println(queueDemo.rear);
                    break;
            }
        }
        System.out.println("程序结束~~~~~");
    }
}
