package com.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Long a = 1000l;
        Long b = 1000l;
        System.out.printf(String.valueOf(a==b));
        HashMap hashmap = new HashMap();
        Object put = hashmap.put(1, "1");
        Object put1 = hashmap.put(1, "2");
        System.out.println("------"+put+"-------");
        System.out.println("------"+put1+"-------");
        Set set = new HashSet();
        System.out.println("------"+set.add("1")+"-------");
        System.out.println("------"+set.add("1")+"-------");


        int i = 1;
        i++;
        ++i;
        System.out.println("------"+(i+ ++i * i++));


        int h = 2;
        System.out.println(h << 16);


        // 输入的日期字符串
        String dateStr = "2024-09-25 19:17:00";

        // 定义输入的日期格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 解析字符串为 LocalDateTime 对象
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, inputFormatter);

        // 定义目标输出的日期格式，使用西班牙语 Locale
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d 'de' MMM 'de' yyyy, HH:mm", new Locale("es", "ES"));

        // 格式化 LocalDateTime 对象为目标格式的字符串
        String formattedDate = dateTime.format(outputFormatter);

        // 输出结果
        System.out.println(formattedDate);  // 输出: 25 de sep. de 2024, 19:17

        String str = "1256"; // 示例字符串
        str = padWithAsterisks(str, 9); // 让字符串达到 9 位

        System.out.println("补齐后的字符串: " + str); // 输出补齐后的字符串

        // 使用补齐后的字符串进行后续处理
        StringBuilder accountNo = new StringBuilder();
        accountNo.append("***")
                .append(str.substring(3, 6))  // 获取 3 到 6 之间的字符
                .append(",")
                .append(str.substring(6, 9))  // 获取 6 到 9 之间的字符
                .append(",")
                .append("***");

        System.out.println(accountNo.toString()); // 输出: ***456,789,***
    }

    /**
     * 用 * 号补充字符串至指定长度
     * @param str 原字符串
     * @param length 目标长度
     * @return 补充后的字符串
     */
    public static String padWithAsterisks(String str, int length) {
        // 如果字符串长度小于目标长度
        if (str.length() < length) {
            StringBuilder sb = new StringBuilder();
            // 计算需要补充的 * 的数量
            int asterisksToAdd = length - str.length();
            // 追加 * 号
            for (int i = 0; i < asterisksToAdd; i++) {
                sb.append('*');
            }
            // 添加原字符串
            sb.append(str);
            return sb.toString();
        }
        // 如果不需要补充，直接返回原字符串
        return str;
    }
}
