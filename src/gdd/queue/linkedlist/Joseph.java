package gdd.queue.linkedlist;

/**
 * @author gsd
 * @date 2021/6/7 10:14 上午
 * @Email:mrguosir@qq.com 使用环形链表解决约瑟夫问题
 **/
public class Joseph {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);


    }
}

class CircleSingleLinkedList {

    Boy first = null;

    /**
     * 构建一个环形链表
     *
     * @param count
     */
    public void addBoy(int count) {
        if (count < 0) {
            System.out.println("输入的参数有误!请重新输入");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= count; i++) {
            //根据编号创建 boy 节点
            Boy boy = new Boy(i);
            if (i == 1) {
                //当 i == 0 的时候 需要特殊处理一下
                first = boy;
                //将当前节点指向头指针 ，目的是为了构建一个环
                boy.setNext(first);
                //将当前指针指向第一个节点
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                //移动curBoy的指针
                curBoy = boy;
            }
        }
    }

    /**
     * 输出环形链表中的内容
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("编号为%d的小男孩\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                //已经到最后一个节点了， 结束循环
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 循环链表解决约瑟夫问题
     *
     * @param startNo  从第几个男孩开始数  K
     * @param countNum 一次数几次
     * @param nums     一共有多少个男孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //校验数据
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误，请重新输入");
            return;
        }
        //创建辅助指针帮助小孩完成出圈
        Boy helper = first;
        //先给helper 赋值，使其指向链表的最后一个元素
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //根据startNo 移动helper 和 first 指针
        //因为自己本身占 1个 位置，所以最终移动的次数 是startNo -1
        //例如startNo 是 3 ，自己本身从1开始数，直到 3 这个位置，实际上是移动了2次
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //开始报数
        while (true) {
            //当第一个节点和最后一个节点都为同一节点时，终止循环
            if (helper==first) {
                break;
            }
            //遍历找到要出对的小孩
            for (int i = 0; i < countNum-1; i++) {
                first =first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("当前出队的小孩编号为%d\n",first.getNo());
            //开始出队操作
            //移动first 节点的指针
            first = first.getNext();
            //将helper 节点的下一个节点指向first 节点 ，相当于将 这个出队的小孩从链表中剔除
            helper.setNext(first);
        }
        System.out.printf("最后一个小孩的编号为%d\n",first.getNo());
    }


}


class Boy {
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }

    public Boy() {
    }
}
