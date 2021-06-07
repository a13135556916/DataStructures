import java.io.*;

/**
 * @author gsd
 * 数据结构与算法的第一节课
 * 本节内容的重点是数据结构
 * @date 2021/5/29 3:53 下午
 * @Email:mrguosir@qq.com
 **/
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //声明一个二维数组
        int[][] chess = new int[11][11];
        chess [1][2] = 1;
        chess [2][3] = 2;
        chess [4][6] = 2;
        System.out.println("首次格式化输出数组");
        //遍历行
        for (int[] row : chess) {
            //遍历行里的元素
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println("\n");
        }
        System.out.println("将其转化为稀疏数组----");

        int sum = 0;
        //获取有效数据
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j]!=0) {
                    sum++;
                }
            }
        }
        System.out.println("有效数据:"+sum);

        /**
         * 二维数组的行数sum+1的原因是因为
         * 二维数组的第一行存储的是
         * 行数 列数 有效数据
         */
        int count = 1;
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chess[i][j];
                    count++;
                }
            }
        }
        System.out.println("开始输出转化后的稀疏数组~~~~~~~~~");

        printArray(sparseArr);

        System.out.println("最后再将其转化为二维数组");
        //初始化普通数组
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("最后的二维数组--------------");
        printArray(arr);
        System.out.println("很高兴的说，我全靠记忆力完成了练习");

        File file = new File("/Users/dongdongguo/test/a");
        //文件写入流
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                out.write(sparseArr[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();

        System.out.println("开始文件读取");

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        int[][] newArr = new int[4][3];
        count = 0;
        while ((line=in.readLine())!=null) {
            String[] split = line.split("\t");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"\t"+" "+i);
                newArr[count][i] = Integer.parseInt(split[i]);
            }
            count++;
        }
        System.out.println("读取后的结果");
        printArray(newArr);
    }

    /**
     * 输出数组
     * @param array
     */
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            //遍历行里的元素
            for (int item : row) {
                System.out.printf("%d\t",item);
            }
            System.out.println("\n");
        }
    }





}
