package com.cq.fc.utils;

import com.cq.fc.domain.Classified_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataUtils {
    public static List<Classified_data> findAll() {
        List<Classified_data> lists=new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("d://classifymetadata.txt"));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                List<Object> a= Arrays.asList(line.split(" "));
                Classified_data c = new Classified_data();
//                private long user_id;
//                private long product_id;
//                private long user_review_count;
//                private double rating;
//                private long year;
//                private long month;
//                private long day;
//                @Size(max = 20)
//                @Column(nullable = false, length = 20)
//                private String label;
                   c.setUser_id((long)a.get(0));
                   c.setProduct_id((long)a.get(1));
                   c.setUser_review_count((long)a.get(2));
                   c.setRating((double)a.get(3));
                   c.setYear((long)a.get(4));
                   c.setMonth((long)a.get(5));
                   c.setDay((long)a.get(6));
                   c.setLabel((String) a.get(7));
                   lists.add(c);
////                System.out.println(line);
//
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

}
