package com.project.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author Gentlest
 * @Description 合同信息实体类
 * @Date 2021/2/27 18:57
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "nwrs_sellbargain")
public class ContractInfo {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer code;

    /**
     * 合同编号
     */
    @Column(name = "htbh", columnDefinition = "varchar(50) comment '合同编号'")
    private String contractNum;

    /**
     * 买受人姓名
     */
    @Column(name = "msrxm", columnDefinition = "varchar(100) comment '买受人姓名'")
    private String buyerName;

    /**
     * 买受人证件号码
     */
    @Column(name = "msrzjhm")
    private String buyerNum;

    /**
     * 合同面积
     */
    @Column(name = "htydjzmj")
    private BigDecimal contractArea;

    /**
     * 合同价格1
     */
    @Column(name = "t4_xxze1")
    private BigDecimal contractPrice;
    /**
     * 合同价格2
     */
    @Column(name = "t4_xxze2")
    private BigDecimal contractPrice2;
    /**
     * 合同价格1
     */
    @Column(name = "t4_xxze3")
    private BigDecimal contractPrice3;

}
