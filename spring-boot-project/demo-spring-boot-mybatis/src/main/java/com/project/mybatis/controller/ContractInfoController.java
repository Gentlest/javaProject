package com.project.mybatis.controller;

import cn.hutool.json.JSONUtil;
import com.project.mybatis.entity.ContractInfo;
import com.project.mybatis.mapper.ContractInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/28 13:48
 */
@RestController
@Slf4j
public class ContractInfoController {

    private final ContractInfoMapper contractInfoMapper;

    @Autowired
    public ContractInfoController(ContractInfoMapper contractInfoMapper) {
        this.contractInfoMapper = contractInfoMapper;
    }

    @GetMapping(value = "/contract")
    public String getContractByNum(@RequestParam("contractNum") String contractNum) {

        return JSONUtil.toJsonStr(contractInfoMapper.queryContractByNum(contractNum));

    }

    @PostMapping(value = "/contractInfo")
    public ContractInfo getContractByName(@RequestParam("name") String name) {


        return contractInfoMapper.queryContractByName(name);
    }
}
