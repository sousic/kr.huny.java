package kr.huny.utils;

import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016-10-17.
 */
public class MediaHelper {
    private static Map<String, MediaType> mediaMap;

    static {
        mediaMap = new HashMap<String, MediaType>();
        mediaMap.put("JPG", MediaType.IMAGE_JPEG);
        mediaMap.put("PNG", MediaType.IMAGE_PNG);
        mediaMap.put("GIF", MediaType.IMAGE_GIF);
    }

    public static MediaType getMediaType(String type)
    {
        return mediaMap.get(type.toUpperCase());
    }
}
