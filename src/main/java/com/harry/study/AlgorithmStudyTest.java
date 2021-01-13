package com.harry.study;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.jupiter.api.Test;

/**
 *
 * 死磕算法
 *
 * @author harry
 * @date 2021/1/13 10:54 上午
 **/
public class AlgorithmStudyTest {

    @Test
    public void test1() {
        String md5 = Md5Crypt.md5Crypt("agdjasdjgasjd".getBytes());
        System.out.println(md5.hashCode());
    }

}
