package com.bolife.blog.service;

import com.bolife.blog.entity.Options;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 12:07
 * @Description: 页脚信息显示
 */

public interface OptionsService {
    /***
     * 获取页脚信息
     * @return
     */
    public Options getOptions();
    /**
     * 新建基本信息
     *
     * @param options 系统设置
     */
    void insertOptions(Options options);

    /**
     * 更新基本信息
     *
     * @param options 系统设置
     */
    void updateOptions(Options options);
}
