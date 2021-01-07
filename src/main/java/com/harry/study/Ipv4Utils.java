package com.harry.study;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Ipv4Utils
 * ipv4识别过程
 * @author harry
 * @date 2021/1/7 6:31 下午
 **/
public class Ipv4Utils {

    public static void main(String[] args) {
        System.out.println(getIpv4());

        System.out.println(validate("0.123.255.21"));
    }

    private static String getIpv4() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            return address.toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 识别字符串是否是ip4
     * @param ip
     * @return
     */
    public static boolean validate(String ip) {
        if (ip == null || "".equals(ip) || ip.length() == 0) {
            return false;
        }
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for (int i = 0; i < ips.length; i++) {
            Integer value;
            try {
                value = Integer.valueOf(ips[i]);
                if (value > -1 && value < 256 && ips[i].equals(value.toString())) {
                    continue;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return  false;
            }
        }
        return true;
    }
}
