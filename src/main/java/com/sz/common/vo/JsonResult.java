package com.sz.common.vo;

import java.io.Serializable;

/**
 * VO:通过此对象实现控制层数据的封装操作
 * 规范：控制层返回的所有数据只要不是页面，必须通过此对象进行封装
 */
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 5625785243032753752L;
    /**状态码：1表示正确，0表示错误*/
    private int state = 1;//1表示SUCCESS,0表示ERROR
    /**状态信息：状态码对应的信息*/
    private String message = "ok";
    /**正确数据：要显示的*/
    private Object data;

    public JsonResult() {}

    public JsonResult(String message) {
        this.message = message;
    }

    /**一般查询时调用，封装查询结果*/
    public JsonResult(Object data) {
        this.data = data;
    }

    /**出现异常时调用*/
    public JsonResult(Throwable t) {
        this.state = 0;
        this.message = t.getMessage();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
