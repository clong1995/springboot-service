package com.zoolon.issue.result;

/**
 * @author Joetao
 * 状态码
 * Created by jt on 2018/3/8.
 */
public enum ResultCode {
    /*
    请求返回状态码和说明信息
     */
    SUCCESS(0, "成功"),

    BAD_REQUEST(400, "不理解请求的语法"),
    UNAUTHORIZED(401, "未授权身份验证"),
    LOGIN_ERROR(402, "未认证的身份"),
    FORBIDDEN(403, "拒绝请求"),
    NOT_FOUND(404, "找不到请求的资源"),
    OPERATE_ERROR(405, "禁用请求中指定的方法"),
    TIME_OUT(408, "等候请求时发生超时"),
    SERVER_ERROR(500, "服务器内部错误"),
    DUPLICATE_KEY(500100, "重复主键");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
