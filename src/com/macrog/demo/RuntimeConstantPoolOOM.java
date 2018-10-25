package com.macrog.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M  使用jdk1.6
 * @author guohong
 * @date 2018/10/15
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }

    }
}
