package gdd.queue.linked;

import java.util.Stack;

/**
 * @author gsd
 * @date 2021/6/4 8:38 上午
 * @Email:mrguosir@qq.com
 **/
public class SingleLinkedList {
    //初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加结点
     * 最普通的加入元素 没有考虑 排序问题
     */
    public void addItem(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 向链表中根据NO插入顺序，如果NO 已存在 提示相应的信息
     *
     * @param node
     */
    public void addAndSort(HeroNode node) {
        //获取头节点的下一个节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //到最后一个节点仍然没有找到
            if (temp.next == null) {
                break;
            }
            //找到节点了
            if (temp.next.no > node.no) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            System.out.printf("链表中已经含有编号为 %d 的节点，添加失败\n", node.no);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 根据节点编号修改节点
     *
     * @param node
     */
    public void updateItem(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空！！");
            return;
        }
        HeroNode temp = head;
        //是否找到节点的标识
        boolean flag = false;
        //先查找node 对应的节点
        while (temp.next != null) {
            //找到节点李
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (!flag) {
            System.out.printf("未在链表中找到编号为 %d 的节点，修改失败", node.no);
        } else {
            temp.name = node.name;
            temp.nickName = node.nickName;
        }
    }


    /**
     * 根据节点中的 no 删除节点
     *
     * @param node
     */
    public void deleteNode(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        boolean flag = false;
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.printf("在链表中没有找到no为 %d 的节点，删除失败\n", node.no);
        } else {
            //执行删除操作
            temp.next = temp.next.next;
        }
    }

    /**
     * 根据no查找节点
     *
     * @param no 编号
     */
    public void findNode(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == false) {
            System.out.printf("尚未找到节点%d\n", no);
        } else {
            System.out.println(temp.next);
        }

    }


    /**
     * 显示节点内容
     */
    public void showNode() {
        if (head.next == null) {
            System.out.println("链表为空~~~~");
            return;
        }
        //创建一个临时节点 = 头节点的下一个节点
        HeroNode temp = head.next;
        while (true) {
            if (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            } else {
                break;
            }
        }
    }

    public void showNode(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空~~~~");
            return;
        }
        //创建一个临时节点 = 头节点的下一个节点
        HeroNode temp = head.next;
        while (true) {
            if (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            } else {
                break;
            }
        }
    }

    /**
     * 获取节点的有效节点数量
     *
     * @return
     */
    public int getSize(HeroNode headNode) {
        if (headNode.next == null) {
            return 0;
        }
        HeroNode temp = headNode.next;
        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 通过下标获取 倒数 下标的节点
     *
     * @param index
     */
    public void getLastIndexNode(HeroNode headNode, int index) {
        if (headNode.next == null) {
            System.out.println("链表为空，无法根据下标获取数据");
            return;
        }
        int size = getSize(headNode);

        if (index <= 0 || index > size) {
            System.out.println("下标参数不正确，请检查");
            return;
        }
        HeroNode temp = headNode.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        System.out.println("倒数第" + index + "的节点正在输出～～～～～");
        System.out.println(temp);
    }

    /**
     * 反转输出数组
     *
     * @param head
     */
    public void reviseLinked(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空，无法反转");
            return;
        }
        //创建一个新数组  用于存放数据
        HeroNode reversedHed = new HeroNode(0, "", "");
        //当前遍历的节点
        HeroNode cur = head.next;
        //当前节点的下一个节点
        HeroNode next = null;
        while (cur != null) {
            //先获取当前操作节点的下一个节点
            next = cur.next;
            //将当前节点的下一个节点指向 reversedHead的下一个节点（第一次的时候将会指向空）
            cur.next = reversedHed.next;
            //将reversed的next 节点指向 当前节点 建立联系
            reversedHed.next = cur;
            //遍历下一个
            cur = next;
        }
        head.next = reversedHed.next;
    }

    /**
     * 逆序输出链表
     *
     * @param head
     */
    public void reversedPrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表不能为空!");
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
