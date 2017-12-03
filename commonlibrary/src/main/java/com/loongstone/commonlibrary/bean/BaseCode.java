package com.loongstone.commonlibrary.bean;

import com.loongstone.commonlibrary.utils.JsonUtils;

/**
 * @author loongstone
 * @date 2017/12/1 14:47
 */
public class BaseCode {
    public static final String PARAMETER_ERROR = "PARAMETER_ERROR";
    public static final String SERVER_ERROR = "SERVER_ERROR";
    public static final String OK = "OK";

    public static BaseResponse<Object> buildErrorBean(String errorCode) {
        BaseResponse<Object> response = new BaseResponse<>();
        switch (errorCode) {
            case PARAMETER_ERROR:
                response.setCode(PARAMETER_ERROR);
                break;
            case SERVER_ERROR:
                response.setCode(SERVER_ERROR);
                break;
            default:
                break;
        }
        return response;
    }

    public static String buildErrorBeanString(String code) {
        return JsonUtils.toJson(buildErrorBean(code));
    }

    public static <T> BaseResponse<T> build(T a) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(a);
        response.setCode(OK);
        return response;
    }
}
