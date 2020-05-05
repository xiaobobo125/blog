package com.bolife.blog.enums;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:13
 * @Description:
 */
public enum EnArticleStatus {
    PUBLISH(1,"已发布"),
    DRAFT(0,"草稿");
    private Integer value;
    private String describe;
    EnArticleStatus(Integer value, String describe) {
        this.value = value;
        this.describe = describe;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
