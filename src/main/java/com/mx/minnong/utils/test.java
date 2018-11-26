package com.mx.minnong.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/26 15:02
 */
public class test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("sss");


        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            if(it.next().equals("aaa")){
                it.remove();
            }
        }

        for (String str: list
             ) {
            System.out.println(str);
        }


    }
}
