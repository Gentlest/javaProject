package com.project.jpa.service.impl;


import com.project.jpa.dao.ContractInfoDao;
import com.project.jpa.entity.ContractInfo;
import com.project.jpa.service.ContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/27 19:08
 */
@Service
public class ContractInfoServiceImpl implements ContractInfoService {

    private final ContractInfoDao contractInfoDao;

    @Autowired
    public ContractInfoServiceImpl(ContractInfoDao contractInfoDao) {
        this.contractInfoDao = contractInfoDao;
    }

    @Override
    public List<ContractInfo> queryContractByName(String contractNum) {

        if (contractNum.isEmpty()) {
            return Collections.emptyList();
        }
        return contractInfoDao.queryContractByNum(contractNum);


    }
}
