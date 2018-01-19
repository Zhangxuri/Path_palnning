package com.heitian.ssm.utils;

import net.sf.json.JSONArray;
import java.io.IOException;
import java.util.ArrayList;

public class Calc {
    public static JSONArray calc(String str) throws IOException {
        System.out.println(str);
        System.out.println("Start....");
        String[] len = str.split("\n");
        System.out.println(len.length+"changdu");
        Tabu tabu = new Tabu(len.length, 10000, 200, 20);
        tabu.init(str);
        long t1 = System.currentTimeMillis();
        tabu.solve();
        System.out.println();
        System.out.println("计算用时：" + (System.currentTimeMillis() - t1));

        int[] best=tabu.getBestGh();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < best.length; i++) {
            list.add(best[i]);
        }
        //将list装换为Json数组（JSONArray）
        JSONArray arry = JSONArray.fromObject(list);
        System.out.println("-------\n"+arry.toString()+"-------\n");
        return arry;
    }
}
