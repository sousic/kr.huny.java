package kr.huny.utils;

/**
 * Created by sousic on 2016-11-08.
 */
public class NaviHelper {
    public static String activeNavi(String org, String desc, String activeCss, String nonActiveCss)
    {
        if(org.equals(desc))
        {
            return activeCss;
        }
        return nonActiveCss;
    }
}
