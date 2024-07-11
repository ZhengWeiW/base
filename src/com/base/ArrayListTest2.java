package zcc.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ArrayListTest2
 * @Description TODO
 * @Date 2023/2/12 13:25
 * @Created by ZWW
 */
public class ArrayListTest2 {
     public static void main(String[] args) {
         int[][] arr = new int[2][3];
         arr[0][0] = 3;

         int[][] arr2 = new int[][]{{1,2,3},{2,3,4}};
         System.out.println(arr2);
         System.out.println(Arrays.toString(arr2[1]));
         int[][] arr3 = arr2;
         arr3[1][1] = 5;
         System.out.println(Arrays.toString(arr2[1]));
         System.out.println(Arrays.toString(arr3[1]));

         List list = new ArrayList<>();  // list新增的时候，默认空，添加数据比较his否大于默认长度10  扩容0.5


         /**
          *
          *1.一维数组数组寻址
          * int[] data = new int[5];
          * int[0] 的地址为  0X80000000
          * 求int[4] 的地址  0X80000010
          * 因为int占四个字节，ox表示16进制，因此 0X80000000 + 4*4 = 0X80000010
          *
          * 2.二维数组寻址
          * int[][] data = new int[2][3];初始地址为0X80000000 ,data = {{1,2,3},{4,5,6}}
          * 求data[0][1]的地址
          * 解：
          *     首先需要知道二维数据的存储是以行优先还是列优先
          * 1，行优先   储存方式为   1 2 3 4 5 6
          *     data[0][1] = 0X80000000 + 4*1 =0X80000004  公式new int[i][j]：base_address + data_size * (i * number_of_column + j)
          *
          * 2，列优先   储存方式为   1 4 2 5 3 6
          *     data[0][1] = 0X80000000 + 4*2 =0X80000008  公式new int[i][j]：base_address + data_size * (i + number_of_row * j)
          */


         }

}