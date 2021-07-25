package gdd.queue.queen;

/**
 * @author gsd
 * @date 2021/7/25 2:08 下午
 * @Email:mrguosir@qq.com
 **/
public class Queen8 {

    int max = 8;

    int[] array = new int[max];

    int count;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);

    }

    /**
     * 判断第N个皇后是否与之前的皇后冲突
     *
     * @param n
     * @return
     */
    private boolean jug(int n) {
        for (int i = 0; i < n ; i++) {
            /**
             * 第一个 判断两个是否在同一列上
             * 第二个 判断  两个是否在同一斜线 上 ，俺也弄不懂 为啥这么写就好使，看弹幕说 参考等腰三角形 来理解
             */
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输出数组的元素
     */
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        //结束之后换行
        System.out.println("");
    }

    /**
     * 开始走 八皇后算法
     *
     * @param n
     */
    public void check(int n) {
        //说明已经走到第九个皇后了 就不要再走了
        if (n == max) {
            //此时已经找到了正确的解法 输出一下
            print();
            return;
        }
        //开始循环放皇后
        for (int i = 0; i < max; i++) {
            //先放第一个 先从第一个 格子开始放
            array[n] = i;
            if (jug(n)) {
                //如果不和其他的皇后冲突 则继续往下放
                check(n + 1);
            }
            //如果这里冲突了 则回退到上一步
        }
    }

}
