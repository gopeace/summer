package com.season.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 9:55
 */
public class PasswordUtils {
    private final static String SEED_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String newSalt() {
        return RandomStringUtils.random(6, SEED_CHARS);
    }

    public static String encrypt(String salt, String password) {
        String digest = StringUtils.lowerCase(DigestUtils.md5Hex(salt + password));

        char[] chars = digest.toCharArray();
        char[] result = new char[16];

        for (int i = 0; i < result.length; i++) {
            result[i] = i % 2 == 0 ? chars[i * 2 + 1] : chars[i * 2];
        }

        return DigestUtils.sha256Hex(new String(result) + password);
    }

    public static boolean valid(String salt, String password, String encrypted) {

        String originEncrypted = encrypt(salt, password);

        return StringUtils.equals(originEncrypted, encrypted);
    }
}
