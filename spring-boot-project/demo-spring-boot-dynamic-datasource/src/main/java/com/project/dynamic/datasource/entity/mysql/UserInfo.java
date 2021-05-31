package com.project.dynamic.datasource.entity.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author Gentlest
 * @Description 合同信息实体类
 * @Date 2021/2/27 15:15
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "test_user")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 合同编号
     */
    @Column(name = "name")
    private String tName;
    /**
     * 买受人姓名
     */
    @Column(name = "password", nullable = false)
    private String tPassword;

}
