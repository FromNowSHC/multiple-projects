package com.research.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shc
 * @date 2020-01-11
 */
public class TimeClass {


    public static void twentyAndTwelve() {
        // 转换为24小时制    HH
        SimpleDateFormat twenty = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String one = twenty.format(new Date());
        // 转换为12小时制    hh
        SimpleDateFormat twelve = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String two = twelve.format(new Date());
        System.out.println(one + "=========" + two);
    }

    public static void main(String[] args) {
        twentyAndTwelve();
    }
}
