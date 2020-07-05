package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Options;
import com.bolife.blog.mapper.OptionsMapper;
import com.bolife.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 12:10
 * @Description:
 */
@Service
public class OptionsServiceImpl implements OptionsService {
    @Autowired(required = false)
    public OptionsMapper optionsMapper;
    @Override
    public Options getOptions() {
        return optionsMapper.getOptions();
    }
    @Override
    @CacheEvict(value = "default", key = "'options'")
    public void insertOptions(Options options) {
        optionsMapper.insert(options);
    }

    @Override
    @CacheEvict(value = "default", key = "'options'")
    public void updateOptions(Options options) {
        optionsMapper.update(options);
    }
}
