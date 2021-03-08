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
        String v2 = "2.3.5";
        System.out.println(compareV(v1,v2));
    }

    private static int compareV(String v1, String v2) {
        String[] version1 = v1.split("\\.");
        String[] version2 = v2.split("\\.");
        for (int i = 0,j = 0;i < version1.length || j< version2.length;i++,j++) {
            int n1 = i < version1.length?Integer.valueOf(version1[i]):0;
            int n2 = j < version2.length?Integer.valueOf(version2[i]):0;
            if (n1 == n2) {
                continue;
            } else {
                return n1 > n2?1:-1;
            }
        }
        return 0;
    }

}
