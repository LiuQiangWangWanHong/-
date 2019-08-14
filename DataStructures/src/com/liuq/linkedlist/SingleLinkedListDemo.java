package com.liuq.linkedlist;

import java.util.Stack;

import static com.liuq.linkedlist.SingleLinkedList.*;

/**
 * Tips:
 *
 * @author Liuq
 * @version 2019年08月05日
 */
public class SingleLinkedListDemo {


    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "Song", "JISHIYU");
        HeroNode hero2 = new HeroNode(2, "LU", "YUQILING");
        HeroNode hero3 = new HeroNode(3, "WU", "ZHIDUOXING");
        HeroNode hero4 = new HeroNode(4, "LINBG", "BAOZITOU");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
      /*  singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);*/
        singleLinkedList.list();
    //    getLengthSelf(singleLinkedList.getHead());
        singleLinkedList.update(new HeroNode(7,"XXXXX","XXXXXXXX"));
        singleLinkedList.list();
        singleLinkedList.delete(2);
        singleLinkedList.list();

       /* findLastIndexNode(singleLinkedList.getHead(),2);
        reversetList(singleLinkedList.getHead());
        reversetPrint(singleLinkedList.getHead());*/
    }


}


class SingleLinkedList {
    private HeroNode head = new HeroNode(0, " ", " ");

    //查找单链表中的倒数第k个结点 【新浪面试题】
    public static HeroNode findLastIndexNode(HeroNode head ,int lastIndex){

        if(head==null){
            return null;
        }

        int length = getLengthSelf(head);

        if(length==0 || length-lastIndex<0){
         return  null;
        }
        HeroNode cur = head.getNext(); //3 // 3 - 1 = 2
        for(int i = 0; i < length-lastIndex; i++) {
            cur=cur.getNext();
        }

        System.out.println(cur.getId());
        return cur;
    }


    //将单链表反转
    public static void reversetList(HeroNode head) {

        if(head.getNext()==null || head.getNext().getNext()==null){
                    return;
        }

        //相当于一个临时的链表
        HeroNode  reversetHead=new HeroNode(0," ","");
        HeroNode  cur =head.getNext();
        //临时的节点  存储cur的状态
        HeroNode  next =null;

        while (cur!=null){
            next=cur.getNext();
            //相当于把 cur.next节点 改成了reversetHead（头结点的下一个节点）的下一个节点
            //是因为现在cur节点还是目标链表的元素
            cur.setNext(reversetHead.getNext());
            //上一行代码的赋值
            reversetHead.setNext(cur);
            cur = next;//让cur后移

        }
        //反转完成后 赋值给目标节点
      //  head=reversetHead;  为什么这样不行
        head.setNext(reversetHead.getNext());
    }

    //反转打印链表   利用栈的先进后出特点
    public static void reversetPrint(HeroNode head) {
        if(head.getNext()==null ){
            return;
        }

        Stack stack=new Stack<HeroNode>();
        HeroNode  cur=head.getNext();
        while (cur!=null){
            stack.push(cur);
            cur=cur.getNext();
        }

        while (stack.size()>0){
            System.out.println("stack pop :"+ stack.pop());
        }

    }



    public static int getLengthSelf(HeroNode head) {
        HeroNode temp = head;
        int count = 0;
        if (temp.getNext() == null) {
            return 0;
        }
        while (true) {

            if (temp == null) {
                break;
            }
            if (temp.getNext() != null) {
                count++;
            }
            temp = temp.getNext();
        }

        System.out.println("length: " + count);
        return count;

    }


    //返回头节点
    public HeroNode getHead() {
        return head;
    }


    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                flag = true;
                break;
            }

            if (temp.getNext().getId() < node.getId()) {
                flag = true;
                break;
            }
            if(temp.getNext().getId() == node.getId()){
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            //插入到链表中, temp的后面
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }


    public void add(HeroNode node) {

        HeroNode temp = head;

        while (true) {
            if (temp.getNext() == null) {
                break;
            }

            temp = temp.getNext();
        }

        temp.setNext(node);
    }

    public void delete(int id){
        HeroNode temp= head;
        boolean flag=false;
        if(temp.getNext()==null){
            System.out.println("linkedList  is  null ");
        }

        while (true){
            if(temp.getNext()==null){
                System.out.println("this node  not exist--delete");
                break;
            }

            if(temp.getNext().getId()==id){
                flag=true;
                break;
            }
            temp=temp.getNext();

        }

        if(flag){
            temp.setNext(temp.getNext().getNext());
        }




    }


    public void update(HeroNode  node){
           HeroNode temp= head;
           if(temp.getNext()==null){
               System.out.println("linkedList  is  null ");
           }

           while (true){
               if(temp==null){
                   System.out.println("this id  not exist");
                   break;
               }


               if(temp.getId()==node.getId()){
                   temp.setName(node.getName());
                   temp.setNikeName(node.getNikeName());
                   break;
               }
               temp=temp.getNext();
           }

    }

    public void list() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.getNext();

        while (true) {
            if (temp == null) {
                System.out.println("遍历结束");
                break;
            }

            System.out.println(temp.toString());
            temp = temp.getNext();


        }

    }

}


class HeroNode {

    private int id;
    private String name;
    private String nikeName;
    private HeroNode next;


    public HeroNode(int id, String name, String nikeName) {
        this.id = id;
        this.name = name;
        this.nikeName = nikeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}

