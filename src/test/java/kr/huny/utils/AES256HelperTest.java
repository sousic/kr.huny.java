package kr.huny.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by dhjang on 2016-08-17.
 */
public class AES256HelperTest {
    String key = "a1b2c3d4!@#$qwer";
    String userpwd = "abcdefg1234!";

    @Test
    public void EncDecTest() throws Exception {
        AES256Helper aes256Helper = new AES256Helper(key);

        String enUserPwd = aes256Helper.encrypt(userpwd);
        System.out.println(enUserPwd);
        String decUserPwd = aes256Helper.decrpyt(enUserPwd);
        assertThat(userpwd, is(decUserPwd));
    }
}