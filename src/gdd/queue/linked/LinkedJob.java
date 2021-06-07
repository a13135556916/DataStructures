package gdd.queue.linked;

/**
 * @author gsd
 * @date 2021/6/3 3:10 下午
 * @Email:mrguosir@qq.com 数组作业 ：将两个有序链表合并成一个有序链表
 **/
public class LinkedJob {

    public static void main(String[] args) {
        HeroNode headA = new HeroNode(0, "", "");
        HeroNode headA1 = new HeroNode(2, "A", "A");
        HeroNode headA2 = new HeroNode(4, "C", "C");
        HeroNode headA3 = new HeroNode(6, "E", "E");
        HeroNode headA4 = new HeroNode(8, "G", "G");

        HeroNode headB = new HeroNode(0, "", "");
        HeroNode headB1 = new HeroNode(1, "B", "B");
        HeroNode headB2 = new HeroNode(3, "D", "D");
        HeroNode headB3 = new HeroNode(5, "F", "F");
        HeroNode headB4 = new HeroNode(9, "H", "H");

//        headA.next = headA1;
//        headA1.next = headA2;
//        headA2.next = headA3;
//        headA3.next = headA4;
//
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
//
        addAndSort(headA,headA1);
        addAndSort(headA,headA3);
        addAndSort(headA,headA4);
        addAndSort(headA,headA2);

        printNodeList(headA);

        sortLinked(headA,headB);

        System.out.println("合并排序后");
        printNodeList(headA);

        HeroNode gsd = new HeroNode(8, "郭冬冬", "彭于晏");
        addAndSort(headA,gsd);
        System.out.println("重复增加后");
        printNodeList(headA);
//        printNodeList(headB);


    }

    public static void printNodeList(HeroNode node) {
        if (node.next == null) {
            System.out.println("数组为空");
            return;
        }
        HeroNode temp = node.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 将两个链表有序合并
     * @param headA
     * @param headB
     */
    public static void sortLinked(HeroNode headA, HeroNode headB) {
        HeroNode temp = headB.next;
        HeroNode next = null;
        while (temp!=null) {
            //这里是这段代码的精华 ，提前将下一个要处理的节点摘出来
            next = temp.next;
            //经过该行代码 temp.next 的值将会发生变化
            addAndSort(headA,temp);
            //如果这里写 temp = temp.next将会指向刚刚处理的节点（2），实际上应该是3 ，这个3 就是 上方所定义的next
            temp = next;
        }
    }

    /**
     * 加入元素并排序
     * @param head
     * @param item
     */
    public static void addAndSort(HeroNode head, HeroNode item) {
        HeroNode temp = head;
        while (temp.next!=null) {
            //判断当前节点的下一个节点是否大于 添加的节点， 如果大于 则在当前节点后添加新节点
            if (temp.next.no>=item.no) {
                break;
            }
            temp = temp.next;
        }
        //这里的temp对应的下一个节点的值大于item
        //item 的下一个 节点指向 当前节点的下一个节点
        item.next = temp.next;
        //将当前节点与item 关联起来
        temp.next = item;
    }


}
