package gdd.queue.sort;

import sun.jvm.hotspot.oops.Array;

import java.util.Arrays;

/**
 * @author gsd
 * 冒泡排序
 * @date 2021/7/25 7:54 下午
 * @Email:mrguosir@qq.com
 **/
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 800000);
        }
        System.out.println("排序前");
        long startTime = System.currentTimeMillis();
        BubbleSort sorted = new BubbleSort();
        sorted.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);


    }


    public void sort(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            boolean flag = false;
            int temp = 0;
            //每走一躺 都会得到一位数放到数组的右边
            //默认情况下 循环的次数是 n-1次
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    //开始交换
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (!flag) {
                //这里属于对冒泡排序的优化
                //如果没有再发生顺序改变了 则终止排序
                break;
            }
        }
    }
}
