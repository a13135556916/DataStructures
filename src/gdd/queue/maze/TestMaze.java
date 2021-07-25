package gdd.queue.maze;

/**
 * @author gsd
 * @date 2021/7/22 4:58 下午
 * @Email:mrguosir@qq.com
 **/
public class TestMaze {

    /**
     * 走迷宫
     * 定义一个规则
     * 0代表从未走过
     * 1代表墙
     * 2代表通撸
     * 3代表死路
     *
     * @param args
     */
    public static void main(String[] args) {
        //定义一个地图
        int[][] map = new int[8][8];
        //为迷宫制造墙
        for (int i = 0; i < 8; i++) {
            //横着的两堵墙
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            //竖着的的两堵墙
            map[i][0] = 1;
            map[i][7] = 1;
        }
        //中间再增加障碍物
        map[3][0] = 1;
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;

        //升级墙
//        map[1][3] = 1;
        map[2][3] = 1;
        //开始走迷宫
        getPerfectWay(map, 1, 1, 6, 1);

        //输出迷宫的样子
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * 走路方法
     * 目标在右下角的走法
     *
     * @param map
     * @param x   从一个点出发
     * @param y
     * @param a   终点
     * @param b
     * @return
     */
    public static boolean setWayA(int[][] map, int x, int y, int a, int b) {
        if (map[a][b] == 2) {
            //说明走到终点了
            return true;
        } else {
            //只有当 x y 都等于0 的时候 才开始走
            if (map[x][y] == 0) {
                //先假设这里是能走的通的，因为是第一个点嘛
                map[x][y] = 2;
                //终点在地图的右下角 所以先手动规划路线 下 右 上 左
                if (setWayA(map, x + 1, y, a, b)) {
                    //向下走
                    return true;
                } else if (setWayA(map, x, y + 1, a, b)) {
                    //向右走
                    return true;
                } else if (setWayA(map, x - 1, y, a, b)) {
                    //向上走
                    return true;
                } else if (setWayA(map, x, y - 1, a, b)) {
                    //向左走
                    return true;
                } else {
                    //此路是死路
                    map[x][y] = 3;
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * 目标在右上角的走法
     *
     * @param map
     * @param x
     * @param y
     * @param a
     * @param b
     * @return
     */
    public static boolean setWayB(int[][] map, int x, int y, int a, int b) {
        if (map[a][b] == 2) {
            //说明走到终点了
            return true;
        } else {
            //只有当 x y 都等于0 的时候 才开始走
            if (map[x][y] == 0) {
                //先假设这里是能走的通的，因为是第一个点嘛
                map[x][y] = 2;
                //终点在地图的右上角 所以先手动规划路线 下 右 上 左
                if (setWayB(map, x - 1, y, a, b)) {
                    //向上走
                    return true;
                } else if (setWayB(map, x, y + 1, a, b)) {
                    //向右走
                    return true;
                } else if (setWayB(map, x + 1, y, a, b)) {
                    //向下走
                    return true;
                } else if (setWayB(map, x, y - 1, a, b)) {
                    //向左走
                    return true;
                } else {
                    //此路是死路
                    map[x][y] = 3;
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * 目标在左上角的走法
     *
     * @param map
     * @param x
     * @param y
     * @param a
     * @param b
     * @return
     */
    public static boolean setWayC(int[][] map, int x, int y, int a, int b) {
        if (map[a][b] == 2) {
            //说明走到终点了
            return true;
        } else {
            //只有当 x y 都等于0 的时候 才开始走
            if (map[x][y] == 0) {
                //先假设这里是能走的通的，因为是第一个点嘛
                map[x][y] = 2;
                //终点在地图的右上角 所以先手动规划路线 下 右 上 左
                if (setWayC(map, x - 1, y, a, b)) {
                    //向上走
                    return true;
                } else if (setWayC(map, x, y - 1, a, b)) {
                    //向左走
                    return true;
                } else if (setWayC(map, x + 1, y, a, b)) {
                    //向下走
                    return true;
                } else if (setWayC(map, x, y + 1, a, b)) {
                    //向右走
                    return true;
                } else {
                    //此路是死路
                    map[x][y] = 3;
                    return false;
                }
            }
            return false;
        }
    }

    /**
     * 目标在左下角的走法
     *
     * @param map
     * @param x
     * @param y
     * @param a
     * @param b
     * @return
     */
    public static boolean setWayD(int[][] map, int x, int y, int a, int b) {
        if (map[a][b] == 2) {
            //说明走到终点了
            return true;
        } else {
            //只有当 x y 都等于0 的时候 才开始走
            if (map[x][y] == 0) {
                //先假设这里是能走的通的，因为是第一个点嘛
                map[x][y] = 2;
                //终点在地图的右上角 所以先手动规划路线 下 右 上 左
                if (setWayD(map, x + 1, y, a, b)) {
                    //向下走
                    return true;
                } else if (setWayD(map, x, y - 1, a, b)) {
                    //向左走
                    return true;
                } else if (setWayD(map, x - 1, y, a, b)) {
                    //向上走
                    return true;
                } else if (setWayD(map, x, y + 1, a, b)) {
                    //向右走
                    return true;
                } else {
                    //此路是死路
                    map[x][y] = 3;
                    return false;
                }
            }
            return false;
        }
    }


    /**
     * 获取最短的路
     * 因为此时只能通过走的方向来决定路径
     * 所以只能把4种走法全部写一遍
     * 但是仍然有问题
     * 因为 右 下 上 左 和 下 右 上 左 在遇到不同障碍的时候走的路是一样的，是一种比较笨逼的写法
     *
     * @param map
     * @param x
     * @param y
     * @param a
     * @param b
     */
    public static void getPerfectWay(int[][] map, int x, int y, int a, int b) {
        if (a >= x && b >= y) {
            //目标在右下角
            setWayA(map, x, y, a, b);
        } else if (a >= x && b <= y) {
            //右上角
            setWayB(map, x, y, a, b);
        } else if (a <= x && b <= x) {
            //左上角
            setWayC(map, x, y, a, b);
        } else if (a <= x && b >= x) {
            //左下角
            setWayD(map, x, y, a, b);
        }

    }

}
