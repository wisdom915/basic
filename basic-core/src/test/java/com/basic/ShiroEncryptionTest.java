package com.basic;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 *  shiro密码加密工具
 */
public class ShiroEncryptionTest {

    public static void main(String[] args) {
        String username = "wangzhi";
        String password = "123456";
        ByteSource byteSource = ByteSource.Util.bytes(username);
        SimpleHash hash = new SimpleHash("MD5", password, byteSource, 1024);
        System.out.println(hash.toString());
    }

    /**
     * 获取加密后的密码，需要指定 hash迭代的次数
     *
     * @param hashAlgorithm  hash算法名称 MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512、etc。
     * @param password       需要加密的密码
     * @param salt           盐
     * @param hashIterations hash迭代的次数
     * @return 加密后的密码
     */ public static String encryptPassword(String hashAlgorithm, String password, String salt, int hashIterations) {
         SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
         return hash.toString();
     }
}
