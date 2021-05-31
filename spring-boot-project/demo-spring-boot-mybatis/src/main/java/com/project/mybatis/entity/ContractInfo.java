package com.project.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Gentlest
 * @Description 合同信息实体类
 * @Date 2021/2/28 13:23
 */

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContractInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 合同编号
     */
    private String contractNum;
    /**
     * 买受人
     */
    private String buyerName;
    /**
     * 买受人证件号码
     */
    private String buyerNum;
    /**
     * 合同面积
     */
    private BigDecimal contractArea;

}
