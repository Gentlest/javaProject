package com.project.composite.service;

import com.project.composite.entity.ContractInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Gentlest
 * @Date 2021/3/4 11:32
 */
@Service
public interface ContractInfoService {

    /**
     * 根据合同编号查询
     *
     * @param contractNum 合同编号
     * @return 合同信息
     */
    List<ContractInfo> queryContractByContractNum(String contractNum);
    /**
     * 根据提交时间分页查询
     *
     * @param commitTime  提交时间
     * @param currentPage 总页数
     * @param pageSize    每页条数
     * @return 合同信息
     */
    List<ContractInfo> pageQueryContract(String commitTime,String currentPage,String pageSize);
}
