package com.zero.cr.utils;

import com.zero.cr.vo.ResponseBean;
import com.zero.cr.vo.ResponseBeanEnum;

/**
 * @author Mr.H
 * @className ResponseBeanUtil
 * @Date 2018/8/22 21:06
 * @Version v1.0
 */
public class ResponseBeanUtil {

    private ResponseBeanUtil(){}

    /**
     * 数据交互成功返回
     *
     * @param object json返回的数据
     */
    public static ResponseBean success(Object object) {
        if (object == null) {
            object = "";
        }
        return new ResponseBean(ResponseBeanEnum.SUCCESS.getCode(), ResponseBeanEnum.SUCCESS.getMsg(), object);
    }

    /**
     * 数据交互(数据没有找到)
     */
    public static ResponseBean notFound() {
        return new ResponseBean(ResponseBeanEnum.NOT_FOUND.getCode(), ResponseBeanEnum.NOT_FOUND.getMsg(), "");
    }

    /**
     * 参数异常
     */
    public static ResponseBean parameterError() {
        return new ResponseBean(ResponseBeanEnum.PARAMETER_ERROR.getCode(), ResponseBeanEnum.PARAMETER_ERROR.getMsg(), "");
    }

    /**
     * 系统异常
     */
    public static ResponseBean systemError() {
        return new ResponseBean(ResponseBeanEnum.ERROR.getCode(), ResponseBeanEnum.ERROR.getMsg(), "");
    }

}
