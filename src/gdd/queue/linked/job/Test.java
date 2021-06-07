package gdd.queue.linked.job;


import gdd.queue.linked.HeroNode;
import gdd.queue.linked.SingleLinkedList;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author gsd
 * @date 2021/6/4 8:34 上午
 * @Email:mrguosir@qq.com
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        HeroNode node1 = new HeroNode(1, "宋江", "呼保义");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAndSort(node2);
        linkedList.addAndSort(node3);
        linkedList.addAndSort(node1);
        linkedList.addAndSort(node4);

        linkedList.showNode();
        System.out.println("第一题，求单链表有效节点的个数");
        Test test = new Test();
        System.out.println("单链表中有效节点的个数为：" + test.getSize(linkedList.getHead()));

        System.out.println("第二题，取链表中倒数第2个节点");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入下标");
//        int i = scanner.nextInt();
        System.out.println(test.getLastIndexNode(linkedList.getHead(), 2));

//        System.out.println("第三题，反转链表");
//        test.reversedLinked(linkedList.getHead());
//        System.out.println("反转之后");
//        linkedList.showNode(linkedList.getHead());
        System.out.println("反转打印链表，不要更改数据结构");
        System.out.println("以下是使用stack的方式");
        test.reversedLinkedPrint(linkedList.getHead());


    }

    /**
     * 获取链表的size
     *
     * @param head
     */
    public Integer getSize(HeroNode head) {
        if (isEmpty(head)) {
            return null;
        }
        HeroNode temp = head.next;
        Integer count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 判断链表是否为空
     *
     * @param head
     * @return
     */
    public boolean isEmpty(HeroNode head) {
        if (head == null || head.next == null) {
            System.out.println("链表为空");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取链表中倒数 第index个节点
     *
     * @param head
     * @param index
     * @return
     */
    public HeroNode getLastIndexNode(HeroNode head, Integer index) throws Exception {
        if (isEmpty(head)) {
            return null;
        }
        //获取有效节点的个数
        Integer size = getSize(head);
        if (size == 1 || index > size) {
            throw new Exception("链表的数据不正确");
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转链表
     *
     * @param head
     */
    public void reversedLinked(HeroNode head) {
        if (isEmpty(head)) {
            return;
        }
        //用于存放反转后链表的头
        HeroNode reversedHead = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        HeroNode next = null;
        while (temp != null) {
            //为什么要用这个
            next = temp.next;
            //因为在这一步的时候 temp.next = null 了
            temp.next = reversedHead.next;
            reversedHead.next = temp;
            temp = next;
        }
        head.next = reversedHead.next;
    }

    /**
     * 反转打印链表
     *
     * @param head
     */
    public void reversedLinkedPrint(HeroNode head) {
        if (isEmpty(head)) {
            return;
        }
        Stack<HeroNode> stackNode = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stackNode.add(cur);
            cur = cur.next;
        }

        while (!stackNode.isEmpty()) {
            System.out.println(stackNode.pop());
        }
    }

    public void mergeLinked(HeroNode a,HeroNode b) {

    }

}
