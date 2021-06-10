package gdd.queue.stack;

/**
 * @author gsd
 * @date 2021/6/7 3:57 下午
 * @Email:mrguosir@qq.com 使用数组模拟栈
 **/
public class ArrayStack {

    /**
     * 栈的最大值
     */
    private int maxSize;
    /**
     * 使用数组模拟 stack
     */
    private int[] arr;
    /**
     * 栈顶
     */
    private int top;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    /**
     * 显示栈内的数据
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空哦～～～");
            return;
        }
        //因为栈是先入后出，所以在输出的时候也要倒着来哦
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]的值是%d\n", i, arr[i]);
        }
    }

    /**
     * 放入数据
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已经满啦，放不下了");
        }
        top++;
        arr[top] = value;
    }

    /**
     * 取出数据
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经为空，无法取出数据");
        }
        int value = arr[top];
        top--;
        System.out.println("取出的数据:" + value);
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    /**
     * 判断栈是否满了
     */
    public boolean isFull() {
        return top == maxSize - 1 ? true : false;
    }


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;
    }

    public ArrayStack() {
    }

}



