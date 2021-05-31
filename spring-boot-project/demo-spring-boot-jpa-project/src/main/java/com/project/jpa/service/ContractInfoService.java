package com.project.jpa.service;

import com.project.jpa.entity.ContractInfo;

import java.util.List;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/27 19:07
 */
public interface ContractInfoService {

    /**
     * 根据姓名查询合同
     *
     * @param contractNum 合同号
     * @return 合同信息集合
     */
    List<ContractInfo> queryContractByName(String contractNum);

}
