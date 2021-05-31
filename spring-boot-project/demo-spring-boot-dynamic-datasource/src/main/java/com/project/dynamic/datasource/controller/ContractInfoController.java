package com.project.dynamic.datasource.controller;


import com.project.dynamic.datasource.entity.oracle.ContractInfo;
import com.project.dynamic.datasource.mapper.ContractInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 合同内容Controller
 * @Author Gentlest
 * @Date 2021/2/27 19:17
 */
@RestController
public class ContractInfoController {

    private final ContractInfoMapper contractInfoMapper;

    @Autowired
    public ContractInfoController(ContractInfoMapper contractInfoMapper) {
        this.contractInfoMapper = contractInfoMapper;
    }

    /**
     * @param contractNum 合同编号
     * @return 合同信息集合
     */
    @GetMapping(value = "/contract/{contractNum}")
    public List<ContractInfo> getContractInfo(@PathVariable(name = "contractNum") String contractNum) {
        return contractInfoMapper.queryContractByNum(contractNum);

    }
}
