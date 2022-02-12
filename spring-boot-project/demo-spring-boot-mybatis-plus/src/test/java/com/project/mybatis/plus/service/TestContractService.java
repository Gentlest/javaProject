package com.project.mybatis.plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mybatis.plus.MybatisPlusApplicationTest;
import com.project.mybatis.plus.entity.ContractInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gentlest
 * @Date 2021/3/23 15:21
 */
public class TestContractService extends MybatisPlusApplicationTest {

    @Autowired
    ContractService contractService;

    @Test
    public void testQueryContractByCondition() throws JsonProcessingException {
        QueryWrapper<ContractInfo> wrapper = new QueryWrapper<>();
        ObjectMapper mapper = new ObjectMapper();
        wrapper.eq("htbh", "HG2016-003958");
        Assert.assertNotNull(wrapper);
        List<ContractInfo> contractInfos = contractService.getBaseMapper().selectList(wrapper);
        mapper.writeValueAsString(contractInfos);
        System.out.println(mapper.writeValueAsString(contractInfos));


        String encoder = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(encoder);
    }

    @Test
    public void testQueryContractByCondition2() throws JsonProcessingException {
        QueryWrapper<ContractInfo> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        wrapper.eq("htbh", "HG2016-003958");
        Assert.assertNotNull(wrapper);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", contractService.count(wrapper));
        map.put("data", contractService.getBaseMapper().selectList(wrapper));
        System.out.println(mapper.writeValueAsString(map));
    }
}
