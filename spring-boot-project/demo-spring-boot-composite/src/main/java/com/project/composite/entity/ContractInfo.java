package com.project.composite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同信息实体类
 *
 * @Author Gentlest
 * @Date 2021/3/4 9:54
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NWRS_SELLBARGAIN")
public class ContractInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "CODE")
    private Integer code;
    /**
     * 合同编号
     */
    @Column(name = "HTBH")
    private String contractNum;
    /**
     * 合同类型
     * 1 预售合同; 2 现售合同
     */
    @Column(name = "B_TYPE")
    private Integer contractType;
    /**
     * 公司名称
     */
    @Column(name = "K_GSMC")
    private String companyName;
    /**
     * 项目名称
     */
    @Column(name = "P_XMMC")
    private String projectName;
    /**
     * 幢名称
     */
    @Column(name = "B_ZMC")
    private String zmc;
    /**
     * 规划用途
     */
    @Column(name = "R_GHYT")
    private String ghyt;
    /**
     * 房屋结构
     */
    @Column(name = "B_JG")
    private String jg;
    /**
     * 合同价格
     */
    @Column(name = "T4_XXZE1")
    private BigDecimal contractPrice;
    /**
     * 合同价格2
     */
    @Column(name = "T4_XXZE2")
    private BigDecimal contractPrice2;
    /**
     * 合同价格3
     */
    @Column(name = "T4_XXZE3")
    private BigDecimal contractPrice3;
    /**
     * 合同状态
     * 6 待备案;2 已备案;3 注销;0 签订
     */
    @Column(name = "STATE")
    private Integer state;
    /**
     * 提交备案时间
     */
    @Column(name = "TIME_TJBA")
    private Date commitTime;
    /**
     * 备案时间
     */
    @Column(name = "TIME_BA")
    private Date recordTime;
    /**
     * 创建时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;
    /**
     * 合同面积
     */
    @Column(name = "HTYDJZMJ")
    private BigDecimal contractArea;
    /**
     * 合同套内面积
     */
    @Column(name = "TNTJZMJ")
    private BigDecimal contractInsideArea;
    /**
     * 合同唯一标识码
     */
    @Column(name = "OPERATIONCODE")
    private String operationCode;
    /**
     * 买受人姓名
     */
    @Column(name = "MSRXM")
    private String buyerName;
    /**
     * 买受人证件号码
     */
    @Column(name = "MSRZJHM")
    private String buyerNum;
    /**
     * 房号
     */
    @Column(name = "R_ROOMNO")
    private String roomNo;
}
