package com.project.composite.service.impl;

import com.project.composite.entity.ContractInfo;
import com.project.composite.mapper.ContractInfoMapper;
import com.project.composite.service.ContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author Gentlest
 * @Date 2021/3/4 11:32
 */
@Service
public class ContractInfoServiceImpl implements ContractInfoService {

    private final ContractInfoMapper contractInfoMapper;

    @Autowired
    public ContractInfoServiceImpl(ContractInfoMapper contractInfoMapper) {
        this.contractInfoMapper = contractInfoMapper;
    }

    @Override
    public List<ContractInfo> queryContractByContractNum(String contractNum) {

        if (contractNum.isEmpty()) {
            return Collections.emptyList();
        }
        return contractInfoMapper.queryContractByContractNum(contractNum);
    }
    /**
     * 根据提交时间分页查询
     *
     * @param commitTime  提交时间
     * @param currentPage 总页数
     * @param pageSize    每页条数
     * @return 合同信息
     */
    @Override
    public List<ContractInfo> pageQueryContract(String commitTime, String currentPage, String pageSize) {
        return contractInfoMapper.pageQueryContract(commitTime, currentPage, pageSize);
    }
}
