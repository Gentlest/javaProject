package com.project.jpa.controller;


import com.project.jpa.annotation.ResponseResult;
import com.project.jpa.entity.ContractInfo;
import com.project.jpa.service.ContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Gentlest
 * @Description 合同内容Controller
 * @Date 2021/2/27 19:17
 */
@RestController
@ResponseResult
public class ContractInfoController {

    private final ContractInfoService contractInfoService;

    @Autowired
    public ContractInfoController(ContractInfoService contractInfoService) {
        this.contractInfoService = contractInfoService;
    }

    /**
     * @param contractNum 合同编号
     * @return 合同信息集合
     */
    @GetMapping(value = "/contract/{contractNum}")
    public List<ContractInfo> getContractInfo(@PathVariable(name = "contractNum") String contractNum) {

//        return JSONUtil.toJsonStr(ApiResponse.ofSuccess(StatusEnum.OK.getCode(),
//                StatusEnum.OK.getMessage(),
//                contractInfoService.queryContractByName(contractNum)));
        return contractInfoService.queryContractByName(contractNum);

    }
}
