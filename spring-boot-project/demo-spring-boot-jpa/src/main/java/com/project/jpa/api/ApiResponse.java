package com.project.jpa.api;


import com.project.jpa.constant.StatusEnum;
import com.project.jpa.exception.BaseException;
import lombok.Data;

/**
 * @Author Gentlest
 * @Description 通用Api接口封装
 * @Date 2021/2/25 12:58
 */
@Data
public class ApiResponse {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    private ApiResponse() {
    }

    private ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @param code    状态码
     * @param message 内容
     * @param data    请求内容
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * @param code    状态码
     * @param message 内容
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Integer code, String message) {
        return ofSuccess(code, message, null);
    }

    /**
     * @param status 状态码 {@link StatusEnum}
     * @param data   请求内容
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(StatusEnum status, Object data) {
        return ofSuccess(status.getCode(), status.getMessage(), data);
    }

    /**
     * @param status 状态码 {@link StatusEnum}
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(StatusEnum status) {
        return ofStatus(status, null);

    }

    /**
     * @param t    异常
     * @param data 返回数据
     * @param <T>  {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return ofSuccess(t.getCode(), t.getMessage(), data);
    }

    /**
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }
}
