package com.liuq.linkedlist;

/**
 * Tips:
 *
 * @author Liuq
 * @version 2019年08月07日
 */
public class DoubleLinkedListDemo {


    public static void main(String [] args){

        // 测试
        System.out.println("DoubleLinkedListDemo Test");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "1", "11");
        HeroNode2 hero2 = new HeroNode2(2, "2", "22");
        HeroNode2 hero3 = new HeroNode2(3, "3", "33");
        HeroNode2 hero4 = new HeroNode2(4, "4", "44");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        doubleLinkedList.update(new HeroNode2(3,"33","333"));
        doubleLinkedList.list();
    }
}

// 创建一个双向链表的类
class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public  void add(HeroNode2 node){

       HeroNode2 temp= head;
        while (true){
            //null 时  指向了链表的最后
            if(temp.next==null){
                temp.next=node;
                node.pre=temp;
                node.next=null;
                break;
            }
            temp=temp.next;
        }

    }
    public  void dele(HeroNode2 node){

        HeroNode2 temp= head.next;

        if(temp==null){
            return;
        }

        while (true){

            if(temp==null){
                break;
            }

            if(temp.no==node.no){
                temp.pre.next=temp.next;

                //注意这里如果是最后一个节点  这里会报空指针
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            }
        }

    }

    public void update(HeroNode2 node){

        HeroNode2 temp= head.next;

        if(temp==null){
            return;
        }

        while (true){
            if(temp==null){
                break;
            }

            if(temp.no==node.no){
              //  node.next=temp.next;
             //   node.pre=temp.pre;
                temp.name = node.name;
                temp.nickname = node.nickname;
                break;
            }
            temp=temp.next;
        }

    }

    public  void list(){

        if(head.next==null){
            return;
        }

        HeroNode2 temp=head;
        while (temp!=null){

            if(temp.next==null){
                 break;
            }

            System.out.println(temp.next.toString());
            temp=temp.next;
        }

    }

}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}

