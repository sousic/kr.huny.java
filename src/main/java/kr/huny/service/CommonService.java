package kr.huny.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by sousic on 2016-11-09.
 */
@Slf4j
@Service
public class CommonService {

    /**
     * ResourceBundle 에서 메시지 가져오기
     * @param locale
     * @param bundle
     * @param getString
     * @param params
     * @return
     */
    public String getResourceBundleMessage(Locale locale, String bundle, String getString, Object... params)
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, locale);
        return MessageFormat.format(resourceBundle.getString(getString), params);
    }
}
