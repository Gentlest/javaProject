package com.project.composite.mapper;

import com.project.composite.entity.ContractInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gentlest
 * @Date 2021/3/4 11:30
 */
@Repository
public interface ContractInfoMapper extends JpaRepository<ContractInfo, Integer> {

    /**
     * 根据合同编号查询
     *
     * @param contractNum 合同编号
     * @return 合同信息
     */
    @Query(value = "select c from ContractInfo c where c.contractNum =:contractNum")
    List<ContractInfo> queryContractByContractNum(@Param("contractNum") String contractNum);

    /**
     * 根据提交时间分页查询
     *
     * @param commitTime  提交时间
     * @param currentPage 总页数
     * @param pageSize    每页条数
     * @return 合同信息
     */
    @Query(value = "select t.* from (select rownum as rowno,c.* from NWRS_SELLBARGAIN c where to_char(c.TIME_TJBA," +
            "'yyyyMMdd') " +
            "=:commitTime " +
            "and rownum <=:currentPage order by c.CREATETIME desc) t " +
            "where t.rowno >=:pageSize", nativeQuery = true)
    List<ContractInfo> pageQueryContract(@Param("commitTime") String commitTime,
                                         @Param("currentPage") String currentPage,
                                         @Param("pageSize") String pageSize);
}
