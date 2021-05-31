package com.project.dynamic.datasource.mapper;


import com.project.dynamic.datasource.entity.oracle.ContractInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/27 19:06
 */
@Repository
public interface ContractInfoMapper extends JpaRepository<ContractInfo, Integer> {
    /**
     * 根据姓名查询合同
     *
     * @param contractNum 合同号
     * @return 合同信息集合
     */
    @Query(value = "select c from ContractInfo c where c.contractNum=:contractNum")
    List<ContractInfo> queryContractByNum(@Param("contractNum") String contractNum);

}
