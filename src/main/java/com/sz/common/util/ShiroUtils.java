package com.sz.common.util;

import com.sz.pojo.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {
    public static User getPrincipal(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
