package com.project.mybatis.mapper;

import com.project.mybatis.entity.ContractInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/28 13:32
 */
@Mapper
@Component
public interface ContractInfoMapper {

    /**
     * 根据合同编号查询合同信息
     *
     * @param contractNum 合同编号
     * @return 返回合同信息
     */
    @Select("select * from NWRS_SELLBARGAIN where HTBH =#{contractNum}")
    @Results(value = {
            @Result(property = "buyerName", column = "msrxm"),
            @Result(property = "buyerNum", column = "msrzjhm"),
            @Result(property = "contractNum", column = "htbh"),
            @Result(property = "contractArea", column = "htydjzmj")
    })
    List<ContractInfo> queryContractByNum(@Param("contractNum") String contractNum);

    /**
     * 根据姓名查询合同信息
     * @param contractName 买受人
     * @return 返回合同信息
     */
    ContractInfo queryContractByName(@Param("contractName") String contractName);
}
