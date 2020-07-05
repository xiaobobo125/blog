package com.bolife.blog.enums;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 16:02
 * @Description:
 */
public enum EnRole {
    ADMIN(1, "博主"),
    VISITOR(0, "访客");

    private Integer value;

    private String message;

    EnRole(Integer value, String message) {
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
