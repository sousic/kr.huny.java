package kr.huny.utils;

import java.security.MessageDigest;

/**
 * Created by dhjang on 2016-08-17.
 * 출처 : http://18281818.tistory.com/83
 */
public class SHA256Helper {
    public static String encrpyt(String planText)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(planText.getBytes());
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i <byteData.length;i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            StringBuffer hexString = new StringBuffer();
            for(int i =0; i < byteData.length;i++)
            {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw  new RuntimeException();
        }
    }
}
