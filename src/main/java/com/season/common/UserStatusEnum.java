package com.season.common;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 10:32
 */
public enum  UserStatusEnum {
    LOGOFF((byte)0, "已注销"),
    NORMAL((byte)1, "正常");

    private final byte status;
    private final String desc;

    UserStatusEnum(byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public byte getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
