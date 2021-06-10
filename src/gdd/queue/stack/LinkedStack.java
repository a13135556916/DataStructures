package gdd.queue.stack;

/**
 * @author gsd
 * @date 2021/6/7 4:27 下午
 * @Email:mrguosir@qq.com 使用链表实现栈
 **/
public class LinkedStack {

    /**
     * 创建头节点
     */
    public StackNode stack = new StackNode(0);

    public static void main(String[] args) {

    }

    public LinkedStack() {
    }

    public void push(int value) {
        StackNode temp = stack;
        while (temp.getNext()!=null) {
            temp = temp.getNext();
        }
        StackNode node = new StackNode(value);
        temp.setNext(node);
    }

    /**
     * 注意这里的取数据是倒着取数据
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("栈为空，无法继续取出");
            return;
        }
        //先找到最后一个节点的前一个节点
        StackNode temp = stack;
        while (true) {
            if (temp.getNext()!=null) {
                if (temp.getNext().getNext()==null) {
                    break;
                }
            }
            temp = temp.getNext();
        }
        System.out.printf("取出来的值为%d\n",temp.getNext().getNumber());
        //滞空链表
        temp.setNext(null);
    }

    /**
     * 倒着输出链表的数据
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("链表为空!");
            return;
        }
        //创建一个新节点用于存放倒着的链表
        StackNode reversedHead = new StackNode(0);
        StackNode cur = stack.getNext();
        StackNode next = null;
        while (cur.getNext()!=null) {
            //获取当前节点的下一个节点
            next = cur.getNext();
            cur.setNext(reversedHead.getNext());
            reversedHead.setNext(cur);
            cur = next;
        }

        //遍历倒过来的节点
        StackNode temp = reversedHead;
        while (temp.getNext()!=null) {
            System.out.printf("本次节点的内容为%d\n",temp.getNumber());
            temp = temp.getNext();
        }
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        if (stack.getNext() == null) {
            return true;
        }else {
            return false;
        }
    }
}

class StackNode {
    private int number;
    private StackNode next;

    public StackNode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
