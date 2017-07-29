package me.ilvc.yunso.base.controller;

import me.ilvc.yunso.base.common.Const;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: iLvc
 * @Date：Create in 14:36 2017/7/23
 * @Description:    BaseController
 * @Modified By:
 */
public abstract class BaseController {

    /**
     * 获取保存在Session中的用户对象
     * @param request
     * @param <T>
     * @return
     */
    protected <T> T getSessionUser(HttpServletRequest request) {
        return (T) request.getSession().getAttribute(Const.SESSION_USER);
    }

}
