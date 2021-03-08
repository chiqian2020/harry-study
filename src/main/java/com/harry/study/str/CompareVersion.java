package com.harry.study.str;


/**
 * CompareVersion
 *
 * @author harry
 * @date 2021/3/7 11:11 下午
 **/
public class CompareVersion {

    public static void main(String[] args) {
        String v1 = "2.3.5";
        String v2 = "3.0";
        System.out.println(compareV(v1,v2));
    }

    private static int compareV(String v1, String v2) {
        int v1Length = v1.length();
        int v2Length = v2.length();
        int i = 0;
        int j = 0;
        while (i < v1Length || j<v2Length) {
            int a = 0;
            int b = 0;
        }
        return 0;
    }

}
