package gdd.queue.linked;

import java.util.Stack;

/**
 * @author gsd
 * @date 2021/6/2 10:59 上午
 * @Email:mrguosir@qq.com
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "呼保义");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "公孙胜", "入云龙");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAndSort(node2);
        linkedList.addAndSort(node3);
        linkedList.addAndSort(node1);
        linkedList.addAndSort(node4);

//        System.out.println("显示修改前的节点---");
//        linkedList.showNode();
//        System.out.println("执行修改操作-----");
//        HeroNode gsd = new HeroNode(1, "郭冬冬", "龙傲天");
//        linkedList.updateItem(gsd);
//        System.out.println("修改后");
//        linkedList.showNode();
//        HeroNode lll = new HeroNode(1, "郭冬冬", "龙傲天");

        /*System.out.println("执行删除操作...");
        linkedList.deleteNode(lll);
        System.out.println("删除后");*/

        /*System.out.println("开始查找节点2");
        linkedList.findNode(2);
        System.out.println("正在查询节点的数量");
        System.out.println(linkedList.getSize(linkedList.getHead()));
        linkedList.getLastIndexNode(linkedList.getHead(), 3);

        System.out.println("开始反转链表");
        linkedList.reviseLinked(linkedList.getHead());
        linkedList.showNode(linkedList.getHead());*/

        //反转输出
        linkedList.reversedPrint(linkedList.getHead());


    }


}

