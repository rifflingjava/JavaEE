/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.common.util.SecurityUtil.java is created on 2007-10-11 下午04:01:21
 */
package org.basic.axis2.common.util;

import org.apache.commons.codec.binary.Hex;

/**
 * 
 */
public class SecurityUtil {

    private static final java.lang.String ALG_END = "}";
    private static final java.lang.String ALG_START = "{";

    private SecurityUtil() {

    }

    /**
     * algorithm: MD5, SHA
     * 
     * @param password
     * @param algorithm
     * @return
     * @throws java.security.NoSuchAlgorithmException
     */
    public static java.lang.String encodePassword(java.lang.String password,
            java.lang.String algorithm) throws java.security.NoSuchAlgorithmException {

        if (password == null) {
            throw new IllegalArgumentException("No password passed");
        }
        java.lang.String result = password.trim();
        if (algorithm == null) {
            return result;
        } else {

            java.security.MessageDigest digest = java.security.MessageDigest.getInstance(algorithm);
            // digest.update(password.getBytes());
            byte digestedPassword[] = digest.digest(password.getBytes());

            java.lang.String base64password = new String(org.apache.commons.codec.binary.Base64
                    .encodeBase64(digestedPassword));

            return (new StringBuilder()).append(ALG_END).append(algorithm).append(ALG_START)
                    .append(base64password).toString();
        }
    }

    public static String encodeBase64(byte[] source) {

        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(source));
    }

    public static void main(String[] args) {

        // String password = "test";
        // String algorithm = "md5";
        // System.out.println(DigestUtils.md5(password.getBytes()));
        // System.out.println(encodeBase64(DigestUtils.md5(password.getBytes())));
        // //
        // java.security.MessageDigest digest;
        // try {
        // digest = java.security.MessageDigest.getInstance(algorithm);
        // // digest.update(password.getBytes());
        // byte digestedPassword[] = digest.digest(password.getBytes());
        //
        // System.out.println(encodeBase64(digestedPassword));
        //
        // } catch (Exception e) {
        // }
        try {
            System.out.println(new String(Hex.decodeHex("61626364".toCharArray())));
            System.out.println(new String(Hex.encodeHex("abcd".getBytes())));
      
            Hex hex = new Hex();
            System.out.println(new String(hex.decode("61626364".getBytes())));
            System.out.println(new String(hex.encode("abcd".getBytes())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
