package gdd.queue.doublekinked;

import gdd.queue.linked.HeroNode;

/**
 * @author gsd
 * @date 2021/6/4 2:04 下午
 * @Email:mrguosir@qq.com 双向链表测试类
 **/

public class DoubleLinkedListTest {

    public HeroNode2 head = new HeroNode2(0, "", "");

    public static void main(String[] args) throws Exception {
        DoubleLinkedListTest test = new DoubleLinkedListTest();
        HeroNode2 node1 = new HeroNode2(1, "宋江", "呼保义");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "公孙胜", "入云龙");

        /*test.add(node1);
        test.add(node2);
        test.add(node3);
        test.add(node4);*/


        test.sortedAdd(node3);
        test.sortedAdd(node1);
        test.sortedAdd(node2);
        test.sortedAdd(node4);



        System.out.println("从链表的尾向头输出");
        test.printPreItem(node4);

        System.out.println("删除节点");
        test.delete(2);

        System.out.println("修改节点");
        HeroNode2 gsd = new HeroNode2(4, "郭冬冬", "入云龙");
        test.update(gsd);

        test.showList();




    }

    /**
     * 普通添加节点
     *
     * @param node
     */
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 根据no排序添加
     *
     * @param node
     */
    public void sortedAdd(HeroNode2 node) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        if (temp.next!=null) {
            temp.next.pre = node;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 删除节点
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode2 temp = head.next;
        //是否找到节点的标识
        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //执行删除操作
            temp.pre.next = temp.next;
            //如果不加这个判断 在删除最后一个节点的时候会发生空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到节点");
        }


    }

    /**
     * 更新节点
     *
     * @param node
     */
    public void update(HeroNode2 node) throws Exception {
        isEmpty(head);
        HeroNode2 temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                break;
            }
            temp = temp.next;
        }
        temp.name = node.name;
        temp.nickName = node.nickName;
    }

    /**
     * 显示与单项链表一致，只是可以从链表后向前进行遍历
     */
    public void showList() throws Exception {
        isEmpty(head);
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void isEmpty(HeroNode2 head) throws Exception {
        if (head.next == null) {
            throw new Exception("链表为空");
        }
    }

    /**
     * 为了测试链表倒着输出
     */
    public void printPreItem(HeroNode2 node) throws Exception {
        HeroNode2 temp = node;
        while (temp.pre!=null) {
            System.out.println(temp);
            temp = temp.pre;
        }
    }

}
