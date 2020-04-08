package com.github.odinggg.tools.controller;


import com.github.odinggg.tools.model.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 描述:
 * all encryption algorithm
 *
 * @author Hansen
 * @version 2020-04-08 16:23
 */

@RestController
@CrossOrigin
@RequestMapping("/secret")
public class SecretController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(SecretController.class);
    private static final String key = "HansenHansen";

    @PostMapping("/encryptionDES")
    public String encryptionDES(@RequestBody Text text) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56, new SecureRandom(key.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(encoded, "DES");
            Cipher des = Cipher.getInstance("DES");
            des.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] bytes = des.doFinal(text.getContent().getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/decryptDES")
    public String decryptDES(@RequestBody Text text) {
        try {
            KeyGenerator kGen = KeyGenerator.getInstance("DES");
            kGen.init(56, new SecureRandom(key.getBytes()));
            SecretKey secretKey = kGen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "DES");
            Cipher cipher = Cipher.getInstance("DES"); // 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(text.getContent())); // 解密
            return new String(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/encryptionAES")
    public String encryptionAES(@RequestBody Text text) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256, new SecureRandom(key.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(encoded, "AES");
            Cipher des = Cipher.getInstance("AES");
            des.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] bytes = des.doFinal(text.getContent().getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/decryptAES")
    public String decryptAES(@RequestBody Text text) {
        try {
            KeyGenerator kGen = KeyGenerator.getInstance("AES");
            kGen.init(256, new SecureRandom(key.getBytes()));
            SecretKey secretKey = kGen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES"); // 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(text.getContent())); // 解密
            return new String(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/encryption3DES")
    public String encryption3DES(@RequestBody Text text) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(168, new SecureRandom(key.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(encoded, "DESede");
            Cipher des = Cipher.getInstance("DESede");
            des.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] bytes = des.doFinal(text.getContent().getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/decrypt3DES")
    public String decrypt3DES(@RequestBody Text text) {
        try {
            KeyGenerator kGen = KeyGenerator.getInstance("DESede");
            kGen.init(168, new SecureRandom(key.getBytes()));
            SecretKey secretKey = kGen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "DESede");
            Cipher cipher = Cipher.getInstance("DESede"); // 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(text.getContent())); // 解密
            return new String(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/encryptionRSA")
    public String encryptionRSA(@RequestBody Text text) {
        try {
            Cipher des = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/decryptRSA")
    public String decryptRSA(@RequestBody Text text) {
        try {
            Cipher des = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/encryptionECC")
    public String encryptionECC(@RequestBody Text text) {
        try {
            Cipher des = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }

    @PostMapping("/decryptECC")
    public String decryptECC(@RequestBody Text text) {
        try {
            Cipher des = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            logger.error("error :", e);
        }
        return "";
    }
}
