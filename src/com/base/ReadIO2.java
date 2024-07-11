package com.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadIO2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\zhengww\\Desktop\\ES\\315050_20240606.log"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("DpSubAcctQuery.qrySubAcctList begin >>>>>>>>>>>>>>>>[DpQuerySubAcctListIn{cust_no=,")) {
                    System.out.println("包含字符串\"-------\"的行：" + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
