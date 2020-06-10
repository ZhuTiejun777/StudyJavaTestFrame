package TeaseOutKnowledge.thirdly;

import java.util.Scanner;

/**
 * 数据类型[][] 变量名 = new 数据类型[m][n]；
 * m表示这个二维数组有多少个一维数组
 * n表示每一个一维数组的元素个数
 *
 * int[][] arr = new int[3][2];
 * 定义了一个二维数组arr
 * 这个二维数组有3个一维数组，名称是arr[0],arr[1],arr[2]
 * 每个一维数组有2个元素，可以通过arr[m][n]来获取
 * 表示获取第m+1个一维数组的第n+1个元素
 *
 * 二维数组还有两种格式：
 * 格式2：数据类型[][] 变量名 = new 数据类型[m][];
 * 格式3：数据类型[][] 变量名 = {{元素…},{元素…},{元素…}};
 */

/**
 * 需求：打印杨辉三角形
 *     1
 *     1 1
 *     1 2 1
 *     1 3 3 1
 *     1 4 6 4 1
 *     1 5 10 10 5 1
 * 分析：看这种图像的规律
 *     A:任何一行的第一列和最后一列都是1
 *     B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
 * 步骤：
 *         A:首先定义一个二维数组。行数如果是n，我们把列数也先定义为n。这个n的数据来自于键盘录入。
 *         B:给这个二维数组任何一行的第一列和最后一列赋值为1
 *         C:按照规律给其他元素赋值从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
 *         D:遍历这个二维数组。
 */


public class DoubleArray {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //这个n的数据来自于键盘录入。
        System.out.println("请输入一个数据：");
        int n = sc.nextInt();

        //定义二维数组
        int[][] arr = new int[n][n];

        //给这个二维数组任何一行的第一列和最后一列赋值为1
        for(int x=0; x<arr.length; x++) {
            arr[x][0] = 1; //任何一行第1列
            arr[x][x] = 1; //任何一行的最后1列
        }

        //按照规律给其他元素赋值
        //从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
        for(int x=2; x<arr.length; x++) {
            //这里如果y<=x是有个小问题的，就是最后一列的问题
            //所以这里要减去1
            //并且y也应该从1开始，因为第一列也是有值了
            for(int y=1; y<=x-1; y++) {
                //每一个数据是它上一行的前一列和它上一行的本列之和。
                arr[x][y] = arr[x-1][y-1] + arr[x-1][y];
            }
        }

        //遍历这个二维数组。
        /*
        for(int x=0; x<arr.length; x++) {
            for(int y=0; y<arr[x].length; y++) {
                System.out.print(arr[x][y]+"\t");
            }
            System.out.println();
        }
        */

        //这个时候，要注意了，内循环的变化必须和曾经讲过的九九乘法表类似
        for(int x=0; x<arr.length; x++) {
            for(int y=0; y<=x; y++) {
                System.out.print(arr[x][y]+"\t");
            }
            System.out.println();
        }
    }
}

