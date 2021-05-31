package com.project.composite.common;


import com.project.composite.constant.ResultCode;
import lombok.Data;

/**
 * 返回Api封装
 *
 * @Author Gentlest
 * @Date 2021/3/2 11:04
 */
@Data
public class ResultVo {

    private Integer code;

    private String message;

    private Object data;

    private ResultVo() {
    }

    private ResultVo(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    private ResultVo(Object data) {
        this(ResultCode.SUCCESS, data);
    }

    public static ResultVo success() {

        return new ResultVo(ResultCode.SUCCESS);
    }

    public static ResultVo success(Object data) {

        return new ResultVo(ResultCode.SUCCESS, data);
    }


    public static ResultVo failure(ResultCode resultCode) {
        return new ResultVo(resultCode);
    }

    public static ResultVo failure(ResultCode resultCode, Object data) {
        return new ResultVo(resultCode,data);
    }
}
