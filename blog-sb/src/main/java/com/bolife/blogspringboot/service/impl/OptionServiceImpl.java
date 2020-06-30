package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Options;
import com.bolife.blogspringboot.mapper.OptionsMapper;
import com.bolife.blogspringboot.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 15:54
 * @Description:
 */
@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionsMapper optionsMapper;
    @Override
    public Options getOptions() {
        return optionsMapper.findOptions();
    }
}
