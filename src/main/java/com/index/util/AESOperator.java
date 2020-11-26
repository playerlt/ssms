package com.index.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 *
 * @author lhl AES128 算法
 *
 *         CBC 模式
 *
 *         PKCS7Padding 填充模式
 *
 *         CBC模式需要添加一个参数iv
 *
 *         介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding
 *         没有什么区别 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
 */
public class AESOperator {
    // 算法名称
    final String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    final String algorithmStr = "AES/CBC/PKCS7Padding";
    //
    private Key key;
    private Cipher cipher;
    boolean isInited = false;

    //偏移iv 16位的16进制的ASCII码，我这里示例的iv是ABCDEF1234123412，密钥在创建实例时定义
    byte[] iv = { 0x41, 0x42, 0x43, 0x44, 0x45, 0x46,0x31, 0x32, 0x33, 0x34, 0x31, 0x32, 0x33, 0x34, 0x31, 0x32 };

    public void init(byte[] keyBytes) {

        // 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(getInstance());  //这个如果直接new会导致内存泄漏，要使用单例
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(algorithmStr, "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }


    /**
     * 解密方法
     *
     * @param encryptedData
     *            要解密的字符串
     * @param keyBytes
     *            解密密钥
     * @return
     */
    public byte[] decrypt(String encryptedData, byte[] keyBytes) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            //将前端传来的加密数据转换成此方法需要的类型
            byte[] DataByte = Hex.decode(encryptedData);
            //解密
            encryptedText = cipher.doFinal(DataByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }


    //附上一个后台java使用的示例
    public static String getpw(String originpw) {
        //设置AES加密的密钥 16位的16进制的ASCII码，我这里示例是1234123412ABCDEF
        byte[] keybytes = { 0x31, 0x32, 0x33, 0x34, 0x31, 0x32, 0x33, 0x34, 0x31, 0x32, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 };
        //AES创建实例
        AESOperator aes = new AESOperator();


        //解密并输出
        return new String( aes.decrypt(originpw, keybytes));

    }

    private static BouncyCastleProvider bouncyCastleProvider = null;
    public static synchronized BouncyCastleProvider getInstance() {
        if (bouncyCastleProvider == null) {
            bouncyCastleProvider = new BouncyCastleProvider();
        }
        return bouncyCastleProvider;
    }
}
