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
 * 房屋信息实体类
 *
 * @Author Gentlest
 * @Date 2021/3/4 10:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "HPMS_ROOM")
public class RoomInfo implements Serializable {

    private static final long serialVersionUID = 3724080364606973084L;
    /**
     * 主键
     */
    @TableId(value = "CODE", type = IdType.AUTO)
    private Integer code;
    /**
     * 房号
     */
    @TableField(value = "ROOMNO")
    private String roomNo;
    /**
     * 房屋坐落
     */
    @TableField(value = "FWZL")
    private String roomLocation;
    /**
     * 规划用途
     */
    @TableField(value = "GHYT")
    private String ghyt;
    /**
     * 房屋类型
     */
    @TableField(value = "FWLX")
    private String roomType;
    /**
     * 房屋户型
     */
    @TableField(value = "FWHX")
    private String fwhx;
    /**
     * 房屋性质
     */
    @TableField(value = "FWXZ")
    private String roomProperty;
    /**
     * 预测面积
     */
    @TableField(value = "YCJZMJ")
    private BigDecimal ycjzmj;
    /**
     * 实测面积
     */
    @TableField(value = "SCJZMJ")
    private BigDecimal scjzmj;
    /**
     * 预测套内面积
     */
    @TableField(value = "YCTNMJ")
    private BigDecimal yctnmj;
    /**
     * 实测套内面积
     */
    @TableField(value = "SCTNMJ")
    private BigDecimal sctnmj;
    /**
     * 预测分摊面积
     */
    @TableField(value = "YCFTMJ")
    private BigDecimal ycftmj;
    /**
     * 实测分摊面积
     */
    @TableField(value = "SCFTMJ")
    private BigDecimal scftmj;
    /**
     * 是否可售
     * 0 不可售; 1 可售
     */
    private Integer cansell;
    /**
     * 单价
     */
    @TableField(value = "PRICE")
    private BigDecimal price;
    /**
     * 幢ID
     */
    @TableField(value = "BUILDCODE")
    private Integer buildCode;
    /**
     * 房屋编号
     */
    @TableField(value = "HISFWID")
    private String roomCode;
    /**
     * 是否主户室
     * 1 是; 0 否
     */
    @TableField(value = "ISMAINROOM")
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
    @TableField(value = "STATE")
    private Integer state;
    /**
     * 乐观锁
     */
    @TableField(value = "VERSON")
    private Integer verson;
    /**
     * 创建时间
     */
    @TableField(value = "CREATETIME")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(value = "CREATEUSER")
    private Integer createUser;
    /**
     * 修改时间
     */
    @TableField(value = "LASTMODIFYTIME")
    private Object lastModifyTime;

    private String syqzh;
    /**
     * 手工销售状态
     * 1 是;0 否
     */
    @TableField(value = "SGSZZT")
    private Integer sgszzt;
    /**
     * 阳台个数
     */
    @TableField(value = "YTGS")
    private Integer ytgs;
    /**
     * 房屋朝向
     */
    @TableField(value = "CX")
    private String cx;
    /**
     * 备案价
     */
    @TableField(value = "ZJ")
    private Integer totalPrice;
    /**
     * 装修标准
     */
    @TableField(value = "ZXBZ")
    private String zxbz;
    /**
     * 单元号
     */
    @TableField(value = "FLOORNAME")
    private Integer unitName;
    /**
     * 所在层
     */
    @TableField(value = "FLOORNAME")
    private String floorName;
    /**
     * 是否配套设施
     */
    @TableField(value = "SFGGPT")
    private Integer sfggpt;
}
