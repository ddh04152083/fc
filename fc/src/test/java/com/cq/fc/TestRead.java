package com.cq.fc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class TestRead {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("d://classifymetadata.txt"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while((line=reader.readLine())!=null){
                   List<Object> a= Arrays.asList(line.split(" "));
                     System.out.println(a);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
