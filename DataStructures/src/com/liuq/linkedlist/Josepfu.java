package com.liuq.linkedlist;

/**
 * Tips:
 *
 * @author Liuq
 * @version 2019年08月08日
 */
public class Josepfu {

    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinked = new CircleSingleLinkedList();
        circleSingleLinked.addBoys(4);
        circleSingleLinked.showBoy();
        circleSingleLinked.countBoy(2,2,4);

    }

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {

    // 创建一个first节点,当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoys(int nums) {

        if (nums < 1) {
            System.out.println("nums  值不对！！");
            return;
        }
        //辅助指针，帮助构建环形链表
        Boy curBoy = null;


        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);

            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                boy.setNext(first);
                curBoy.setNext(boy);
                curBoy = boy;
            }
        }

    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("boy's number  %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {// 说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy后移
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        Boy  helper =first;

        while (true){
            if(helper.getNext()==first){
                break;
            }

            helper=helper.getNext();
        }

        //小孩报数前，先让 first 和  helper 移动 k - 1次
        for(int j = 0; j < startNo - 1; j++) {
            first=first.getNext();
            helper=helper.getNext();
        }


        while (true){
            if(helper==first){
                System.out.printf("end boy  %d \n",first.getNo());
                break;
            }

         for(int j = 0; j < countNum-1; j++) {

                 first=first.getNext();
                 helper=helper.getNext();
          }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("boy  %d  out  \n",first.getNo());

            first=first.getNext();
            helper.setNext(first);
        }


    }

}


// 创建一个Boy类，表示一个节点
class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

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

}

