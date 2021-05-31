package com.project.mybatis.plus.common;

import com.project.mybatis.plus.constant.ResultCode;
import com.project.mybatis.plus.exception.BusinessException;
import lombok.Data;

/**
 * 统一返回结果集实体类
 *
 * @Author Gentlest
 * @Date 2021/3/23 13:28
 */
@Data
public class ResultVo {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回值
     */
    private Object data;


    private ResultVo() {  // 防止被实例化
    }

    private ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义Api返回
     *
     * @param code 状态码
     * @param msg  提示消息
     * @param data 返回值
     * @return ResultVo
     */
    private static ResultVo ofResult(Integer code, String msg, Object data) {
        return new ResultVo(code, msg, data);
    }

    /**
     * 有状态且带数据的API返回
     *
     * @param resultCode 状态枚举
     * @param data       返回值
     * @return ResultVo
     */
    public static ResultVo ofStatus(ResultCode resultCode, Object data) {
        return ofResult(resultCode.getCode(), resultCode.getMsg(), data);
    }

    /**
     * 成功且自定义消息的API返回
     *
     * @param msg 提示消息
     * @return ResultVo
     */
    public static ResultVo ofMessage(String msg) {
        return ofResult(ResultCode.SUCCESS.getCode(), msg, null);
    }

    /**
     * 成功且带数据的API返回
     *
     * @param data 返回值
     * @return ResultVo
     */
    public static ResultVo ofSuccess(Object data) {
        return ofStatus(ResultCode.SUCCESS, data);
    }

    /**
     * 有状态的API返回
     *
     * @param resultCode 状态码
     * @return ResultVo
     */
    public static ResultVo ofStatus(ResultCode resultCode) {
        return ofStatus(resultCode, null);
    }

    /**
     * 异常且带数据的API返回
     *
     * @param t    异常
     * @param data 返回值
     * @param <T>  {@link BusinessException}的子类
     * @return ResultVo
     */
    public static <T extends BusinessException> ResultVo ofError(T t, Object data) {
        return ofResult(t.getErrorCode(), t.getErrorMsg(), data);
    }

    /**
     * 异常且不带数据的API返回
     *
     * @param t   异常
     * @param <T> {@link BusinessException}的子类
     * @return ResultVo
     */
    public static <T extends BusinessException> ResultVo ofError(T t) {
        return ofError(t, null);
    }

}
