package com.bolife.blog.enums;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:37
 * @Description: 友情链接的状态
 */
public enum EnLinkStatus {

    NORMAL(1, "显示"),
    HIDDEN(0, "隐藏");

    private Integer value;

    private String message;

    EnLinkStatus(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
