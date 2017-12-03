package com.loongstone.commonlibrary.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法(使用org.apache.commons.codec.binary.Base64做转码以及辅助加密)
 * @author loongstone
 */
public class AESUtil {

    //TODO 待改进
    private static String iv = "0102030405060708";

    // 加密
    public static String Encrypt(String sSrc, String key) throws Exception {
        if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = key.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");
        //使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));

        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return new String(Base64.encodeBase64(encrypted), "UTF-8");
    }

    // 解密
    public static String Decrypt(String sSrc, String key) throws Exception {
        try {
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = key.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");
            IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
            //先用Base64解密
            byte[] encrypted1 = Base64.decodeBase64(sSrc.getBytes("UTF-8"));
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "UTF-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}