package com.project.composite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房屋信息实体类
 *
 * @Author Gentlest
 * @Date 2021/3/4 10:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HPMS_ROOM")
public class RoomInfo {
    /**
     * 主键
     */
    @Column(name = "CODE")
    private Integer code;
    /**
     * 房号
     */
    @Column(name = "ROOMNO")
    private String roomNo;
    /**
     * 房屋坐落
     */
    @Column(name = "FWZL")
    private String roomLocation;
    /**
     * 规划用途
     */
    @Column(name = "GHYT")
    private String ghyt;
    /**
     * 房屋类型
     */
    @Column(name = "FWLX")
    private String roomType;
    /**
     * 房屋户型
     */
    @Column(name = "FWHX")
    private String fwhx;
    /**
     * 房屋性质
     */
    @Column(name = "FWXZ")
    private String roomProperty;
    /**
     * 预测面积
     */
    @Column(name = "YCJZMJ")
    private BigDecimal ycjzmj;
    /**
     * 实测面积
     */
    @Column(name = "SCJZMJ")
    private BigDecimal scjzmj;
    /**
     * 预测套内面积
     */
    @Column(name = "YCTNMJ")
    private BigDecimal yctnmj;
    /**
     * 实测套内面积
     */
    @Column(name = "SCTNMJ")
    private BigDecimal sctnmj;
    /**
     * 预测分摊面积
     */
    @Column(name = "YCFTMJ")
    private BigDecimal ycftmj;
    /**
     * 实测分摊面积
     */
    @Column(name = "SCFTMJ")
    private BigDecimal scftmj;
    /**
     * 是否可售
     * 0 不可售; 1 可售
     */
    private Integer cansell;
    /**
     * 单价
     */
    @Column(name = "PRICE")
    private BigDecimal price;
    /**
     * 幢ID
     */
    @Column(name = "BUILDCODE")
    private Integer buildcode;
    /**
     * 房屋编号
     */
    @Column(name = "HISFWID")
    private String roomCode;
    /**
     * 是否主户室
     * 1 是; 0 否
     */
    @Column(name = "ISMAINROOM")
    private Integer ismainroom;
    /**
     * 是否审核
     * 1 已审核;0 未审核
     */
    private Integer checkedtype;
    /**
     * 是否自用房
     * 1 是;0 否
     */
    private Integer iskeep;
    /**
     * 是否生效
     * 1 是;0 否
     */
    @Column(name = "STATE")
    private Integer state;
    /**
     * 乐观锁
     */
    @Column(name = "VERSON")
    private Integer verson;
    /**
     * 创建时间
     */
    @Column(name = "CREATETIME")
    private Date createTime;
    /**
     * 创建人
     */
    @Column(name = "CREATEUSER")
    private Integer createUser;
    /**
     * 修改时间
     */
    @Column(name = "LASTMODIFYTIME")
    private Object lastModifyTime;

    private String syqzh;
    /**
     * 手工销售状态
     * 1 是;0 否
     */
    @Column(name = "SGSZZT")
    private Integer sgszzt;
    /**
     * 阳台个数
     */
    @Column(name = "YTGS")
    private Integer ytgs;
    /**
     * 房屋朝向
     */
    @Column(name = "CX")
    private String cx;
    /**
     * 备案价
     */
    @Column(name = "ZJ")
    private Integer totalPrice;
    /**
     * 装修标准
     */
    @Column(name = "ZXBZ")
    private String zxbz;
    /**
     * 单元号
     */
    @Column(name = "FLOORNAME")
    private Integer unitName;
    /**
     * 所在层
     */
    @Column(name = "FLOORNAME")
    private String floorName;
    /**
     * 是否配套设施
     */
    @Column(name = "SFGGPT")
    private Integer sfggpt;
}
