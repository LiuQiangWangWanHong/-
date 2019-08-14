package com.liuq.recursion;

/**
 * Tips:
 *
 * @author Liuq
 * @version 2019年08月13日
 */
public class MiGong {


        public static void main(String[] args) {
            // 先创建一个二维数组，模拟迷宫
            // 地图
            int[][] map = new int[8][7];
            // 使用1 表示墙
            // 上下全部置为1
            for (int i = 0; i < 7; i++) {
                map[0][i] = 1;
                map[7][i] = 1;
            }

            // 左右全部置为1
            for (int i = 0; i < 8; i++) {
                map[i][0] = 1;
                map[i][6] = 1;
            }
            //设置挡板, 1 表示
            map[3][1] = 1;
            map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;

            // 输出地图
            System.out.println("map  situation");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            //使用递归回溯给小球找路
            //setWay(map, 1, 1);
            setWay2(map, 1, 1);

            //输出新的地图, 小球走过，并标识过的递归
            System.out.println("ball go  way !!");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }

    //找路的策略， 上->右->下->左
    //0 表示没有走过   1  表示 是围墙  2  表示已经走过 3  表示无法走通
    public static boolean setWay2(int[][] map, int i, int j) {
            //通路已经找到
            if(map[6][5]==2){
                return true;
            }else {
                if(map[i][j]==0){
                    map[i][j]=2;

                    if(setWay2(map, i-1, j)) {//向上走
                        return true;
                    } else if (setWay2(map, i, j+1)) { //向右走
                        return true;
                    } else if (setWay2(map, i+1, j)) { //向下
                        return true;
                    } else if (setWay2(map, i, j-1)){ // 向左走
                        return true;
                    } else {
                        //说明该点是走不通，是死路
                        map[i][j] = 3;
                        return false;
                    }
                }else{
                    // 如果map[i][j] != 0 , 可能是 1， 2， 3
                    return   false;
                }
            }

        }
}
