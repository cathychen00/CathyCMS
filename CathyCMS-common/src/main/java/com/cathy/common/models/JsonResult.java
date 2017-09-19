package com.cathy.common.models;

/**
 * Created by 陈敬 on 17/9/19.
 */
public class JsonResult<T> {
    private int returncode;
    private String message;
    private T result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
