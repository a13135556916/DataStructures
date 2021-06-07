package gdd.queue;

/**
 * @author gsd
 * @date 2021/5/29 6:04 下午
 * @Email:mrguosir@qq.com
 * 使用数组实现队列
 *
 * 此时的数组是一个基础的弱智队列，是一个一次性的队列
 *
 **/
public class ArrayQueueBasic {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    /**
     * 初始化数组队列的构造函数
     */
    public ArrayQueueBasic(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isFull() {
        return rear==maxSize-1;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty() {
        //头和尾相等时说明数组为空
        return front==rear;
    }

    /**
     * 向数组中插入元素
     */
    public void addItem(int value) throws Exception {
        if (isFull()) {
            throw new Exception("数组已满，无法插入数据");
        }
        rear++;
        arr[rear] = value;
    }

    /**
     * 查看队列头部数据
     */
    public void showHead() {
        System.out.println("当前队列的头部元素为:"+arr[front+1]);
    }

    /**
     * 显示队列信息
     */
    public void showQueue( ){
        if (isEmpty()) {
            System.out.println("当前队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]的元素为:%d\n",i,arr[i]);
        }
    }

    /**
     * 获取队列中的元素
     */
    public void getItem() throws Exception {
        if (isEmpty()) {
            throw new Exception("当前数组元素为空，无法取得数据");
        }
        front++;
        System.out.printf("当前获取的数据为:%d\n",arr[front]);
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

    public static void main(String[] args) {


    }
}
