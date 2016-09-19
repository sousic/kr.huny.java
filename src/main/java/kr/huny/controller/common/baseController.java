package kr.huny.controller.common;

import kr.huny.utils.PropertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * Created by sousic on 2016. 9. 5..
 */
public abstract class baseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected PropertyHelper propertyHelper;


    @Value("${adminPath}")
    protected String adminPath;

    protected Map<String, Object> resultJson;
}
