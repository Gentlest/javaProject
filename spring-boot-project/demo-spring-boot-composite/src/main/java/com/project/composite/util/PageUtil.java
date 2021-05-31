package com.project.composite.util;

import lombok.Data;

import java.util.List;

/**
 * 分页工具类
 *
 * @Author Gentlest
 * @Date 2021/3/4 12:35
 */
@Data
public class PageUtil<T> {
    /**
     * 总数据量
     */
    private Integer totalRecord;
    /**
     * 当前页数
     */
    private Integer currPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     * 分页数据
     */
    private List<T> data;

    private PageUtil() { //防止被实例化
    }

    /**
     * 设置当前页和每页显示的数量
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @param totalRecord 总记录数
     */
    public PageUtil(Integer currPage, Integer pageSize, Integer totalRecord) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        totalPages = (totalRecord / pageSize == 0) ? (totalRecord / pageSize)
                : (totalRecord / pageSize + 1);
    }
}
