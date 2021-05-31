package com.project.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "NWRS_SELLBARGAIN")
public class ContractInfo implements Serializable {

    private static final long serialVersionUID = 3193544433052158278L;
    /**
     * 主键
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Integer code;
    /**
     * 合同编号
     */
    @TableField(value = "HTBH")
    private String contractNum;
    /**
     * 合同类型
     * 1 预售合同; 2 现售合同
     */
    @TableField(value = "B_TYPE")
    private Integer contractType;
    /**
     * 公司名称
     */
    @TableField(value = "K_GSMC")
    private String companyName;
    /**
     * 项目名称
     */
    @TableField(value = "P_XMMC")
    private String projectName;
    /**
     * 幢名称
     */
    @TableField(value = "B_ZMC")
    private String zmc;
    /**
     * 规划用途
     */
    @TableField(value = "R_GHYT")
    private String ghyt;
    /**
     * 房屋结构
     */
    @TableField(value = "B_JG")
    private String jg;
    /**
     * 合同价格
     */
    @TableField(value = "T4_XXZE1")
    private BigDecimal contractPrice;
    /**
     * 合同价格2
     */
    @TableField(value = "T4_XXZE2")
    private BigDecimal contractPrice2;
    /**
     * 合同价格3
     */
    @TableField(value = "T4_XXZE3")
    private BigDecimal contractPrice3;
    /**
     * 合同状态
     * 6 待备案;2 已备案;3 注销;0 签订
     */
    @TableField(value = "STATE")
    private Integer state;
    /**
     * 提交备案时间
     */
    @TableField(value = "TIME_TJBA", fill = FieldFill.INSERT_UPDATE)
    private Date commitTime;
    /**
     * 备案时间
     */
    @TableField(value = "TIME_BA", fill = FieldFill.INSERT_UPDATE)
    private Date recordTime;
    /**
     * 创建时间
     */
    @TableField(value = "CREATETIME", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 合同面积
     */
    @TableField(value = "HTYDJZMJ")
    private BigDecimal contractArea;
    /**
     * 合同套内面积
     */
    @TableField(value = "TNTJZMJ")
    private BigDecimal contractInsideArea;
    /**
     * 合同唯一标识码
     */
    @TableField(value = "OPERATIONCODE")
    private String operationCode;
    /**
     * 买受人姓名
     */
    @TableField(value = "MSRXM")
    private String buyerName;
    /**
     * 买受人证件号码
     */
    @TableField(value = "MSRZJHM")
    private String buyerNum;
    /**
     * 房号
     */
    @TableField(value = "R_ROOMNO")
    private String roomNo;
}
