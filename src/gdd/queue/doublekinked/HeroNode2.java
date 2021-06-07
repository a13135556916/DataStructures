package gdd.queue.doublekinked;

import gdd.queue.linked.HeroNode;

/**
 * @author gsd
 * @date 2021/6/4 2:03 下午
 * @Email:mrguosir@qq.com
 * 双向链表
 **/
public class HeroNode2 {

    public int no;
    public String name;
    public String nickName;
    /**
     * 当前节点的下一个节点
     */
    public HeroNode2 next;
    /**
     * 当前链表的上一个节点
     */
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
