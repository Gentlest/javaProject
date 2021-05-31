package com.project.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房屋信息关联表实体类
 *
 * @Author Gentlest
 * @Date 2021/3/4 10:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "HPMS_ROOM_YW")
public class BusinessRoom implements Serializable {

    private static final long serialVersionUID = 5578072899157708600L;

    /**
     * 主键
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Integer code;
    /**
     * 唯一标识码
     */
    @TableField(value = "OPERATIONCODE")
    private String operationCode;
    /**
     * 房屋ID
     */
    @TableField(value = "HISFWID")
    private Integer roomCode;
    /**
     * 幢ID
     */
    @TableField(value = "BUILDCODE")
    private Integer buildCode;
    /**
     * 建筑面积
     */
    @TableField(value = "JZMJ")
    private BigDecimal area;
    /**
     * 是否主附属
     */
    @TableField(value = "ISMAINROOM")
    private Integer isMainRoom;
    /**
     * 创建时间
     */
    @TableField(value = "CREATETIME")
    private Date createTime;
}
