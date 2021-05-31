package com.project.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Gentlest
 * @Date 2021/3/25 14:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "XTSZ_USER")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 5157215020490144329L;

    @TableId(value = "CODE", type = IdType.AUTO)
    private Integer code;

    @TableField(value = "DLMC")
    private String username;

    @TableField(value = "DLMM")
    private String password;

}
