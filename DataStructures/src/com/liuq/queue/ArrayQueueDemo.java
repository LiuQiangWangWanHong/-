package com.liuq.queue;

import java.util.Scanner;

/**
 * Tips:  顺序队列
 *
 * @author Liuq
 * @version 2019年08月01日
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        com.liuq.queue.ArrayQueue queue = new com.liuq.queue.ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show) : show  queue");
            System.out.println("e(exit) : exit  program");
            System.out.println("a(add)  : add  a  data to queue");
            System.out.println("g(get)  : get a data from queue");
            System.out.println("h(head) : show  header data  from queue ");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("input a  value ");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("get a  data  is %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("queue head data is %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("exit ~~");
    }
}




class ArrayQueue {
    private int maxSize;
    private int frontDel;
    private int rearAdd;
    private int[] arr;

    public  ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        frontDel=-1;
        rearAdd=-1;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return rearAdd==maxSize-1;
    }

    public boolean isEmpty(){
        return rearAdd==frontDel;
    }

    public   void addQueue(int value){
        if(isFull()){
            System.out.println("queue  is  full ");
            return;
        }
        rearAdd++;
        arr[rearAdd]=value;
    }

    public int getQueue(){
        if(isEmpty()){

            throw new RuntimeException(" queue  is  empty ，can not get data");
        }
        frontDel++;
        int value=arr[frontDel];
        arr[frontDel]=0;
        return value;
    }

    public  void showQueue(){
        if(isEmpty()){
            System.out.println("queue is empty  ");
        }
        for(int i = 0; i < arr.length; i++) {
             System.out.println("arr["+i+"]"+":"+arr[i]);

        }
    }

    public  int headQueue(){
        if(isEmpty()){
            throw new RuntimeException(" queue  is  empty ，can not get data");
        }

        return arr[frontDel+1];
    }


}


