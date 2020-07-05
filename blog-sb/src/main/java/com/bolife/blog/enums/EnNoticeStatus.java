package com.bolife.blog.enums;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:00
 * @Description:
 */
public enum EnNoticeStatus {
    NORMAL(1, "显示"),
    HIDDEN(0, "隐藏");

    private Integer status;
    private String describe;

    EnNoticeStatus(Integer status, String describe) {
        this.status = status;
        this.describe = describe;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
