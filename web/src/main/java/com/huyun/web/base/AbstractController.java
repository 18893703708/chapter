package com.huyun.web.base;

import com.huyun.sys.model.User;
import com.huyun.web.shiro.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public User getUser() {
        return ShiroUtils.getUser();
    }

    public Map<String, Object> resultMap = new LinkedHashMap<String, Object>();


}
