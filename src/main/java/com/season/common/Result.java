package com.season.common;

import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:26
 */
public class Result<T> implements Serializable {
    private int code;
    private String message;

    private T data;

    public Result() {

    }

    public Result(CodeMsgEnum codeMsgEnum) {
        this.code = codeMsgEnum.getCode();
        this.message = codeMsgEnum.getMessage();
    }

    public Result(CodeMsgEnum codeMsgEnum, T data) {
        this.code = codeMsgEnum.getCode();
        this.message = codeMsgEnum.getMessage();
        this.data = data;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<T>(CodeMsgEnum.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result(CodeMsgEnum.SUCCESS, data);
    }

    public static <T> Result<T> error(CodeMsgEnum codeMsgEnum) {
        return new Result<T>(codeMsgEnum);
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
