package kr.huny.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by dhjang on 2016-08-17.
 */
public class SHA256HelperTest {
    @Test
    public void encrpyt() throws Exception {
        String plainText = "abcdefg";
        String destText = "7d1a54127b222502f5b79b5fb0803061152a44f92b37e23c6527baf665d4da9a";

        String encrpytText = SHA256Helper.encrpyt(plainText);

        assertThat(destText, is(encrpytText));
    }
}