package com.season.common;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:31
 */
public enum CodeMsgEnum {
    SUCCESS(0, "成功"),
    UNKNOWN(-1, "未知错误"),
    USER_REGISTERED(100001, "该用户名已注册"),
    PHONE_REGISTERED(100002, "该手机号已注册"),
    REGISTER_EXCEPTION(100003, "注册失败"),
    EMPTY_USER_AND_PHONE(100004, "用户名及手机号为空"),
    USER_NOT_EXIST(100005, "该用户不存在"),
    PASSWORD_ERROR(100006, "密码错误"),
    USER_LOGOFF(100007, "用户已注销"),

    ADD_RECORD_ERROR(200001, "新增记录失败"),
    MODIFY_RECORD_ERROR(200002, "修改记录失败"),
    DELETE_RECORD_ERROR(200003, "删除记录失败"),
    QUERY_RECORD_ERROR(200004, "查询记录失败");

    private final int code;
    private final String message;

    CodeMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CodeMsgEnum getCodeMsgEnumByCode(int code) {
        for (CodeMsgEnum codeMsgEnum : CodeMsgEnum.values()) {
            if (code == codeMsgEnum.code) {
                return codeMsgEnum;
            }
        }

        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
