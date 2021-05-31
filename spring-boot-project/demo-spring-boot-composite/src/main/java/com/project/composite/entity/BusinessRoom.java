package com.project.composite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房屋信息关联表实体类
 *
 * @Author Gentlest
 * @Date 2021/3/4 10:30
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HPMS_ROOM_YW")
public class BusinessRoom {
    /**
     * 主键
     */
    @Id
    @Column(name = "CODE")
    private Integer code;
    /**
     * 唯一标识码
     */

    @Column(name = "OPERATIONCODE")
    private String operationCode;
    /**
     * 房屋ID
     */
    @Column(name = "HISFWID")
    private Integer roomCode;
    /**
     * 幢ID
     */
    @Column(name = "BUILDCODE")
    private Integer buildCode;
    /**
     * 建筑面积
     */
    @Column(name = "JZMJ")
    private BigDecimal area;
    /**
     * 是否主附属
     */
    @Column(name = "ISMAINROOM")
    private Integer isMainRoom;
    /**
     * 创建时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;
}
