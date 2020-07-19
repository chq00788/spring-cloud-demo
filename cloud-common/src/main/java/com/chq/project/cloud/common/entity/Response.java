package com.chq.project.cloud.common.entity;




import com.chq.project.cloud.common.enums.ResponseEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求返回实体类
 *
 * @author : CHQ
 * @date : 2019-05-15
 **/
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 6138979130005367537L;

    /**
     * 请求结果
     */
    private boolean success = true;

    /**
     * 请求结果编码
     */
    private Integer code;
    /**
     * 请求内容
     */
    private T result;
    /**
     * 请求提示
     */
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }


    public T getResult() {
        return result;
    }

    /**
     * 请求成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok(T data) {
        Response<T> resp = new Response<>();
        resp.setResult(data);
        resp.setCode(200);
        return resp;
    }

    /**
     * 请求成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok(T data, String msg) {
        Response<T> resp = new Response<>();
        resp.setResult(data);
        resp.setCode(200);
        resp.setMsg(msg);
        return resp;
    }

    /**
     * 请求成功
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> ok() {
        return Response.ok(null);
    }

    /**
     * 请求失败
     *
     * @param responseEnum
     * @param <T>
     * @return
     */
    public static <T> Response<T> fail(ResponseEnum responseEnum) {
        Response<T> resp = new Response<>();
        resp.setSuccess(false);
        resp.setMsg(responseEnum.getMsg());
        resp.setCode(responseEnum.getCode());
        return resp;
    }

    /**
     * 请求失败
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Response<T> fail(String msg) {
        Response<T> resp = new Response<>();
        resp.setSuccess(false);
        resp.setMsg(msg);
        resp.setCode(500);
        return resp;
    }

    /**
     * 请求失败
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Response<T> fail(Integer code, String msg) {
        Response<T> resp = new Response<>();
        resp.setSuccess(false);
        resp.setMsg(msg);
        resp.setCode(code);
        return resp;
    }

    public void setError(String error) {
        this.success = false;
        this.code = 500;
        this.msg = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", code=" + code +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }

}

