package kr.huny.controller.common;

import kr.huny.utils.PropertyHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sousic on 2016. 9. 5..
 */
public abstract class baseController {

    @Autowired
    protected PropertyHelper propertyHelper;
}
